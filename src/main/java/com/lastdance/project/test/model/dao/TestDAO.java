package com.lastdance.project.test.model.dao;

import com.lastdance.project.test.model.dto.TestDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestDAO {
    List<TestDTO> getAllMemberList();
}
