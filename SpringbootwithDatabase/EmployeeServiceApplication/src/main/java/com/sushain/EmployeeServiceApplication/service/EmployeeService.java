package com.sushain.EmployeeServiceApplication.service;

import com.sushain.EmployeeServiceApplication.model.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAllEmp();
    Employee save(Employee e);
}
