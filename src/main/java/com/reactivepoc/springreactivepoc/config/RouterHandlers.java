package com.reactivepoc.springreactivepoc.config;

import com.reactivepoc.springreactivepoc.model.Comments;
import com.reactivepoc.springreactivepoc.model.Employee;
import com.reactivepoc.springreactivepoc.service.IEmployeeService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class RouterHandlers {

    private IEmployeeService employeeService;

    public RouterHandlers(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Mono<ServerResponse> findAll(final ServerRequest serverRequest) {
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(employeeService.getAllEmployees(), Employee.class);
    }

    public Mono<ServerResponse> createEmployee(final ServerRequest serverRequest) {
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(serverRequest.bodyToMono(Employee.class).flatMap(employeeService::saveEmployee), Employee.class);
    }

    public Mono<ServerResponse> getEmployeeComments(final ServerRequest serverRequest) {
        return ServerResponse.ok().body(employeeService.getAllExternalEmployeesComments(), Comments.class);
    }

    public Mono<ServerResponse> createEmployeeComments(ServerRequest serverRequest) {
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(employeeService.saveAllExternalEmployeesComments(), Comments.class);
    }
}
