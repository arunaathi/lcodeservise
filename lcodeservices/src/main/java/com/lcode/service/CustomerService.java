package com.lcode.service;

import java.util.ArrayList;

import com.lcode.exception.UserException;
import com.lcode.model.Accounts;
import com.lcode.model.Customer;
import com.lcode.model.CustomerAccountsDtl;

public interface CustomerService {

	Customer findByCustid(String custId);
	
	public void saveCustomer(Customer custinfo) throws UserException;
	
	public void saveAccount(Accounts accountinfo) throws UserException;
	
	public void saveAllAccount(ArrayList<Accounts> allAccounts) throws UserException;
	
	public void savecutAllAccount(CustomerAccountsDtl custaccdtl) throws UserException;
	
	ArrayList<Accounts> getAccounts(String custId) throws UserException;
	
}
