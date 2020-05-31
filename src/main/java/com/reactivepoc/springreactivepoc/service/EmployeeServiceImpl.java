package com.reactivepoc.springreactivepoc.service;

import com.reactivepoc.springreactivepoc.config.UtilsFactory;
import com.reactivepoc.springreactivepoc.model.Comments;
import com.reactivepoc.springreactivepoc.model.Employee;
import com.reactivepoc.springreactivepoc.respository.CommentsRepository;
import com.reactivepoc.springreactivepoc.respository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    CommentsRepository commentsRepository;
    @Autowired
    public UtilsFactory utilsFactory;

    @Override
    public Flux<Employee> getAllEmployees() {
        return employeeRepository.findAll().doOnNext(employee -> {
            log.info(employee.toString());
            log.info("Current Thread :: {}", Thread.currentThread().getName());
        });
    }

    @Override
    public Mono<Employee> saveEmployee(final Employee employee) {
        log.info("Employee :: {}", employee.toString());
        return employeeRepository.save(employee).single();
    }

    @Override
    public Flux<Employee> saveEmployees(final List<Employee> employees) {
        log.info("Employees :: {}", employees);
        return employeeRepository.saveAll(employees);
    }

    @Override
    public Flux<Comments> getAllExternalEmployeesComments() {
        return utilsFactory.getWebClient().get().uri("https://jsonplaceholder.typicode.com/comments").retrieve().bodyToFlux(Comments.class);
    }

    @Override
    public Flux<Comments> saveAllExternalEmployeesComments() {
        Flux<Comments> commentsFlux = getAllExternalEmployeesComments().map(comments -> {
            comments.setId(null);
            return comments;
        }).log();

        return commentsRepository.saveAll(commentsFlux);
//        return commentsFlux.flatMap(comments -> commentsRepository.save(comments)).log();
    }
}
