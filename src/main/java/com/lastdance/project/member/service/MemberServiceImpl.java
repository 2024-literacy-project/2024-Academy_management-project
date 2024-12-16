package com.lastdance.project.member.service;

import com.lastdance.project.member.model.dao.MemberDAO;
import com.lastdance.project.member.model.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements com.lastdance.project.member.service.MemberService {

    private final MemberDAO memberDAO;

    @Autowired
    public MemberServiceImpl(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    /* member 조회 */
    public List<MemberDTO> getAllMembers(){
        return memberDAO.getAllMembers();
    }


}
