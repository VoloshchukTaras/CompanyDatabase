package com.company.persistence.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    public void employeeTest(){
        Employee employee = new Employee();
        employee.setName("Taras");
        employee.setSername("Voloshchuk");
        employee.setPost("Head");

        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.setCityOfBirthday("Bohorodchany");
        employeeInfo.setSalary(100000);
        employeeInfo.setSex("man");
        employeeInfo.setEmployee(employee);

        employee.setEmployeeInfo(employeeInfo);

        employee.getName().equals("Taras");
        employee.getSername().equals("Voloshchuk");
        employee.getEmployeeInfo().equals(employeeInfo);
        employee.getPost().equals("Head");

        assertNotNull(employee);
        assertNotNull(employeeInfo);
    }

}