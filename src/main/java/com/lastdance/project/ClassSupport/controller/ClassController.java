package com.lastdance.project.ClassSupport.controller;

import com.lastdance.project.ClassSupport.model.ClassDTO;
import com.lastdance.project.ClassSupport.service.ClassService;
import com.lastdance.project.ClassSupport.service.ClassServiceImpl;
import com.lastdance.project.planner.model.PlannerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/class-support")
public class ClassController {

    @Autowired
    private ClassService classService;
    @Autowired
    private ClassServiceImpl classServiceImpl;

    // 아이디 고정
    private final String fixedId = "minsoo";

    // 클래스 목록
    @GetMapping("/class")
    public String getClassList(Model model) {

        List<ClassDTO> classList = classServiceImpl.getClassList(fixedId);
        model.addAttribute("classList", classList);

        System.out.println(classList);

        return "class-support/class-list";
    }

    @GetMapping("/student-list/{class_no}")
    public String getStudentsByClassNo(@PathVariable int class_no, Model model) {

        List<ClassDTO> studentList = classServiceImpl.getStudentList(class_no);
        model.addAttribute("studentList", studentList);

        System.out.println(studentList);

        return "class-support/student-list";
    }
}
