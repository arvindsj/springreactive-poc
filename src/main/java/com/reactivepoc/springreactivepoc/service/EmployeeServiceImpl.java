package com.reactivepoc.springreactivepoc.service;

import com.reactivepoc.springreactivepoc.config.UtilsFactory;
import com.reactivepoc.springreactivepoc.model.Employee;
import com.reactivepoc.springreactivepoc.model.EmployeeResponse;
import com.reactivepoc.springreactivepoc.respository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    private UtilsFactory utilsFactory;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public String saveEmployee(final Employee employee) {
        log.info("Employee :: {}", employee.toString());
        return employeeRepository.save(employee).toString();
    }
}
