package com.lastdance.project.class_support.model.dao;

import com.lastdance.project.class_support.model.dto.ClassDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassDAO {

    // 모든 클래스 정보 조회
    List<ClassDTO> getAllClasses();

    // 클래스 정보 조회 (class_no 기준)
    ClassDTO getClassByClassNo(int class_no);

    // 새로운 클래스 추가
    int insertClass(ClassDTO classDTO);

    // 클래스 정보 수정
    int updateClass(ClassDTO classDTO);

    // 클래스 정보 삭제
    int deleteClass(int class_no);
    // 추가: 클래스번호로 담당 직원 member_no 조회
    int getTeacherMemberNoByClassNo(@Param("classNo") int classNo);
}
