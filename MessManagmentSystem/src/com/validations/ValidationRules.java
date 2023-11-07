package com.validations;

import java.time.LocalDate;
import java.util.List;

import com.Exception.InvalidInputException;
import com.app.core.Customer;
import com.app.core.MessPlan;

public class ValidationRules {

	public static void validateEmail(String email,List<Customer>cust) throws InvalidInputException{
		
		Customer c = new Customer(email);
		String pattern = "[a-z]+[a-z0-9]+@[a-z]*\\.(com|org|net)";
		if (!email.matches(pattern))
			throw new InvalidInputException("Email invalid!!!!!!");
		if (cust.contains(c)) {
			throw new InvalidInputException("Dup email !!!!");
		}
	}
	
	public static MessPlan parseAndValidatePlan(String plan) throws InvalidInputException {
		try {
			return MessPlan.valueOf(plan);
		}catch(Exception e) {
			throw new InvalidInputException("Invalid Plan");
		}
	}
	
	public static LocalDate parseAndValidateDate(String date) throws InvalidInputException {
		LocalDate regDate = LocalDate.parse(date);
		if(regDate.compareTo(LocalDate.now())<0) {
			throw new InvalidInputException("Date must me todays or after todays date");
		}
		return regDate;
	}

	
	public static void validatePhoneNo(String phNo) throws InvalidInputException{
		String pattern = "^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$";
		
		if(!(phNo.matches(pattern)))
			throw new InvalidInputException("Invalid Phone Number");
	}
	
	public static Customer validateAllInput(String fname, String lname, String email, String password, String address,
		String phoneNo,String regDate, String plan,List<Customer> cust)throws InvalidInputException {
		validateEmail(email,cust);
		MessPlan mPlan = parseAndValidatePlan(plan);
		LocalDate date = parseAndValidateDate(regDate);
		validatePhoneNo(phoneNo);
		return new Customer(fname, lname, email, password, address,phoneNo, date, mPlan);
	}
	
}
