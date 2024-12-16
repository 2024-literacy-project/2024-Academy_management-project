package com.lastdance.project.ClassSupport2.model;

import com.lastdance.project.planner.model.PlannerDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassDAO2 {

    List<ClassDTO2> getClassList(String id);

    List<ClassDTO2> getStudentList(int class_no);

    List<PlannerDTO> getPlannerByMemberNo(int member_no);
}
