package com.lastdance.project.member2.controller;

import com.lastdance.project.member2.model.MemberDTO2;
import com.lastdance.project.member2.service.MemberService2;
import com.lastdance.project.member2.service.MemberServiceImpl2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController2 {

    @Autowired
    private MemberService2 memberService2;
    @Autowired
    private MemberServiceImpl2 memberServiceImpl2;

    // 학생 아이디 고정
    private final String fixedId = "chulsoo";

    @GetMapping("/student/info")
    public String studentInfo(Model model) {

        MemberDTO2 memberDTO2 = memberServiceImpl2.getStudentInfo(fixedId);

        model.addAttribute("studentInfo", memberDTO2);

        return "student/info";
    }
}
