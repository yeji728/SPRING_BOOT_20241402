package com.example.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.domain.Member;
import com.example.demo.model.dto.MemberForm;
import com.example.demo.model.dto.MemberResponse;
import com.example.demo.model.dto.RoleRequest;
import com.example.demo.model.service.MemberService;

@RestController // 관리자 회원 관리 API (JSON)
@RequestMapping("/api/admin/members") // 주소는 하나, 할 일은 메서드로 구분
public class AdminApiController {
    @Autowired
    MemberService memberService;
    //전체 회원 목록 조회
    @GetMapping // 회원 목록 : GET /api/admin/members
    public List<MemberResponse> list(
            @RequestParam(name = "keyword", required = false) String keyword) {
        List<Member> members = memberService.searchMembers(keyword);
        return members.stream().map(MemberResponse::from).toList();
    }
    //회원 1명만 조회
    @GetMapping("/{id}") // 회원 1명 : GET /api/admin/members/3 <-특정 회원 아이디 명시
    public ResponseEntity<MemberResponse> get(@PathVariable Long id) {
        return memberService.findById(id)
            .map(member -> ResponseEntity.ok(MemberResponse.from(member))) // 있으면 200 OK
            .orElse(ResponseEntity.notFound().build()); // 없으면 404
    }
    @PostMapping // 회원 등록 : POST /api/admin/members (본문 JSON → MemberForm)
    public ResponseEntity<?> create(@RequestBody MemberForm form) {
        Member saved = memberService.signup(form);
        return ResponseEntity
            .created(URI.create("/api/admin/members/" + saved.getId()))
            .body(MemberResponse.from(saved));
    }

    @PatchMapping("/{id}/role") // 권한 변경 : PATCH /api/admin/members/3/role {"role":"ADMIN"}
    public ResponseEntity<?> changeRole(@PathVariable Long id, @RequestBody RoleRequest request) {
        Member member = memberService.changeRole(id, request.role());
        return ResponseEntity.ok(MemberResponse.from(member));
    }
    @DeleteMapping("/{id}") // 회원 삭제 : DELETE /api/admin/members/3
    public ResponseEntity<?> delete(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }

    // [7주차 연습문제] 공통 오류 처리
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleError(IllegalArgumentException e) {
        return ResponseEntity.badRequest()
            .body(Map.of("error", e.getMessage()));
    }
}
