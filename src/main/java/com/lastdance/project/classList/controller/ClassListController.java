package com.lastdance.project.classList.controller;

import com.lastdance.project.classList.model.dto.ClassListDTO;
import com.lastdance.project.classList.service.ClassListService;
import com.lastdance.project.classList.service.ClassListServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/classList")
public class ClassListController {

    private final ClassListServiceImpl classListServiceImpl;

    @Autowired
    public ClassListController(ClassListServiceImpl classListServiceImpl) {
        this.classListServiceImpl = classListServiceImpl;
    }

    /* 클래스리스트 확인 */
//    @GetMapping("/classList")
    @GetMapping
    public String getAllClassList(Model model) {
        List<ClassListDTO> classList = classListServiceImpl.getAllClassList();
        model.addAttribute("classList", classList);
        return "classList/classList";
    }

    /* 클래스리스트 추가 */
    @PostMapping("/addClass")
    public String addClass(ClassListDTO classListDTO) {
        classListServiceImpl.addClass(classListDTO);
        return "redirect:/classList"; // 추가 후 목록 페이지로 리다이렉트
    }

    @GetMapping("/addClass")
    public String showAddClassPage() {  //클래스 추가 페이지 띄우기
        return "classList/addClass";
    }

    /* 클래스리스트 상세보기 */
    @GetMapping("/detail/{class_no}")
    public String getClassDetail(@PathVariable("class_no") int classNo, Model model) {
        ClassListDTO classDetail = classListServiceImpl.getClassByNo(classNo);
        model.addAttribute("classDetail", classDetail); // 상세정보를 모델에 추가
        return "classList/classDetail"; // 상세보기 페이지 렌더링
    }


}
