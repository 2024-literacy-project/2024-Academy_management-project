package com.lastdance.project.class_support.controller;

import com.lastdance.project.class_support.model.dto.StudentAttendanceDTO;
import com.lastdance.project.class_support.model.dto.ClassDTO;
import com.lastdance.project.class_support.service.StudentAttendanceService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/class_support")
public class AttendanceSummaryController {

    private final StudentAttendanceService studentAttendanceService;

    public AttendanceSummaryController(StudentAttendanceService studentAttendanceService) {
        this.studentAttendanceService = studentAttendanceService;
    }

@GetMapping("/attendanceSummaryData")
@ResponseBody
public Map<String, Object> getAttendanceSummaryData(
        @RequestParam(value = "class_no", required = true) int class_no,
        @RequestParam(value = "date", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {

    // 서비스 호출 및 데이터 처리
    List<StudentAttendanceDTO> attendanceList = studentAttendanceService.getAttendanceSummaryByDateAndClass(date, class_no);
    List<ClassDTO> classList = studentAttendanceService.getAllClassesForUI();

    // 디버깅용 로그
    System.out.println("Attendance List Size: " + attendanceList.size());
    System.out.println("Attendance List Data: " + attendanceList);

    // 출석 상태별 데이터 처리
    long presentCount = attendanceList.stream().filter(a -> "출석".equals(a.getStu_attendance_status())).count();
    long absentCount = attendanceList.stream().filter(a -> "결석".equals(a.getStu_attendance_status())).count();
    long earlyLeaveCount = attendanceList.stream().filter(a -> "조퇴".equals(a.getStu_attendance_status())).count();
    long lateCount = attendanceList.stream().filter(a -> "지각".equals(a.getStu_attendance_status())).count(); // 지각자 계산

    // 총원 계산
    int totalStudents = attendanceList.size();

    // JSON 응답 준비
    Map<String, Object> response = new HashMap<>();
    response.put("attendanceList", attendanceList); // 출석 데이터
    response.put("classList", classList);           // 클래스 데이터
    response.put("totalStudents", totalStudents);   // 총원 데이터
    response.put("presentCount", presentCount);     // 출석자 수
    response.put("absentCount", absentCount);       // 결석자 수
    response.put("earlyLeaveCount", earlyLeaveCount); // 조퇴자 수
    response.put("lateCount", lateCount);           // 지각자 수

    return response;
    }
//     HTML 페이지 렌더링용
    @GetMapping("/attendanceSummary")
    public String getAttendanceSummaryPage(Model model) {
        List<ClassDTO> classList = studentAttendanceService.getAllClassesForUI();
        model.addAttribute("classList", classList); // HTML에 클래스 목록 전달
        return "class_support/attendanceSummary";  // Thymeleaf HTML 파일 경로
    }
}



