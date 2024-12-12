package com.lastdance.project.ClassSupport.service;

import com.lastdance.project.ClassSupport.model.ClassDAO;
import com.lastdance.project.ClassSupport.model.ClassDTO;
import com.lastdance.project.member.model.MemberDTO;
import com.lastdance.project.planner.model.PlannerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassDAO classDAO;

    @Override
    public List<ClassDTO> getClassList(String id) {
        return classDAO.getClassList(id);
    }

    @Override
    public List<ClassDTO> getStudentList(int class_no) {
        return classDAO.getStudentList(class_no);
    }
}
