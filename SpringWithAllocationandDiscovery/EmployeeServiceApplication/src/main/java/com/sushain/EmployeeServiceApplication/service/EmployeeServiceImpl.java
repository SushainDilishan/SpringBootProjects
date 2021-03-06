package com.sushain.EmployeeServiceApplication.service;

import com.sushain.EmployeeServiceApplication.HystrixCommand.AllocationCommand;
import com.sushain.EmployeeServiceApplication.Repository.EmployeeRepository;
import com.sushain.EmployeeServiceApplication.model.Allocation;
import com.sushain.EmployeeServiceApplication.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;
    @Override

    public Employee save(Employee e) {
        Employee employee = employeeRepository.save(e);
                return employee;
    }
    HttpHeaders httpHeaders = new HttpHeaders();
    HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

    public Allocation[] fetchAllocation(Employee employee) {
        AllocationCommand allocationCommand = new AllocationCommand(employee, httpHeaders, restTemplate);
        return allocationCommand.execute();
    }
    @Override
    public Employee fetchallEmployees(int id) {
        Optional<Employee> employee =employeeRepository.findById(id);
        if(employee.isPresent()){

//            HttpEntity<String> stringHttpEntity = new HttpEntity<>("", new HttpHeaders());

            Employee employee1 =employee.get();
//            ResponseEntity<Allocation[]> responseEntity = restTemplate.exchange("http://AllocationService/services/Map/"+id,
//                    HttpMethod.GET,stringHttpEntity, Allocation[].class);
            employee1.setAllocations(fetchAllocation(employee1));
            return  employee1;}
            else return null;
        }


    public List<Employee> findAllEmp(){
        return  employeeRepository.findAll();

    }

}
