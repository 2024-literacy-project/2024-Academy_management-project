package com.lastdance.project.class_support.model.dao;

import com.lastdance.project.class_support.model.dto.GradeDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GradeDAO {
    // 성적 등록
    int insertGrade(GradeDTO gradeDTO);

    // 성적 조회 (클래스 기준)
    List<GradeDTO> getGradesByClass(Map<String, Object> params);

    // 성적 삭제
    int deleteGrade(@Param("testNo") int testNo, @Param("memberNo") int memberNo);
    int updateGrade(GradeDTO gradeDTO);

    int addClassTest(@Param("classNo") int classNo, @Param("testNo") int testNo, @Param("memberNo") int memberNo);
    int addStudentTest(@Param("testNo") int testNo, @Param("memberNo") int memberNo);
}
