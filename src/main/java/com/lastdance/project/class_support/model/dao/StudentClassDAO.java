package com.lastdance.project.class_support.model.dao;

import com.lastdance.project.class_support.model.dto.ClassDTO;
import com.lastdance.project.class_support.model.dto.StudentClassDTO;

import java.util.List;

public interface StudentClassDAO {

    // 모든 학생-클래스 정보 조회
    List<StudentClassDTO> getAllStudentClasses();

    // 특정 학생의 클래스 목록 조회 (member_no 기준)
    List<StudentClassDTO> getClassesByStudent(int member_no);

    // 특정 클래스에 등록된 학생 목록 조회 (class_no 기준)
    List<StudentClassDTO> getStudentsByClass(int class_no);

    // 학생-클래스 등록
    int insertStudentClass(StudentClassDTO studentClassDTO);

    // 학생-클래스 등록 해제
    int deleteStudentClass(int member_no, int class_no);
    // 모든 클래스 정보 조회
    List<ClassDTO> getAllClasses();  // 추가된 메서드
    // UI에 필요한 간단한 클래스 정보만 가져오는 새 메소드
    List<ClassDTO> getAllClassesForUI();
}
