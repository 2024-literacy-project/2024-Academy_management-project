package com.lastdance.project.class_support.service;

import com.lastdance.project.class_support.model.dao.StudentAttendanceDAO;
import com.lastdance.project.class_support.model.dao.StudentClassDAO;
import com.lastdance.project.class_support.model.dto.ClassDTO;
import com.lastdance.project.class_support.model.dto.StudentAttendanceDTO;
import com.lastdance.project.class_support.model.dto.StudentClassDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentAttendanceService {

    private final StudentAttendanceDAO studentAttendanceDao;  // 카멜 케이스로 변수명 수정
    private final StudentClassDAO studentClassDao;

    @Autowired
    public StudentAttendanceService(StudentAttendanceDAO studentAttendanceDao, StudentClassDAO studentClassDao) {
        this.studentAttendanceDao = studentAttendanceDao;
        this.studentClassDao = studentClassDao;
    }

    // 모든 학생 출석 정보를 가져옴
    public List<StudentAttendanceDTO> getAllStudentAttendances() {
        return studentAttendanceDao.getAllStudentAttendances();
    }

    // 특정 학생의 출석 정보를 ID를 통해 가져옴
    public StudentAttendanceDTO getStudentAttendanceById(int stu_attendance_no) {
        return studentAttendanceDao.getStudentAttendanceById(stu_attendance_no);
    }

    // 학생 출석 정보 추가
    public int addStudentAttendance(StudentAttendanceDTO studentAttendanceDto) {
        return studentAttendanceDao.insertStudentAttendance(studentAttendanceDto);
    }

    // 학생 출석 정보 수정
    public int updateStudentAttendance(StudentAttendanceDTO studentAttendanceDto) {
        return studentAttendanceDao.updateStudentAttendance(studentAttendanceDto);
    }

    // 학생 출석 정보 삭제
    public int deleteStudentAttendance(int stuAttendance_no) {
        return studentAttendanceDao.deleteStudentAttendance(stuAttendance_no);
    }

    // 특정 클래스에 속한 학생 목록을 가져옴
    public List<StudentClassDTO> getStudentsByClass(int class_no) {
        return studentClassDao.getStudentsByClass(class_no);
    }

    // 출석 정보를 저장 (출석 기록이 존재하면 업데이트하고, 존재하지 않으면 새로 추가)
    public void saveAttendance(List<StudentAttendanceDTO> attendanceList) {
        for (StudentAttendanceDTO attendance : attendanceList) {
            // 출석 정보가 이미 존재하는지 확인하고, 존재하면 업데이트, 그렇지 않으면 삽입
            StudentAttendanceDTO existingAttendance = studentAttendanceDao.getStudentAttendanceById(attendance.getStu_attendance_no());
            if (existingAttendance != null) {
                studentAttendanceDao.updateStudentAttendance(attendance);
            } else {
                studentAttendanceDao.insertStudentAttendance(attendance);
            }
        }
    }

    // 모든 클래스 정보를 가져옴
    public List<ClassDTO> getAllClasses() {
        return studentClassDao.getAllClasses();
    }


    // UI에서 간단히 사용할 클래스 정보를 가져옴
    public List<ClassDTO> getAllClassesForUI() {
        return studentClassDao.getAllClassesForUI(); // MyBatis에서 간단한 데이터를 바로 가져오도록 수정
    }


    public List<StudentAttendanceDTO> getAttendanceSummaryByDateAndClass(Date date, int class_no) {
        Map<String, Object> params = new HashMap<>();
        params.put("date", date);
        params.put("class_no", class_no);
        return studentAttendanceDao.getAttendanceSummaryByDateAndClass(params);
    }

}
