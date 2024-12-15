package com.lastdance.project.member.service;

import com.lastdance.project.member.model.MemberDAO;
import com.lastdance.project.member.model.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDAO memberDAO;

    @Override
    public MemberDTO getStudentInfo(String id) {
        return memberDAO.getStudentInfo(id);
    }

}
