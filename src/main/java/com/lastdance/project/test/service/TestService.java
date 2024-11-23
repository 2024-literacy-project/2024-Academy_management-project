package com.lastdance.project.test.service;

import com.lastdance.project.test.model.dao.TestDAO;
import com.lastdance.project.test.model.dto.TestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private final TestDAO testDAO;

    @Autowired
    public TestService(TestDAO testDAO) {
        this.testDAO = testDAO;
    }

    public List<TestDTO> getAllMemberList() {
        return testDAO.getAllMemberList();
    }

}