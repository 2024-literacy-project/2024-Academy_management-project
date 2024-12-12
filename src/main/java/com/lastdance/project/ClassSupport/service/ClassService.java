package com.lastdance.project.ClassSupport.service;

import com.lastdance.project.ClassSupport.model.ClassDTO;
import com.lastdance.project.planner.model.PlannerDTO;

import java.util.List;

public interface ClassService {

    List<ClassDTO> getClassList(String id);

    List<ClassDTO> getStudentList(int class_no);
}
