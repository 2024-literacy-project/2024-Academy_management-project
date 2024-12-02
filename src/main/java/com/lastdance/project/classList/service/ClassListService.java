package com.lastdance.project.classList.service;

import com.lastdance.project.classList.model.dto.ClassListDTO;

import java.util.List;

public interface ClassListService {

    /* 클래스리스트 확인 */
    List<ClassListDTO> getAllClassList();

    /* 클래스리스트 추가 */
    void addClass(ClassListDTO classListDTO);

    /* 클래스리스트 상세보기 */
    ClassListDTO getClassByNo(int class_no);    //class_no로 조회




}
