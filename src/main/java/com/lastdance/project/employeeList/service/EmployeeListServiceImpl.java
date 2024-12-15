package com.lastdance.project.employeeList.service;

import com.lastdance.project.employeeList.model.dao.EmployeeListDAO;
import com.lastdance.project.employeeList.model.dto.EmployeeListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeListServiceImpl implements EmployeeListService{

    private final EmployeeListDAO employeeListDAO;

    @Autowired
    public EmployeeListServiceImpl(EmployeeListDAO employeeListDAO) {
        this.employeeListDAO = employeeListDAO;
    }

    /* 직원 조회 */
    @Override
    public List<EmployeeListDTO> getAllEmployees(){
        return employeeListDAO.getAllEmployees();
    }

    /* 직원 추가 */

    /* 직원 상세보기 */
    @Override
    public EmployeeListDTO getEmployeeByNo(int member_no){
        return employeeListDAO.getEmployeeByNo(member_no);
    }

    /* 직원 수정 */
    @Override
    public void updateEmployee(EmployeeListDTO employeeListDTO){
        employeeListDAO.updateEmployee(employeeListDTO);
    }

    /* 직원 삭제 */
    @Override
    public void deleteEmployee(int member_no){
        employeeListDAO.deleteEmployee(member_no);
    }


}
