package com.company.controller;

import com.company.persistence.model.Employee;
import com.company.persistence.model.Employee2;
import com.company.persistence.model.EmployeeInfo;
import com.company.service.EmployeeInfoService;
import com.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CompanyController {

    private final EmployeeService employeeService;
    private final EmployeeInfoService employeeInfoService;

    @Autowired
    public CompanyController(EmployeeService employeeService,
                             EmployeeInfoService employeeInfoService
                             ){
        this.employeeService=employeeService;
        this.employeeInfoService=employeeInfoService;
    }

    @RequestMapping(value = "/")
    public String homePage(){
        return "home";
    }
    

    @GetMapping(value = "/addEmployee")
    public ModelAndView newEmployee(){
        return new ModelAndView("employee","employee", new Employee2());
    }

    @PostMapping(value = "/addEmployee2")
    public String newEmployeeInfo2(@ModelAttribute("employee") Employee2 employee){
        Employee employee1 = new Employee();
        employee1.setName(employee.getName());
        employee1.setSername(employee.getSername());
        employee1.setPost(employee.getPost());

        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.setSex(employee.getSex());
        employeeInfo.setCityOfBirthday(employee.getCityOfBirthday());
        employeeInfo.setSalary(employee.getSalary());
        employeeInfo.setEmployee(employee1);

        employee1.setEmployeeInfo(employeeInfo);

        employeeService.addEmployee(employee1);
        return "end";

    }

    @RequestMapping(value = "/allEmployees")
    public String showAllEmployees(Model model){
        List<Employee> employeeList = employeeService.showAll();
        List<EmployeeInfo> employeeInfoList = employeeInfoService.showAll();
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("employeeInfoList", employeeInfoList);
        return "allEmployees";

    }
/*
    @GetMapping(value = "/addEmployeeInfo")
    public ModelAndView newEmployeeInfo(){
        return new ModelAndView("employeeInfo","employeeInfo", new EmployeeInfo());
    }



    @PostMapping(value = "/newEmployee")
    public String addEmployee(@ModelAttribute("employee") Employee employee,
                              @ModelAttribute("employeeInfo") EmployeeInfo employeeInfo){
        
        //employee.setEmployeeInfo(employeeInfo);
        employeeInfo.setEmployee(employee);


        employeeInfoService.addEmployeeInfo(employeeInfo);
        return "end";
    }

 */



}
