package com.company.service;

import com.company.persistence.model.EmployeeInfo;
import com.company.persistence.repository.EmployeeInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeInfoServiceImpl implements EmployeeInfoService {
    @Autowired
    private EmployeeInfoRepository employeeInfoRepository;

    @Override
    public void addEmployeeInfo(EmployeeInfo employeeInfo) {
        employeeInfoRepository.save(employeeInfo);
    }

    @Override
    public List<EmployeeInfo> showAll() {
        return employeeInfoRepository.findAll();
    }

    @Override
    public Optional<EmployeeInfo> findById(Integer id) {
        return employeeInfoRepository.findById(id);
    }
}
