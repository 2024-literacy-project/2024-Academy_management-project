package com.lastdance.project.schedule.controller;

import com.lastdance.project.schedule.model.ScheduleDTO;
import com.lastdance.project.schedule.model.TimeTableDTO;
import com.lastdance.project.schedule.service.ScheduleService;
import com.lastdance.project.schedule.service.ScheduleServiceImpl;
import com.lastdance.project.schedule.service.TimeTableService;
import com.lastdance.project.schedule.service.TimeTableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private ScheduleServiceImpl scheduleServiceImpl;
    @Autowired
    private TimeTableService timeTableService;
    @Autowired
    private TimeTableServiceImpl timeTableServiceImpl;

    // 아이디 고정
//    private final String fixedId = "chulsoo";

    @GetMapping("/student/time-table")
    public String studentClass(Model model, Principal principal) {
        String studentId = principal.getName(); // 로그인한 사용자 ID 가져오기

        System.out.println("studentId: " + studentId);

        List<ScheduleDTO> studentClass = scheduleServiceImpl.getStudentClass(studentId);
        List<TimeTableDTO> timeTable = timeTableServiceImpl.getTimeTable(studentId);

        model.addAttribute("studentClass", studentClass);
        model.addAttribute("timeTable", timeTable);

        System.out.println(studentClass);
        System.out.println(timeTable);

        return "student/time-table";
    }
}
