package com.lastdance.project.employeeList.model.dao;

import com.lastdance.project.employeeList.model.dto.EmployeeListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeListDAO {

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




