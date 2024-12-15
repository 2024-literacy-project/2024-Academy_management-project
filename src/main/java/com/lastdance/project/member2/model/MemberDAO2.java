package com.lastdance.project.member2.model;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDAO2 {

    /* member 조회 */
    MemberDTO2 getStudentInfo(String id);

}
