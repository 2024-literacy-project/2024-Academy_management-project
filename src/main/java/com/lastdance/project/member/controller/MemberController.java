package com.lastdance.project.member.controller;

import com.lastdance.project.member.model.dto.MemberDTO;
import com.lastdance.project.member.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/memberList")
public class MemberController {

    private final MemberServiceImpl memberServiceImpl;

    @Autowired
    public MemberController(MemberServiceImpl memberServiceImpl){
        this.memberServiceImpl = memberServiceImpl;
    }

    /* member 조회 */
    @GetMapping
    public String getAllMembers(Model model){
        List<MemberDTO> memberList = memberServiceImpl.getAllMembers();
        model.addAttribute("memberList", memberList);
        return "memberList/memberList";
    }

//    private final MemberService memberService;
//
//    @Autowired
//    public MemberController(MemberService memberService) {
//        this.memberService = memberService;
//    }
//
//    @GetMapping("memberList")
//    public String getAllmembers(Model model){
//        List<MemberDTO> memberList = memberService.getAllMembers();
//        model.addAttribute("memberList", memberList);
//        return "member/memberList";
//    }
}
