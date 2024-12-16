package com.lastdance.project.studentList.service;

import com.lastdance.project.studentList.model.dao.StudentListDAO;
import com.lastdance.project.studentList.model.dto.StudentListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentListServiceImpl implements StudentListService{

    private final StudentListDAO studentListDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public StudentListServiceImpl(StudentListDAO studentListDAO) {
        this.studentListDAO = studentListDAO;
    }

    /* 학생 조회 */
    @Override
    public List<StudentListDTO> getAllStudents(){
        return studentListDAO.getAllStudents();
    }

    /* 학생 추가 */

    /* 학생 상세보기 */
    @Override
    public StudentListDTO getStudentByNo(int member_no){
        return studentListDAO.getStudentByNo(member_no);
    }

    /* 학생 수정 */
    @Override
    @Transactional
    public void updateStudent(StudentListDTO studentListDTO){
        studentListDTO.setPassword(passwordEncoder.encode(studentListDTO.getPassword()));
        studentListDAO.updateStudent(studentListDTO);
    }

    /* 학생 삭제 */
    @Override
    public void deleteStudent(int member_no){
        studentListDAO.deleteStudent(member_no);
    }

}
