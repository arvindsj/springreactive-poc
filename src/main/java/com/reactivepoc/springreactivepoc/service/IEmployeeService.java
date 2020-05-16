package com.reactivepoc.springreactivepoc.service;

import com.reactivepoc.springreactivepoc.model.Comments;
import com.reactivepoc.springreactivepoc.model.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IEmployeeService {
    Flux<Employee> getAllEmployees();
    Mono<Employee> saveEmployee(Employee employee);
    Flux<Comments> getAllExternalEmployeesComments();
}
