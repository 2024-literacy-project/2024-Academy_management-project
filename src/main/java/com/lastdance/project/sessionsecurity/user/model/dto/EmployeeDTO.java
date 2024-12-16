package com.lastdance.project.sessionsecurity.user.model.dto;

public class EmployeeDTO {
    private int memberNo; // FK로 참조
    private int salary;
    private Double bonus;
    private Double totalSalary;
    private String deptName;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int memberNo, int salary, Double bonus, Double totalSalary, String deptName) {
        this.memberNo = memberNo;
        this.salary = salary;
        this.bonus = bonus;
        this.totalSalary = totalSalary;
        this.deptName = deptName;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(Double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "memberNo=" + memberNo +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", totalSalary=" + totalSalary +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
