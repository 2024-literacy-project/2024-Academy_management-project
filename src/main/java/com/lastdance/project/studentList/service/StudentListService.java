package com.lastdance.project.studentList.service;

import com.lastdance.project.studentList.model.dto.StudentListDTO;

import java.util.List;

public interface StudentListService {

    /* 학생 조회 */
    List<StudentListDTO> getAllStudents();

    /* 학생 추가 */

    /* 학생 상세보기 */
    StudentListDTO getStudentByNo(int member_no);

    /* 학생 수정 */
    void updateStudent(StudentListDTO studentListDTO);

    /* 학생 삭제 */
    void deleteStudent(int member_no);

}
