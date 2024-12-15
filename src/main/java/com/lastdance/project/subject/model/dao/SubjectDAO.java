package com.lastdance.project.subject.model.dao;

import com.lastdance.project.subject.model.dto.SubjectDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubjectDAO {

    /* subject 조회 */
    List<SubjectDTO> getAllSubjects();

}
