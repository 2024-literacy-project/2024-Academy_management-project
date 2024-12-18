package com.lastdance.project.classList.service;

import com.lastdance.project.classList.model.dao.ClassListDAO;
import com.lastdance.project.classList.model.dto.ClassListDTO;
import com.lastdance.project.studentList.model.dto.StudentListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassListServiceImpl implements ClassListService{

    private final ClassListDAO classListDAO;

    @Autowired
    public ClassListServiceImpl(ClassListDAO classListDAO) {
        this.classListDAO = classListDAO;
    }

    /* 클래스리스트 확인 */
    @Override
    public List<ClassListDTO> getAllClassList() {
        return classListDAO.getAllClassList();
    }

    /* 클래스리스트 추가 */
    @Override
    public void addClass(ClassListDTO classListDTO) {
        classListDAO.insertClass(classListDTO);
    }

    /* 클래스리스트 상세보기 */
    @Override
    public ClassListDTO getClassByNo(int class_no) {
        return classListDAO.getClassByNo(class_no);
    }

    /* 클래스리스트 수정 */
    @Override
    public void updateClass(ClassListDTO classListDTO) {
        classListDAO.updateClass(classListDTO);
    }

    /* 클래스리스트 삭제 */
    @Override
    public void deleteClass(int class_no) {
        classListDAO.deleteClass(class_no);
    }


    /* 클래스-학생 조회 */
    @Override
    public List<StudentListDTO> getStudentsByClassNo(int classNo){
        return classListDAO.getStudentsByClassNo(classNo);
    }

}
