package com.lastdance.project.class_support.model.dao;


import com.lastdance.project.class_support.model.dto.StudentAttendanceDTO;

import java.util.List;
import java.util.Map;

public interface StudentAttendanceDAO {
    // 전체 출석 기록을 조회하는 메서드
    List<StudentAttendanceDTO> getAllStudentAttendances();

    // 특정 출석 기록을 가져오는 메서드 (학생 번호로 조회)
    StudentAttendanceDTO getStudentAttendanceById(int stuAttendance_no);

    // 새로운 출석 기록을 추가하는 메서드
    int insertStudentAttendance(StudentAttendanceDTO studentAttendanceDTO);

    // 출석 기록을 업데이트하는 메서드
    int updateStudentAttendance(StudentAttendanceDTO studentAttendanceDTO);

    // 출석 기록을 삭제하는 메서드
    int deleteStudentAttendance(int stuAttendance_no);
    // 모든 학생 출석 정보를 조회하는 메서드
    List<StudentAttendanceDTO> getAttendanceSummaryByDateAndClass(Map<String, Object> params);
}
