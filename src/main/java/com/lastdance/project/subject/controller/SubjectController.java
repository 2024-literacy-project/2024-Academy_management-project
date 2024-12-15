package com.lastdance.project.subject.controller;

import com.lastdance.project.subject.model.dto.SubjectDTO;
import com.lastdance.project.subject.service.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/subjectList")
public class SubjectController {

    private final SubjectServiceImpl subjectServiceImpl;

    @Autowired
    public SubjectController(SubjectServiceImpl subjectServiceImpl) {
        this.subjectServiceImpl = subjectServiceImpl;
    }

    /* subject 조회 */
    @GetMapping
    public String getAllSubjects(Model model){
        List<SubjectDTO> subjectList = subjectServiceImpl.getAllSubjects();
        model.addAttribute("subjectList", subjectList);
        return "subjectList/subjectList";
    }

}
