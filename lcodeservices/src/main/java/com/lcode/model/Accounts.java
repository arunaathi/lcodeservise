package com.lcode.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNTS_INFO")
public class Accounts implements Serializable{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
    private Accountkey accountsKey;
	
  public Accountkey getAccountsKey() {
		return accountsKey;
	}
	public void setAccountsKey(Accountkey accountsKey) {
		this.accountsKey = accountsKey;
	}
@Column(name = "ACCOUNTNAME")
  String accountName;
  @Column(name = "ACCOUNTTYPE")
  String accountType;
  
public String getAccountName() {
	return accountName;
}
public void setAccountName(String accountName) {
	this.accountName = accountName;
}
public String getAccountType() {
	return accountType;
}
public void setAccountType(String accountType) {
	this.accountType = accountType;
}
}
