package com.reactivepoc.springreactivepoc.respository;

import com.reactivepoc.springreactivepoc.model.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {

}