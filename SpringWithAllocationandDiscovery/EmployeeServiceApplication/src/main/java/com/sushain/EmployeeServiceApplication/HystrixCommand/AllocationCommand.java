package com.sushain.EmployeeServiceApplication.HystrixCommand;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.sushain.EmployeeServiceApplication.model.Allocation;
import com.sushain.EmployeeServiceApplication.model.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AllocationCommand extends HystrixCommand<Allocation[]> {

    Employee employee;
    HttpHeaders httpHeaders;
    RestTemplate restTemplate;

public AllocationCommand(Employee employee,HttpHeaders httpHeaders,RestTemplate restTemplate){
    super(HystrixCommandGroupKey.Factory.asKey("default"));
    this.employee = employee;
    this.httpHeaders = httpHeaders;
    this.restTemplate = restTemplate;
}


    @Override
    protected Allocation[] run() throws Exception {

    ResponseEntity<Allocation[]> responseEntity;
        HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);

        responseEntity = restTemplate.exchange("http://AllocationService/" + employee.getId(), HttpMethod.GET, httpEntity, Allocation[].class);

        return responseEntity.getBody();
    }

    @Override
    protected Allocation[] getFallback() {
        return new Allocation[1];
    }
}
