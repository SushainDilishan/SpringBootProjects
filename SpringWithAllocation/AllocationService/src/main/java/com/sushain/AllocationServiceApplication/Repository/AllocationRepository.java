package com.sushain.AllocationServiceApplication.Repository;

import com.sushain.AllocationServiceApplication.Model.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationRepository extends JpaRepository<Allocation,Integer> {

}

