package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller public class DemoController{ //컨트롤러 어노테이션 명시
    @GetMapping("/hello")
    public String hello(Model model){ //전송방식 GET
        model.addAttribute("data", "반갑습니다."); //model 설정
        return "hello"; //hello.html 연결
    }
}