package com.gl.bank.service;

public interface CustomerService {

public boolean authenticate(String bankAccountno, String password);

public void deposit(int depositAmount);

public void withdrawl(int withdrawAmount);

public void transfer(int amount, String payeeAccountNo);

public String otpGeneration(int len);

}
