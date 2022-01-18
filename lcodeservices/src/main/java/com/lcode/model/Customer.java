package com.lcode.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {
 
  private static final long serialVersionUID = 1L;
	
  @Id
  @Column(name = "CUSTNUM") 	
  private String custnumber;
  public String getCustnumber() {
	return custnumber;
}
public void setCustnumber(String custnumber) {
	this.custnumber = custnumber;
}
@Column(name = "CUSTNAME") 
private String custName;
  public String getCustName() {
	return custName;
}
public void setCustName(String custName) {
	this.custName = custName;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
@Column(name = "CUSTAGE") 
private int age;
   
}
