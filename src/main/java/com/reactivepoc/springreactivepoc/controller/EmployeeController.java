package com.reactivepoc.springreactivepoc.controller;

import com.reactivepoc.springreactivepoc.model.Employee;
import com.reactivepoc.springreactivepoc.service.IEmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private IEmployeeService employeeService;

    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employee/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping(value = "/employee/save")
    public String saveEmployee(@RequestBody final Employee employee) {
        return employeeService.saveEmployee(employee);
    }
}
