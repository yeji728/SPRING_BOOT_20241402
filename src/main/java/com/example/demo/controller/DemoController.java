package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.domain.TestDB;
import com.example.demo.model.service.TestService;

import java.util.List;

@Controller
public class DemoController {

    // 클래스 하단 작성
    @Autowired
    TestService testService; // DemoController 클래스 아래 객체 주입
    //컨트롤러 어노테이션 명시
    @GetMapping("/hello")
    public String hello(Model model){ //전송방식 GET
        model.addAttribute("data", "반갑습니다."); //model 설정
        return "hello"; //hello.html 연결
    }
    @GetMapping("/hello2")
    public String hello2(Model model){ //전송방식 GET
        model.addAttribute("data", "홍길동님.");
        model.addAttribute("data2", "방갑습니다.");
        model.addAttribute("data3", "오늘.");
        model.addAttribute("data4", "날씨는."); //model 설정
        model.addAttribute("data5", "매우 좋습니다.");
        return "hello2"; //hello.html 연결
    }


    // 하단에 맵핑 이어서 추가
    @GetMapping("/testdb")
        public String getAllTestDBs(Model model) {
            // List<TestDB> users = testService.findAll();
            // model.addAttribute("users", users);
        TestDB test = testService.findByName("홍길동");
        model.addAttribute("user", test);
        System.out.println("데이터 출력 디버그 : " + test);
        return "testdb";
    }
}
