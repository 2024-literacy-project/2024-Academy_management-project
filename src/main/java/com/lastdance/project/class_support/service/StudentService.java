package com.lastdance.project.class_support.service;

import com.lastdance.project.class_support.model.dao.StudentDAO;
import com.lastdance.project.class_support.model.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public List<StudentDTO> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public StudentDTO getStudentByMemberNo(int memberNo) {
        return studentDAO.getStudentByMemberNo(memberNo);
    }
}
