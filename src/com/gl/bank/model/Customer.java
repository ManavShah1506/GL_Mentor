package com.gl.bank.model;

public class Customer {
 private String bankAccountno;
 private String password;
public String getBankAccountno() {
	return bankAccountno;
}
public void setBankAccountno(String bankAccountno) {
	this.bankAccountno = bankAccountno;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Customer(String bankAccountno, String password) {
	super();
	this.bankAccountno = bankAccountno;
	this.password = password;
}
 
}
