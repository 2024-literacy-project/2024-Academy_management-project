package com.lastdance.project.sessionsecurity.user.model.dao;

import com.lastdance.project.sessionsecurity.user.model.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {


    int registMember(SignupDTO signupDTO);

    int registMember2(SignupDTO2 signupDTO2);

    int registStudent(StudentDTO studentDTO);

    int registEmployee(EmployeeDTO employeeDTO);


    LoginUserDTO findByUsername(String username);

    List<BaseUserDTO> selectAllUsers();


    BaseUserDTO selectUserById(int memberNo);


    void updateUser(BaseUserDTO userDTO);

}
