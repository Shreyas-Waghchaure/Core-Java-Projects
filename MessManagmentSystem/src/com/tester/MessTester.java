package com.tester;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.app.core.Customer;
import com.app.core.MessPlan;


import static com.validations.ValidationRules.*;
import static com.utils.CustomerUtils.*;
import static com.io.IOUtils.*;

public class MessTester {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			List<Customer> customerList = populateList();
			boolean exit = false;

			while (!exit) {
				System.out.println("1) Sign up Customer\r\n" + "2) If already register then sign in\r\n"
						+ "3) Change Password  \r\n" + "4) Sort Customer \r\n"
						+ "5) Unsubscribe customer according plan duration (month wise (1, 3, 6, 12))\r\n"
						+ "6) Display all Customers\r\n"
						+ "7) Modify all customers first name (make first Letter capital of customers first name)\r\n"
						+ "8) Display email addresses of the customers who did registration in month of January\r\n"
						+ "9) Display count of the Customers who have register for plan: Monthly\r\n"
						+ "10) Search the Customer who lived in Akurdi.\r\n"
						+ "11) Give the 20% discount to the customers who have selected plan for 1 year.\r\n");
				System.out.println("Enter choice:");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out
								.println("Enter following Details:first name,  last name,  email,  password,  address,"
										+ "PhoneNo, regDate, plan");
						Customer customer = validateAllInput(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.next(), sc.next(), sc.next().toUpperCase(), customerList);
						customerList.add(customer);
						break;
					case 2:
						System.out.println("Enter email and password");
						Customer cust = authenticate(customerList, sc.next(), sc.next());
						System.out.println("Login Successful!! Welcome " + cust.getFname());
						break;
					case 3:
						System.out.println("Enter email and old password");
						cust = authenticate(customerList, sc.next(), sc.next());
						System.out.println("Enter new password:");
						cust.setPassword(sc.next());
						System.out.println("Password changed successfully");
						break;
					case 4:
						System.out.println(
								"sort by:1) First name \r\n" + 
								"	2) According to plan\r\n" + 
								"	3) According to date of registration\r\n");
						System.out.println("Enter choice you want to sort:");
						sortChoice(sc.nextInt(), customerList);
						
						break;
					case 5:
						customerList.removeIf(c->LocalDate.now().isAfter(c.getPlanEndDate()));
						System.out.println("Customers unsubscribed");
						break;
					case 6:
						System.out.println("Enter file name:");
						List<Customer> cList = reStore(sc.next());
						cList.forEach(System.out::println);
						break;
					case 7:
						//Modify all customers first name
						customerList.stream().map(c->{
							c.setFname(c.getFname().substring(0,1).toUpperCase()+c.getFname().substring(1));
							return c;
						}).forEach(c->c.getFname());
						System.out.println("Changes added");
						break;
					case 9:
						//Display count of the Customers who have register for plan: Monthly
						long count = customerList.stream()
						.filter(c->c.getPlan() == MessPlan.MONTHLY)
						.count();
						System.out.println("Total Customers: "+count);
						break;
					case 10:
						customerList.stream().filter(c -> c.getAddress().matches("^[a-zA-Z]kurdi"))
								.forEach(System.out::println);
						break;
					case 11:
						customerList.stream().filter(c -> c.getPlan() == MessPlan.YEARLY).forEach(
								c -> c.setFinal_amt(c.getPlan().getPlanAmt() - (c.getPlan().getPlanAmt() * 0.20)));
						System.out.println("Discount added");
						break;
					case 0:
						System.out.println("Enter file name:");
						store(customerList, sc.next());
						exit = true;
						break;
					}
				} catch (Exception e) {
					sc.nextLine();
					e.printStackTrace();
				}
			}

		}

	}

}
