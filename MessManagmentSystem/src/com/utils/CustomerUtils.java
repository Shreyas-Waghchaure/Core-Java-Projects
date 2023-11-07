package com.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import com.Exception.InvalidInputException;
import com.app.core.Customer;
import com.app.core.MessPlan;

public class CustomerUtils {

	public static List<Customer> populateList() {

		ArrayList<Customer> data = new ArrayList<Customer>();
		data.add(new Customer("Ravi", "Patil", "ravi@gmail.com", "ravi", "Akurdi", "9123456780",
				LocalDate.parse("2023-12-06"), MessPlan.YEARLY));
		data.add(new Customer("Sunita", "Deshmukh", "sunita@gmail.com", "sunita", "ShivajiNagar", "9123456781",
				LocalDate.parse("2023-12-07"), MessPlan.MONTHLY));
		data.add(new Customer("amit", "Kulkarni", "amit@gmail.com", "amit", "Akurdi", "9123456782",
				LocalDate.parse("2023-12-08"), MessPlan.QUARTERLY));
		data.add(new Customer("geeta", "Joshi", "geeta@gmail.com", "geeta", "KalyaniNagar", "9123456783",
				LocalDate.parse("2023-12-09"), MessPlan.HALFYEAR));
		data.add(new Customer("Rajesh", "Chavan", "rajesh@gmail.com", "rajesh", "Akurdi", "9123456784",
				LocalDate.parse("2023-12-10"), MessPlan.YEARLY));

		return data;
	}

	public static Customer checkMail(List<Customer> cList, String email) throws InvalidInputException {

		Customer cust = new Customer(email);
		int index = cList.indexOf(cust);
		if (index == -1)
			throw new InvalidInputException("No such email exists");
		return cList.get(index);
	}

	public static Customer authenticate(List<Customer> cList, String email, String pass) throws InvalidInputException {

		Customer cust = checkMail(cList, email);
		if (!cust.getPassword().equals(pass))
			throw new InvalidInputException("Inavlid password!!");
		return cust;
	}

	public static LocalDate calcEndDate(MessPlan plan, LocalDate date) {
		if (plan == MessPlan.MONTHLY) {
			return date.plusMonths(1);
		} else if (plan == MessPlan.QUARTERLY) {
			return date.plusMonths(4);
		} else if (plan == MessPlan.HALFYEAR) {
			return date.plusMonths(6);
		} else {
			return date.plusMonths(12);
		}
	}

	public static void sortChoice(int choice, List<Customer> cList) {
		switch (choice) {
		case 1:
			cList.stream().sorted((cust1, cust2) -> cust1.getFname().compareTo(cust2.getFname()))
					.forEach(System.out::println);
			break;
		case 2:
			cList.stream().sorted((cust1, cust2) -> cust1.getPlan().compareTo(cust2.getPlan()))
					.forEach(System.out::println);
			break;
		case 3:
			cList.stream().sorted((cust1, cust2) -> cust1.getRegDate().compareTo(cust2.getRegDate()))
					.forEach(System.out::println);
		default:
			System.out.println("Invalid choice");
			break;
		}
	}
//	public static double calcDiscount(MessPlan plan) {
//
//		if (plan == MessPlan.YEARLY) {
//			return (plan.getPlanAmt()-(plan.getPlanAmt() * 0.20));
//		} else {
//			return plan.getPlanAmt();
//		}
}
