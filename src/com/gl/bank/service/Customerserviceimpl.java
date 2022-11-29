package com.gl.bank.service;

import java.util.Random;
import java.util.Scanner;
import com.gl.bank.model.Customer;

public class Customerserviceimpl implements CustomerService {
	static Scanner sc = new Scanner(System.in);
	
	Customer theCustomer = new Customer(sc.nextLine(),sc.nextLine());
	int bankBalance = sc.nextInt();
	

	@Override
	public boolean authenticate(String bankAccountno, String password) {
		// TODO Auto-generated method stub
		
	if (theCustomer.getBankAccountno().equalsIgnoreCase(bankAccountno)
				&& theCustomer.getPassword().equalsIgnoreCase(password)) {
		return true;	
		} 
	else {
        return false;
		}
	}

	@Override
	public void deposit(int depositAmount) {
		if (depositAmount > 0) {
			System.out.println("Amount "+depositAmount+" sucessfully deposited");
			bankBalance = bankBalance+depositAmount;
			System.out.println("Remaining Balance in account is Rs."+bankBalance);
		}
		else {
			System.out.println("Enter a valid Amount");
		}
		

	}

	@Override
	public void withdrawl(int withdrawAmount) {
		// TODO Auto-generated method stub
    if (withdrawAmount<bankBalance&&withdrawAmount>0) {
    	System.out.println("Amount "+withdrawAmount+" successful");
    	bankBalance = bankBalance-withdrawAmount;
    	System.out.println("Remaining Balance in account is Rs."+bankBalance);
    }
    else {
    	System.out.println("Insufficient Funds: Your current balance is: "+bankBalance);
    	
    }
	}

	@Override
	public void transfer(int amount, String payeeAcountNo) {
		if (amount<bankBalance&&amount>0) {
			System.out.println("Amount "+amount+" transferred successful to bank acount "+payeeAcountNo);
		bankBalance=bankBalance-amount;
		System.out.println("Remaining Balance in account is Rs."+bankBalance);
		}
		else {
			System.out.println("Insufficient Funds: Balance in account is Rs."+bankBalance);
		}
	}

	@Override
	public String otpGeneration(int len) {
	// int len=4;
	// System.out.println("Generating OTP using random() :");
	// System.out.println("Your OTP is:");
		
	// using numeric values
		String numbers = "0123456789";
	// Using Random Method
		Random rndm_method = new Random();
	// System.out.println("rndm_method.nextInt(numbers.length()));
		char[] otp = new char[len];
		for (int i = 0; i < len; i++) {
			otp[i]=numbers.charAt(rndm_method.nextInt(numbers.length()));
		}
		return new String(otp);
	}

}
