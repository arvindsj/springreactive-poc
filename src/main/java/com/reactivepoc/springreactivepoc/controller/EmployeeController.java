//package com.reactivepoc.springreactivepoc.controller;
//
//import com.reactivepoc.springreactivepoc.model.Comments;
//import com.reactivepoc.springreactivepoc.model.Employee;
//import com.reactivepoc.springreactivepoc.service.IEmployeeService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//@RestController
//@RequiredArgsConstructor
//@Slf4j
//public class EmployeeController {
//
//    @Autowired
//    IEmployeeService employeeService;
//
//    @PostMapping(value = "/employee/save")
//    public Mono<Employee> saveEmployee(@RequestBody final Employee employee) {
//        return employeeService.saveEmployee(employee);
//    }
//
//    @GetMapping(value = "/employee/all" , produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
//    public Flux<Employee> getAllEmployees() {
//        log.info("Current Thread :: {}", Thread.currentThread().getName());
//        return employeeService.getAllEmployees();
//    }
//
//    @GetMapping(value = "/external/employee/comments/all" , produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
//    public Flux<Comments> getAllExternalEmployees() {
//        log.info("External Employee Comments - Thread :: {}", Thread.currentThread().getName());
//        return employeeService.getAllExternalEmployeesComments();
//    }
//
//}
