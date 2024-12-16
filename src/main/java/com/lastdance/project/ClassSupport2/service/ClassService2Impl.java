package com.lastdance.project.ClassSupport2.service;

import com.lastdance.project.ClassSupport2.model.ClassDAO2;
import com.lastdance.project.ClassSupport2.model.ClassDTO2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService2Impl implements ClassService2 {

    @Autowired
    private ClassDAO2 classDAO;

    @Override
    public List<ClassDTO2> getClassList(String id) {
        return classDAO.getClassList(id);
    }

    @Override
    public List<ClassDTO2> getStudentList(int class_no) {
        return classDAO.getStudentList(class_no);
    }
}
