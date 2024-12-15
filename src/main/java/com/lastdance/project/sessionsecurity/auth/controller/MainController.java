package com.lastdance.project.sessionsecurity.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = {"/", "/main"})
    public String main() {
        return "main";
    }

    @GetMapping("/admin/page")
    public String adminPage() {
        return "/admin/admin";
    }

    @GetMapping("/student/page")
    public String userPage() {
        return "/student/student";
    }

    @GetMapping("/employee/page")
    public String teacherPage() {
        return "/employee/employee";
    }
}


//student

//employee