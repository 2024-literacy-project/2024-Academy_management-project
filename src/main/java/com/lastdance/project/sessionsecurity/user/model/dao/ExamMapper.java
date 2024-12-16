package com.lastdance.project.sessionsecurity.user.model.dao;

import com.lastdance.project.sessionsecurity.user.model.dto.ExamResultDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamMapper {
    List<ExamResultDTO> getExamResultsByStudent(@Param("studentId") String studentId);
}
