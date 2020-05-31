package com.reactivepoc.springreactivepoc.service;

import com.reactivepoc.springreactivepoc.model.Comments;
import com.reactivepoc.springreactivepoc.model.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IEmployeeService {
    Flux<Employee> getAllEmployees();
    Mono<Employee> saveEmployee(Employee employee);
    Flux<Employee> saveEmployees(List<Employee> employees);
    Flux<Comments> getAllExternalEmployeesComments();
    Flux<Comments> saveAllExternalEmployeesComments();
}
