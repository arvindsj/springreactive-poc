package com.reactivepoc.springreactivepoc.service;

import com.reactivepoc.springreactivepoc.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployees();
    String saveEmployee(Employee employee);

}
