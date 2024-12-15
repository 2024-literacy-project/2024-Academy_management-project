package com.lastdance.project.sessionsecurity.user.model.service;

import com.lastdance.project.sessionsecurity.user.model.dao.ExamMapper;
import com.lastdance.project.sessionsecurity.user.model.dto.ExamResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    @Autowired
    private ExamMapper examMapper;

    public List<ExamResultDTO> getExamResultsByStudent(String studentId) {
        return examMapper.getExamResultsByStudent(studentId);
    }
}
