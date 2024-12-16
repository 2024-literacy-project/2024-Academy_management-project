package com.lastdance.project.sessionsecurity.user.controller;

import com.lastdance.project.sessionsecurity.user.model.dto.ExamResultDTO;
import com.lastdance.project.sessionsecurity.user.model.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class ExamController {

    @Autowired
    private ExamService examService;

    @GetMapping("/student/exam-results")
    public String showExamResults(Model model, Principal principal) {
        String studentId = principal.getName(); // 로그인한 사용자 ID 가져오기

        System.out.println("studentId: " + studentId);

        List<ExamResultDTO> examResults = examService.getExamResultsByStudent(studentId);
        model.addAttribute("examResults", examResults);

        // 콘솔에 출력
        System.out.println("Exam Results: " + examResults);

        return "student/exam-results";
    }

}
