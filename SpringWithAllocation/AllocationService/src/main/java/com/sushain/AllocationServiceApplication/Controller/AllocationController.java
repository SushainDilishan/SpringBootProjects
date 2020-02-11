package com.sushain.AllocationServiceApplication.Controller;

import com.sushain.AllocationServiceApplication.Model.Allocation;
import com.sushain.AllocationServiceApplication.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class AllocationController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/test")
    public Allocation getTest(){

    Allocation allocation=new Allocation();
    allocation.setEmpid(1);
    allocation.setEndDate("sfsdf");
    allocation.setStartDate("sdfsdf");
    allocation.setProjectName("sushen");

        return allocation;
    }

    @RequestMapping("/Allocations")
    public List<Allocation> getAllocations(){
        return employeeService.findAllall();
    }
    @RequestMapping(value ="/insert",method = RequestMethod.POST)
    public Allocation getAllocation(@RequestBody Allocation allocation) {
        Allocation allocation1 = employeeService.save(allocation);
        return allocation1;
    }

        @RequestMapping("Employee")
        public List<Allocation> GetallocationbyEid(Integer id){

            return employeeService.findallocationbyEmpid(id);
        }
        @RequestMapping("/Map/{id}")

    public List<Allocation> allocations(@PathVariable Integer id){

        List<Allocation> allocation=  employeeService.findallocationbyEmpid(id);
        return  allocation;

        }

    }
