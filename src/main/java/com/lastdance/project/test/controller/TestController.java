package com.lastdance.project.test.controller;

import com.lastdance.project.test.model.dto.TestDTO;
import com.lastdance.project.test.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping("/index")
    public ModelAndView openAll() throws Exception {

        ModelAndView mv = new ModelAndView("index");
        List<TestDTO> listMember = testService.getAllMemberList();

        mv.addObject("listMember", listMember);

        return mv;
    }
}