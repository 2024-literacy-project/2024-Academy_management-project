package com.lastdance.project.member.controller;

import com.lastdance.project.member.model.MemberDTO;
import com.lastdance.project.member.service.MemberService;
import com.lastdance.project.member.service.MemberServiceImpl;
import com.lastdance.project.planner.model.PlannerDTO;
import com.lastdance.project.planner.service.PlannerService;
import com.lastdance.project.planner.service.PlannerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberServiceImpl memberServiceImpl;

    // 학생 아이디 고정
    private final String fixedId = "chulsoo";

    @GetMapping("/student/info")
    public String studentInfo(Model model) {

        MemberDTO memberDTO = memberServiceImpl.getStudentInfo(fixedId);

        model.addAttribute("studentInfo", memberDTO);

        return "student/info";
    }
}
