package com.lastdance.project.studentList.controller;

import com.lastdance.project.studentList.model.dto.StudentListDTO;
import com.lastdance.project.studentList.service.StudentListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/studentList")
public class StudentListController {

    private final StudentListServiceImpl studentListServiceImpl;

    @Autowired
    public StudentListController(StudentListServiceImpl studentListServiceImpl) {
        this.studentListServiceImpl = studentListServiceImpl;
    }

    /* 학생 조회 */
    @GetMapping
    public String getAllStudents(Model model){
        List<StudentListDTO> studentList = studentListServiceImpl.getAllStudents();
        model.addAttribute("studentList", studentList);
        return "studentList/studentList";
    }

    /* 학생 추가 */

    /* 학생 상세보기 */
    @GetMapping("/detail/{member_no}")
    public String getStudentDetail(@PathVariable("member_no") int memberNo, Model model){
        StudentListDTO studentDetail = studentListServiceImpl.getStudentByNo(memberNo);
        model.addAttribute("studentDetail", studentDetail);
        return "studentList/studentDetail";
    }

    /* 학생 수정 */
    @PostMapping("/update")
    public String updateStudent(StudentListDTO studentListDTO){
        studentListServiceImpl.updateStudent(studentListDTO);
        return "redirect:/studentList/detail/" + studentListDTO.getMember_no();
    }

    /* 학생 삭제 */
    @GetMapping("/delete/{member_no}")
    public String deleteStudent(@PathVariable("member_no") int memberNo){
        studentListServiceImpl.deleteStudent(memberNo);
        return "redirect:/studentList";
    }

}
