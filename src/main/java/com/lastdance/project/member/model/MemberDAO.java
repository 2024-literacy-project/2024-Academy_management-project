package com.lastdance.project.member.model;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberDAO {

    MemberDTO getStudentInfo(String id);
}
