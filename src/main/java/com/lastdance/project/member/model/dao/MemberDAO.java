package com.lastdance.project.member.model.dao;

import com.lastdance.project.member.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberDAO {

    /* member 조회 */
    List<MemberDTO> getAllMembers();



}
