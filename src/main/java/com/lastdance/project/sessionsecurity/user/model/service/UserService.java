package com.lastdance.project.sessionsecurity.user.model.service;

import com.lastdance.project.sessionsecurity.user.model.dao.UserMapper;
import com.lastdance.project.sessionsecurity.user.model.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public int regist(SignupDTO signupDTO, StudentDTO studentDTO) {

        signupDTO.setUserPass(passwordEncoder.encode(signupDTO.getUserPass()));

        int result = 0;

        try {
//            result = userMapper.registMember(signupDTO);
//            // 생성된 memberNo를 studentDTO에 설정
//            studentDTO.setMemberNo(signupDTO.getMemberNo());
//            userMapper.registStudent(studentDTO);
            result = userMapper.registMember(signupDTO);
            System.out.println("MemberNo: " + signupDTO.getMemberNo());

            if (result > 0){
                System.out.println(">>> MemberNo generated: " + signupDTO.getMemberNo());
                // 생성된 memberNo를 studentDTO에 설정
                studentDTO.setMemberNo(signupDTO.getMemberNo());
                result = userMapper.registStudent(studentDTO);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public int regist2(SignupDTO2 signupDTO2, EmployeeDTO employeeDTO) {

        signupDTO2.setUserPass(passwordEncoder.encode(signupDTO2.getUserPass()));

        int result = 0;

        try {
//            result = userMapper.registMember(signupDTO);
//            // 생성된 memberNo를 studentDTO에 설정
//            studentDTO.setMemberNo(signupDTO.getMemberNo());
//            userMapper.registStudent(studentDTO);
            result = userMapper.registMember2(signupDTO2);
            System.out.println("MemberNo: " + signupDTO2.getMemberNo());

            if (result > 0){
                System.out.println(">>> MemberNo generated: " + signupDTO2.getMemberNo());
                // 생성된 memberNo를 studentDTO에 설정
                employeeDTO.setMemberNo(signupDTO2.getMemberNo());
                result = userMapper.registEmployee(employeeDTO);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }



    // AuthService 에서 호출하는 메소드
    public LoginUserDTO findByUsername(String username) {

        LoginUserDTO login = userMapper.findByUsername(username);

        if (!Objects.isNull(login)) {
            return login;
        } else {
            return null;
        }
    }


    public List<BaseUserDTO> getAllUsers() {
        return userMapper.selectAllUsers();
    }

    public BaseUserDTO getUserById(int memberNo) {
        return userMapper.selectUserById(memberNo);
    }

    @Transactional
    public void updateUser(BaseUserDTO userDTO) {
        userDTO.setUserPass(passwordEncoder.encode(userDTO.getUserPass()));
        userMapper.updateUser(userDTO);
    }


}
