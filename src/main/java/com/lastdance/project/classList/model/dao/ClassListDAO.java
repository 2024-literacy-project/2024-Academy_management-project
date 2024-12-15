package com.lastdance.project.classList.model.dao;

import com.lastdance.project.classList.model.dto.ClassListDTO;
import com.lastdance.project.studentList.model.dto.StudentListDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassListDAO {

    /* 클래스리스트 확인 */
    List<ClassListDTO> getAllClassList();

    /* 클래스리스트 추가 */
    void insertClass(ClassListDTO classListDTO);

    /* 클래스리스트 상세보기 */
    ClassListDTO getClassByNo(int class_no);

    /* 클래스리스트 수정 */
    void updateClass(ClassListDTO classListDTO);

    /* 클래스리스트 삭제 */
    void deleteClass(int class_no);


    /* 클래스-학생 조회 */
    List<StudentListDTO> getStudentsByClassNo(@Param("class_no") int classNo);

}
