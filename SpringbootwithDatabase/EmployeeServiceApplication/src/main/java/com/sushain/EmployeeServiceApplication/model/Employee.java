package com.sushain.EmployeeServiceApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Employee {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String location;

    @OneToOne(cascade = CascadeType.ALL)
    Address address;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    List<Telephone> telephones;

    @ManyToMany(cascade = CascadeType.ALL)//Read about Bag fetch Exceptions
    @LazyCollection(LazyCollectionOption.FALSE)
       @JoinTable( joinColumns = {@JoinColumn(name = "EID", referencedColumnName = "id")},
            inverseJoinColumns ={@JoinColumn(name = "PID", referencedColumnName = "id")})
    List<Project> projects;
    public Employee() {
    }

    public Employee(Integer id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

