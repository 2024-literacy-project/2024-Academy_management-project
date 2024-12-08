package com.lastdance.project.employeeList.controller;

import com.lastdance.project.employeeList.model.dto.EmployeeListDTO;
import com.lastdance.project.employeeList.service.EmployeeListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employeeList")
public class EmployeeListController {

    private final EmployeeListServiceImpl employeeListServiceImpl;

    @Autowired
    public EmployeeListController(EmployeeListServiceImpl employeeListServiceImpl) {
        this.employeeListServiceImpl = employeeListServiceImpl;
    }

    /* 직원 조회 */
    @GetMapping
    public String getAllEmployees(Model model){
        List<EmployeeListDTO> employeeList = employeeListServiceImpl.getAllEmployees();
        model.addAttribute("employeeList", employeeList);
        return "employeeList/employeeList";
    }

    /* 직원 추가 */

    /* 직원 상세보기 */
    @GetMapping("/detail/{member_no}")
    public String getEmployeeDetail(@PathVariable("member_no") int memberNo, Model model){
        EmployeeListDTO employeeDetail = employeeListServiceImpl.getEmployeeByNo(memberNo);
        model.addAttribute("employeeDetail", employeeDetail);
        return "employeeList/employeeDetail";
    }

    /* 직원 수정 */
    @PostMapping("/update")
    public String updateEmployee(EmployeeListDTO employeeListDTO) {
        employeeListServiceImpl.updateEmployee(employeeListDTO);
        return "redirect:/employeeList/detail/" + employeeListDTO.getMember_no();
    }

    /* 직원 삭제 */
    @GetMapping("/delete/{member_no}")
    public String deleteEmployee(@PathVariable("member_no") int memberNo){
        employeeListServiceImpl.deleteEmployee(memberNo);
        return "redirect:/employeeList";
    }



}
