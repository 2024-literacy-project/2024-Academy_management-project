package com.lastdance.project.class_support.controller;

import com.lastdance.project.class_support.model.dto.StudentAttendanceDTO;
import com.lastdance.project.class_support.model.dto.StudentClassDTO;
import com.lastdance.project.class_support.model.dto.ClassDTO;
import com.lastdance.project.class_support.service.StudentAttendanceService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/class_support")
public class AttendanceController {

    private final StudentAttendanceService studentAttendanceService;

    // 생성자 주입을 사용하여 StudentAttendanceService 주입
    public AttendanceController(StudentAttendanceService studentAttendanceService) {
        this.studentAttendanceService = studentAttendanceService;
    }

    @GetMapping("/classAttendanceList")
    public String classAttendanceList(Model model) {
        List<ClassDTO> classList = studentAttendanceService.getAllClasses(); // 모든 클래스 목록을 가져옴
        model.addAttribute("classList", classList); // 클래스 목록을 모델에 추가
        return "class_support/classAttendanceList"; // 템플릿 위치와 맞는지 확인
    }

    @GetMapping("/class/{class_no}/students")
    @ResponseBody
    public List<StudentClassDTO> getStudentsByClassAjax(@PathVariable("class_no") int class_no) {
        return studentAttendanceService.getStudentsByClass(class_no);
    }

    @PostMapping("/class/{class_no}/saveAttendance")
    public String saveAttendance(@PathVariable("class_no") int class_no, @RequestBody List<StudentAttendanceDTO> attendanceList) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String currentTime = timeFormat.format(new Date());

        for (StudentAttendanceDTO attendance : attendanceList) {
            if (attendance.getStu_attendance_status() == null) {
                attendance.setStu_attendance_status("결석"); // 기본 값 설정
            }
            if (attendance.getStu_attendance_date() == null) {
                attendance.setStu_attendance_date(new java.util.Date()); // 출석 날짜 기본값 설정 (오늘 날짜)
            }
            if (attendance.getAttendance_time() == null) {
                attendance.setAttendance_time(currentTime); // 등원 시간 기본값 설정 (현재 시간)
            }
        }
        studentAttendanceService.saveAttendance(attendanceList);
        return "redirect:/class_support/classAttendanceList";
    }






}


