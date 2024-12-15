package com.lastdance.project.ClassSupport2.service;

import com.lastdance.project.ClassSupport2.model.ClassDTO2;

import java.util.List;

public interface ClassService2 {

    List<ClassDTO2> getClassList(String id);

    List<ClassDTO2> getStudentList(int class_no);
}
