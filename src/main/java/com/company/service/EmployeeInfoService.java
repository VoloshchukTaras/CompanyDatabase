package com.company.service;

import com.company.persistence.model.EmployeeInfo;

import java.util.List;
import java.util.Optional;

public interface EmployeeInfoService {

    public void addEmployeeInfo(EmployeeInfo employeeInfo);
    public List<EmployeeInfo> showAll();
    public Optional<EmployeeInfo> findById(Integer id);
}
