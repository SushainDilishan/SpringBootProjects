package com.sushain.EmployeeServiceApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Employee {

    @Id
    Integer id;
    String name;
    String location;

    public Employee() {
    }

    public Employee(Integer id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public  List<Employee> listEmployees(){

        Employee employee =new Employee();
        List<Employee> employees = new ArrayList<>();
        employee.setName("Sushain");
        employee.setLocation("Piliyandala");
        employees.add(employee);

        return employees;

    }
}

