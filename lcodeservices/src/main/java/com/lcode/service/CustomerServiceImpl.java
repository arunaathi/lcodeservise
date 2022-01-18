package com.lcode.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lcode.exception.UserException;
import com.lcode.model.Accounts;
import com.lcode.model.Customer;
import com.lcode.model.CustomerAccountsDtl;
import com.lcode.repository.AccountRepository;
import com.lcode.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	
	@Override
	public Customer findByCustid(String custId) {
		return customerRepository.findByCustid(custId);
	}
	
	@Override
	public void saveCustomer(Customer custinfo) throws UserException{
		try{
			customerRepository.delete(custinfo);
		    customerRepository.save(custinfo);
		}catch(Exception e){
			throw new UserException(e.getLocalizedMessage());
		}
	}

	@Override
	public ArrayList<Accounts> getAccounts(String custId) throws UserException{
		try{
		return accountRepository.getAccounts(custId);
		}catch(Exception e){
			throw new UserException(e.getLocalizedMessage());
		}
	}
	
	@Override
	public void saveAccount(Accounts accountinfo) throws UserException{
		try{
			accountRepository.delete(accountinfo); 
	     	accountRepository.save(accountinfo);
	   }catch(Exception e){
			throw new UserException(e.getLocalizedMessage());
		}
	}

	@Override
	public void saveAllAccount(ArrayList<Accounts> allAccounts) throws UserException {
		try{
			accountRepository.deleteAll(allAccounts); 
	     	accountRepository.saveAll(allAccounts);
	   }catch(Exception e){
			throw new UserException(e.getLocalizedMessage());
		}
		
	}
	@Override
	@Transactional(rollbackOn = { UserException.class })
	public void savecutAllAccount(CustomerAccountsDtl custaccdtl) throws UserException {
		try{
			saveCustomer(custaccdtl.getCutinfo());
			//System.out.println(2/0);
			saveAllAccount(custaccdtl.getListAccounts());
		}catch(Exception e){
			throw new UserException(e.getLocalizedMessage());
		}
		
	}


}
