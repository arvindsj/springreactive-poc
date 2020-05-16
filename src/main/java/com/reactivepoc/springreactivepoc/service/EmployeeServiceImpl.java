package com.reactivepoc.springreactivepoc.service;

import com.reactivepoc.springreactivepoc.config.UtilsFactory;
import com.reactivepoc.springreactivepoc.model.Comments;
import com.reactivepoc.springreactivepoc.model.Employee;
import com.reactivepoc.springreactivepoc.respository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@Slf4j
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    public UtilsFactory utilsFactory;

    @Override
    public Flux<Employee> getAllEmployees() {
        return employeeRepository.findAll().doOnNext(employee -> {
            log.info(employee.toString());
            log.info("Current Thread :: {}", Thread.currentThread().getName());
        }).delayElements(Duration.ofSeconds(2));
    }

    @Override
    public Mono<Employee> saveEmployee(final Employee employee) {
        log.info("Employee :: {}", employee.toString());
        return employeeRepository.save(employee);
    }

    @Override
    public Flux<Comments> getAllExternalEmployeesComments() {
        return utilsFactory.getWebClient().get().uri("https://jsonplaceholder.typicode.com/comments").retrieve().bodyToFlux(Comments.class);
    }
}
