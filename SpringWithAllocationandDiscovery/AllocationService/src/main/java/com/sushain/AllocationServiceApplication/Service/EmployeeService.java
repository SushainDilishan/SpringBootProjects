package com.sushain.AllocationServiceApplication.Service;

import com.sushain.AllocationServiceApplication.Model.Allocation;

import java.util.List;

public interface EmployeeService {
    public List<Allocation> findAllall();

    public Allocation save(Allocation allocation);

    public List<Allocation> findallocationbyEmpid(Integer id);
}
