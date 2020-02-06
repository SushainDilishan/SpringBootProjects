package com.sushain.EmployeeServiceApplication.model;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
@RequestMapping
public class Employee {
   String name;
   String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Employee> getAllEmployees(){
        Employee employee =new Employee();
        List<Employee> employees = new ArrayList<>();
        employee.setName("Sushain");
        employee.setLocation("Piliyandala");
        employees.add(employee);

        return employees;

    }
}
