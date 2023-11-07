package com.app.core;

import java.time.LocalDate;

/*Reader id(int) ,first name, last name (string),email(string),password(string),registrationAmount(double),
 * dob(LocalDate),plan(ServicePlan : enum)
 */

public class Reader {
	
	private int readerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double regAmount;
	private LocalDate dob;
	private ServicePlan plan;
	private static int incId;
	
	static {
		incId = 100;
	}
	public Reader(String firstName, String lastName, String email, String password, double regAmount,
			LocalDate dob, ServicePlan plan) {
		super();
		incId++;
		this.readerId = incId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.dob = dob;
		this.plan = plan;
	}
	
	public Reader(String email) {
		super();
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public ServicePlan getPlan() {
		return plan;
	}
	public void setPlan(ServicePlan plan) {
		this.plan = plan;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Reader)
			return ((Reader)obj).getEmail().equals(email);
		return false;
	}

	@Override
	public String toString() {
		return "Reader [readerId=" + readerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", regAmount=" + regAmount + ", dob=" + dob + ", plan=" + plan
				+ "]";
	}
	
	
}
