package com.lastdance.project.classList.model.dao;

import com.lastdance.project.classList.model.dto.ClassListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassListDAO {

    /* 클래스리스트 확인 */
    List<ClassListDTO> getAllClassList();

    /* 클래스리스트 추가 */
    void insertClass(ClassListDTO classListDTO);

    /* 클래스리스트 상세보기 */
    ClassListDTO getClassByNo(int class_no);

}
