package com.lastdance.project.member2.service;


import com.lastdance.project.member2.model.MemberDAO2;
import com.lastdance.project.member2.model.MemberDTO2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl2 implements MemberService2 {

    @Autowired
    private MemberDAO2 memberDAO2;

    @Override
    public MemberDTO2 getStudentInfo(String id) {
        return memberDAO2.getStudentInfo(id);
    }

}
