package com.company.controller;

import com.company.persistence.model.Employee;
import com.company.persistence.model.Employee2;
import com.company.persistence.model.EmployeeInfo;
import com.company.persistence.model.Id2;
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

import java.util.LinkedList;
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
        return "home";

    }

    @RequestMapping(value = "/allEmployees")
    public String showAllEmployees(Model model){
        List<Employee> employeeList = employeeService.showAll();
        List<EmployeeInfo> employeeInfoList = employeeInfoService.showAll();

        List<Employee2> employee2List = new LinkedList<>();
        for(int i =0;i<employeeList.size(); i++){
            Employee employee1 = employeeList.get(i);
            EmployeeInfo employeeInfo1 = employeeInfoList.get(i);
            Employee2 employee2 = new Employee2();

            employee2.setId(employee1.getId());
            employee2.setName(employee1.getName());
            employee2.setSername(employee1.getSername());
            employee2.setPost(employee1.getPost());
            employee2.setSex(employeeInfo1.getSex());
            employee2.setCityOfBirthday(employeeInfo1.getCityOfBirthday());
            employee2.setSalary(employeeInfo1.getSalary());
            employee2List.add(employee2);

        }
        model.addAttribute("employee2List", employee2List);
        return "allEmployees";

    }
    @GetMapping(value = "/delete")
    public ModelAndView deleteEmployeeById(){
        return new ModelAndView("deleteById","delete", new Id2());
    }

    @PostMapping(value = "/deleteById")
    public String deleteById(@ModelAttribute("delete") Id2 id2){
        employeeService.deleteEmployee(id2.getID());
        return "home";
    }


}
