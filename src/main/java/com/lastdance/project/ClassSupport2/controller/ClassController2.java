package com.lastdance.project.ClassSupport2.controller;

import com.lastdance.project.ClassSupport2.model.ClassDTO2;
import com.lastdance.project.ClassSupport2.service.ClassService2;
import com.lastdance.project.ClassSupport2.service.ClassService2Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/class-support")
public class ClassController2 {

    @Autowired
    private ClassService2 classService2;
    @Autowired
    private ClassService2Impl classServiceImpl;

    // 강사 아이디 고정
    private final String fixedId = "minsoo";

    // 클래스 목록
    @GetMapping("/class")
    public String getClassList(Model model) {

        List<ClassDTO2> classList = classServiceImpl.getClassList(fixedId);
        model.addAttribute("classList", classList);

        System.out.println(classList);

        return "class-support/feedback/class-list";
    }

    @GetMapping("/student-list/{class_no}")
    public String getStudentsByClassNo(@PathVariable int class_no, Model model) {

        List<ClassDTO2> studentList = classServiceImpl.getStudentList(class_no);
        model.addAttribute("studentList", studentList);

        System.out.println(studentList);

        return "class-support/feedback/student-list";
    }
}
