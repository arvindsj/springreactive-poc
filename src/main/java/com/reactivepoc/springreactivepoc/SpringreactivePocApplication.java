package com.reactivepoc.springreactivepoc;

import com.reactivepoc.springreactivepoc.model.Employee;
import com.reactivepoc.springreactivepoc.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
@Slf4j
public class SpringreactivePocApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringreactivePocApplication.class, args);
    }

    @Bean
    CommandLineRunner initializeVendors(IEmployeeService employeeService) {
        return args -> {
            employeeService.saveEmployees(
                IntStream.rangeClosed(1, 100).mapToObj(i -> new Employee("" + i, "300" + i, "20" + i, "none"))
                    .peek(s -> System.out.println("Employee :: " + s))
                    .collect(Collectors.toList())).subscribe();

            log.info("Server started and employees saved");
        };
    }

}
