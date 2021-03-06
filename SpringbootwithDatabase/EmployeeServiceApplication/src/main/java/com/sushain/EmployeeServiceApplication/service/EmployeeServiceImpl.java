package com.sushain.EmployeeServiceApplication.service;

import com.sushain.EmployeeServiceApplication.Repository.EmployeeRepository;
import com.sushain.EmployeeServiceApplication.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee e) {
        Employee employee = employeeRepository.save(e);
                return employee;
    }
    public List<Employee> findAllEmp(){
        return  employeeRepository.findAll();

    }
}
