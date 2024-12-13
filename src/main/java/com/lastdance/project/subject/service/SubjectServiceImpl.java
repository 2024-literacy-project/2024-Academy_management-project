package com.lastdance.project.subject.service;

import com.lastdance.project.subject.model.dao.SubjectDAO;
import com.lastdance.project.subject.model.dto.SubjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectDAO subjectDAO;

    @Autowired
    public SubjectServiceImpl(SubjectDAO subjectDAO) {
        this.subjectDAO = subjectDAO;
    }

    /* subject 조회 */
    public List<SubjectDTO> getAllSubjects(){
        return subjectDAO.getAllSubjects();
    }

}
