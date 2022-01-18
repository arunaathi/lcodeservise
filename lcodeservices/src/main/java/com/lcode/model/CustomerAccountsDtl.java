package com.lcode.model;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomerAccountsDtl implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Customer cutinfo;
	private ArrayList<Accounts> listAccounts;
	public ArrayList<Accounts> getListAccounts() {
		return listAccounts;
	}
	public void setListAccounts(ArrayList<Accounts> listAccounts) {
		this.listAccounts = listAccounts;
	}
	public Customer getCutinfo() {
		return cutinfo;
	}
	public void setCutinfo(Customer cutinfo) {
		this.cutinfo = cutinfo;
	}
	
}
