package com.company.persistence.model;

import javax.persistence.*;

@Entity
@Table
public class EmployeeInfo {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String sex;
    @Column
    private String cityOfBirthday;
    @Column
    private Integer salary;
    @OneToOne(mappedBy = "employeeInfo")
    private Employee employee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCityOfBirthday() {
        return cityOfBirthday;
    }

    public void setCityOfBirthday(String cityOfBirthday) {
        this.cityOfBirthday = cityOfBirthday;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
