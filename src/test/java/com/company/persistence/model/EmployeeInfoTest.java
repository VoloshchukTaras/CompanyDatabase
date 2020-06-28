package com.company.persistence.model;

import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeInfoTest {

    @Test
    public void employeeInfoTest(){
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

        employeeInfo.getCityOfBirthday().equals("Bohorodchany");
        employeeInfo.getSalary().equals(100000);
        employeeInfo.getSex().equals("man");
        employeeInfo.getEmployee().equals(employee);

       assertNotNull(employee);
       assertNotNull(employeeInfo);
    }
}