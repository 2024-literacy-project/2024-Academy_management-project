package com.lastdance.project.employeeList.service;

import com.lastdance.project.employeeList.model.dao.EmployeeListDAO;
import com.lastdance.project.employeeList.model.dto.EmployeeListDTO;

import java.util.List;

public interface EmployeeListService {

    /* 직원 조회 */
    List<EmployeeListDTO> getAllEmployees();

    /* 직원 추가 */

    /* 직원 상세보기 */
    EmployeeListDTO getEmployeeByNo(int member_no);

    /* 직원 수정 */
    void updateEmployee(EmployeeListDTO employeeListDTO);

    /* 직원 삭제 */
    void deleteEmployee(int member_no);


}
