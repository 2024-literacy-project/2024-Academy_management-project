package com.lastdance.project.class_support.service;

import com.lastdance.project.class_support.model.dao.ClassDAO;
import com.lastdance.project.class_support.model.dto.ClassDTO;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    private final ClassDAO classDAO;
    // 생성자 주입 방식
    public ClassService(ClassDAO classDAO) {
        this.classDAO = classDAO;
    }

    public List<ClassDTO> getAllClasses(){
        return classDAO.getAllClasses();
    };
}
