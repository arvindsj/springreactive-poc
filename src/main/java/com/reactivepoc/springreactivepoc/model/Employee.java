package com.reactivepoc.springreactivepoc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    private Long id;
    private String employee_name;
    private String employee_salary;
    private String employee_age;
    private String profile_image;

    public Employee(String employee_name, String employee_salary, String employee_age, String profile_image) {
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
    }
}
