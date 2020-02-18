package com.sushain.EmployeeServiceApplication.Controller;

import com.sushain.EmployeeServiceApplication.model.Address;
import com.sushain.EmployeeServiceApplication.model.Employee;
import com.sushain.EmployeeServiceApplication.model.Project;
import com.sushain.EmployeeServiceApplication.model.Telephone;
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
        if (id==2){
            Employee employee = new Employee();
            employee.setId(2);
            employee.setName("Sushain");
            employee.setLocation("Piliyandala");
            Address address = new Address();
            address.setAddress("164/4");
            employee.setAddress(address);
            Telephone telephone = new Telephone();
            telephone.setTelephone("08888888");
            Project project = new Project();
            project.setProjects("aaaa");
            return employee;
        }else return new Employee();

    }
    @RequestMapping("/employee")
    public List<Employee> getEmployees(){
       return employeeService.findAllEmp();
    }

    @Transactional
    @RequestMapping(value = "/employees",method = RequestMethod.POST)
    public Employee getEmployees(@RequestBody Employee e){

        for (Telephone telephone : e.getTelephones()){
            telephone.setEmployee(e);
        }
        Employee eee = employeeService.save(e);
        return eee;
    }
    @RequestMapping("/allocation/{id}")
    public Employee getAllemployees(@PathVariable int id){

        Employee employee = employeeService.fetchallEmployees(id);
        return employee;



    }

}

