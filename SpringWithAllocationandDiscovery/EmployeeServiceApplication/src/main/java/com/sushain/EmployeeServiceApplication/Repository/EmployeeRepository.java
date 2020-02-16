package com.sushain.EmployeeServiceApplication.Repository;

import com.sushain.EmployeeServiceApplication.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
