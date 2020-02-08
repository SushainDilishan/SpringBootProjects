package com.sushain.EmployeeServiceApplication.Controller;

import com.sushain.EmployeeServiceApplication.model.Employee;
import com.sushain.EmployeeServiceApplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @RequestMapping("hello")
    public String greeting(){

        return "<h1>Hello</h1>";
    }
    @RequestMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id){
        if (id==10){
            Employee employee = new Employee();
            employee.setId(10);
            employee.setName("Sushain");
            employee.setLocation("Piliyandala");
            return employee;
        }else return new Employee();

    }
    @RequestMapping("/employee")
    public List<Employee> getEmployees(){
        Employee employee = new Employee();

        return employee.listEmployees();
    }
    @RequestMapping(value = "/employee/save",method = RequestMethod.POST)
    public Employee getEmployees(@RequestBody Employee e){
        return employeeService.save(e);
    }

}

