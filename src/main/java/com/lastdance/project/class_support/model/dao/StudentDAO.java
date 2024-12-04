package com.lastdance.project.class_support.model.dao;

import com.lastdance.project.class_support.model.dto.StudentDTO;

import java.util.List;

public interface StudentDAO {
    // 모든 학생 정보 조회
    List<StudentDTO> getAllStudents();

    // 학생 정보 조회 (member_no 기준)
    StudentDTO getStudentByMemberNo(int member_no);

    // 새로운 학생 정보 추가
    int insertStudent(StudentDTO studentDTO);

    // 학생 정보 수정
    int updateStudent(StudentDTO studentDTO);

    // 학생 정보 삭제
    int deleteStudent(int member_no);

}
