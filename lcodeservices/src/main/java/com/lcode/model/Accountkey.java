package com.lcode.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Accountkey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "CUSTNUM", nullable = false)
    private String custnumber;

    @Column(name = "ACCOUNTNUM", nullable = false)
    private String  accountNumber;
    
    public String getAccountNumber() {
    	return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
    	this.accountNumber = accountNumber;
    }
	public String getCustnumber() {
		return custnumber;
	}
	public void setCustnumber(String custnumber) {
		this.custnumber = custnumber;
	}

    
}
