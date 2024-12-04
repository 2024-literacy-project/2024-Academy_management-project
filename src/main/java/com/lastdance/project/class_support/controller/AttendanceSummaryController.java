package com.lastdance.project.class_support.controller;

import com.lastdance.project.class_support.model.dto.StudentAttendanceDTO;
import com.lastdance.project.class_support.model.dto.ClassDTO;
import com.lastdance.project.class_support.service.StudentAttendanceService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/class_support")
public class AttendanceSummaryController {

    private final StudentAttendanceService studentAttendanceService;

    public AttendanceSummaryController(StudentAttendanceService studentAttendanceService) {
        this.studentAttendanceService = studentAttendanceService;
    }

    @GetMapping("/attendanceSummary")
    public String getAttendanceSummary(
            @RequestParam(value = "class_no", required = false, defaultValue = "-1") int class_no,
            @RequestParam(value = "date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            Model model) {

        System.out.println("Received class_no: " + class_no);
        System.out.println("Received date: " + date);

        if (class_no == -1 || date == null) {
            throw new IllegalArgumentException("class_no와 date는 유효해야 합니다.");
        }

        // 출석 정보 및 클래스 목록 가져오기
        List<StudentAttendanceDTO> attendanceList = studentAttendanceService.getAttendanceSummaryByDateAndClass(date, class_no);
        List<ClassDTO> classList = studentAttendanceService.getAllClassesForUI();

        // 모델에 데이터 추가
        model.addAttribute("attendanceList", attendanceList);
        model.addAttribute("classList", classList);
        model.addAttribute("class_no", class_no);
        model.addAttribute("date", date);

        return "class_support/attendanceSummary";
    }
}
