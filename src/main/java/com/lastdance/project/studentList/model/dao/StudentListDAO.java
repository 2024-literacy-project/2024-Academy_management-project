package com.lastdance.project.studentList.model.dao;

import com.lastdance.project.studentList.model.dto.StudentListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentListDAO {

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
