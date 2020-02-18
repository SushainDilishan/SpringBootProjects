package com.sushain.EmployeeServiceApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String projects;

        @ManyToMany(mappedBy = "projects")
            @JsonIgnore
    List<Employee> employees;

    public Project() {
    }

    public Project(Integer id, String projects, List<Employee> employees) {
        this.id = id;
        this.projects = projects;
        this.employees = employees;
    }

    public Integer getId() {
        return id;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjects() {
        return projects;
    }

    public void setProjects(String projects) {
        this.projects = projects;
    }
}
