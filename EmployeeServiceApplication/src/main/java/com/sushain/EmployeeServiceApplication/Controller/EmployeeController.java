package com.sushain.EmployeeServiceApplication.Controller;

import com.sushain.EmployeeServiceApplication.model.Employee;
import com.sushain.EmployeeServiceApplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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
    @Transactional
    @RequestMapping(value = "/employees",method = RequestMethod.POST)
    public Employee getEmployees(@RequestBody Employee e){

         Employee eee = employeeService.save(e);
         return eee;
    }


}

