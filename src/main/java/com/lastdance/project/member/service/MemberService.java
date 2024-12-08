package com.lastdance.project.member.service;

import com.lastdance.project.member.model.dto.MemberDTO;

import java.util.List;

public interface MemberService {

    /* member 조회 */
    List<MemberDTO> getAllMembers();

}
