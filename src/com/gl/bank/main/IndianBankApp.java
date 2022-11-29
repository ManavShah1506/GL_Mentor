package com.gl.bank.main;
import java.util.Scanner;

import com.gl.bank.service.CustomerService;
import com.gl.bank.service.Customerserviceimpl;
public class IndianBankApp {
    
    static CustomerService service = new Customerserviceimpl(); 
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Indian Bank Login Page");
		System.out.println();
	    System.out.println("Please enter your Bank Account No.");
	    String bankAccountNo = scan.nextLine();
	    System.out.println("Please enter your Password");
	    String password = scan.nextLine();
	    if (service.authenticate(bankAccountNo, password))
	    	login();
	    else
	    	System.out.println("Invalid Credentials");

	}
	private static void login() {
		Boolean flag = true;
		while (flag) {
			System.out.println();
			System.out.println("____________________________");
			System.out.println("Enter the operation that you want to perform:");
			System.out.println("1. Press 1 for Deposit");
			System.out.println("2. Press 2 for withdrawl");
			System.out.println("3. Press 3 for Transfer");
			System.out.println("0. Press 0 to Logout");
			int choice = scan.nextInt();
			switch (choice) {
			case 0: 
				flag = false;
				break;
			case 1: 
				System.out.println("Enter the amount you want to deposit");
				service.deposit(scan.nextInt());
				break;
			case 2: 
				System.out.println("Enter the amount you want to withdraw");
				service.withdrawl(scan.nextInt());
				break;
			case 3: 
				int length = 4;
				String otpGenerated = service.otpGeneration(length);
				System.out.println("Your OTP is "+otpGenerated);
				System.out.println("Please enter the 4 digit OTP ");
				String userOtp = scan.next();
				if (userOtp.equals(otpGenerated)) {
				System.out.println("OTP Verification Successful!!");
				System.out.println("Enter the Amount & Account No. to which you want to transfer");
				int amount = scan.nextInt();
				String payeeAccountNo = scan.next();
				service.transfer(amount, payeeAccountNo);
				}else  
				System.out.println("Invalid OTP please try again");
				break;	
				
				default:
				System.out.println("Please Enter A Valid Option");
				break;
			}
			
	}
	
		System.out.println("Logout Successful");
		scan.close();
	}

}
