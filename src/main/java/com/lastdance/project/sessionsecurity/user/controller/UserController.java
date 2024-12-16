package com.lastdance.project.sessionsecurity.user.controller;


import com.lastdance.project.sessionsecurity.user.model.dto.*;
import com.lastdance.project.sessionsecurity.user.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/student/signup")
    public String signupStudentForm() {
        return "student/signup"; // 학생 회원가입 폼 페이지로 이동
    }

//    @GetMapping("/signup")
//    public void signup() {}

    @PostMapping("/student/signup")
    public ModelAndView signup(ModelAndView mv, @ModelAttribute SignupDTO signupDTO, @ModelAttribute StudentDTO studentDTO) {

        System.out.println(">>> 컨트롤러 호출됨");
        System.out.println("SignupDTO: " + signupDTO);
        System.out.println("StudentDTO: " + studentDTO);

        int result = userService.regist(signupDTO, studentDTO);

        String message = "";

        if (result > 0) {
            message = "회원가입이 정상적으로 완료되었습니다.";
            mv.setViewName("redirect:/auth/login");
        } else {
            message = "회원가입에 실패하였습니다.";
            mv.setViewName("redirect:/student/signup");
        }

        mv.addObject("message", message);

        return mv;
    }

    @GetMapping("/employee/signup")
    public String signupEmployeeForm() {
        return "employee/signup"; // 직원 회원가입 폼 페이지로 이동
    }

    @PostMapping("/employee/signup")
    public ModelAndView signup2(ModelAndView mv, @ModelAttribute SignupDTO2 signupDTO2, @ModelAttribute EmployeeDTO employeeDTO) {

        System.out.println(">>> 컨트롤러 호출됨");
        System.out.println("SignupDTO2: " + signupDTO2);
        System.out.println("EmployeeDTO: " + employeeDTO);

        int result = userService.regist2(signupDTO2, employeeDTO);

        String message = "";

        if (result > 0) {
            message = "회원가입이 정상적으로 완료되었습니다.";
            mv.setViewName("redirect:/auth/login");
        } else {
            message = "회원가입에 실패하였습니다.";
            mv.setViewName("redirect:/employee/signup");
        }

        mv.addObject("message", message);

        return mv;
    }


    // 모든 사용자 조회 페이지
    @GetMapping("/users/list")
    public String getAllUsers(Model model) {
        List<BaseUserDTO> users = userService.getAllUsers();
        if (users == null || users.isEmpty()) {
            users = new ArrayList<>();
            System.out.println("No users found.");
        } else {
            System.out.println("Users found: " + users.size());
        }
        model.addAttribute("users", users);
        return "user/list"; // templates/user/list.html 로 이동
    }

    // 특정 사용자 정보 조회 및 수정 페이지
    @GetMapping("/users/{memberNo}")
    public String getUser(@PathVariable int memberNo, Model model) {
        BaseUserDTO userDTO = userService.getUserById(memberNo);
        model.addAttribute("user", userDTO);
        return "user/edit"; // templates/user/edit.html 로 이동
    }

    // 사용자 정보 수정 처리
    @PostMapping("/users/{memberNo}")
    public String updateUser(@PathVariable int memberNo, @ModelAttribute BaseUserDTO userDTO, Model model) {
        userDTO.setMemberNo(memberNo);
        userService.updateUser(userDTO);
        model.addAttribute("message", "User updated successfully");
        return "redirect:/users/list"; // 수정 후 사용자 목록 페이지로 리다이렉트
    }

}
