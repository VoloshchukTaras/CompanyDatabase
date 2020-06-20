package com.company.persistence.model;

import javax.persistence.*;

@Entity
@Table
public class Employee2 {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @Column
    private String sername;
    @Column
    private String post;
    @Column
    private String sex;
    @Column
    private String cityOfBirthday;
    @Column
    private Integer salary;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSername() {
        return sername;
    }

    public void setSername(String sername) {
        this.sername = sername;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
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
}
