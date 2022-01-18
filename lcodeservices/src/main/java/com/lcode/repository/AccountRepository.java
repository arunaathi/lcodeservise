package com.lcode.repository;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lcode.model.Accounts;
import com.lcode.model.Customer;

@Repository
public interface AccountRepository extends CrudRepository<Accounts, Integer> {
	
    @Query(value = "SELECT CUSTNUM,ACCOUNTNUM,ACCOUNTNAME,ACCOUNTTYPE FROM ACCOUNTS_INFO WHERE CUSTNUM =?1",nativeQuery = true)
    ArrayList<Accounts> getAccounts(String custId);
}
