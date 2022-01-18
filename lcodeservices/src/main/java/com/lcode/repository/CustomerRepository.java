package com.lcode.repository;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lcode.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	@Query(value = "SELECT CUSTNUM,CUSTNAME,CUSTAGE FROM CUSTOMER WHERE CUSTNUM = ?1",nativeQuery = true)
    Customer findByCustid(String custId);
	
}  
