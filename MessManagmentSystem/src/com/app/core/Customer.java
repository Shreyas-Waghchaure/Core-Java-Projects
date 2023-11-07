package com.app.core;
/*Customer id(int) , first name(String), last name (String), email(String), password(String),
 *  Address String, RegisterDate(LocalDate), planEndDate(LocalDate), Address(String),
 *   Phone No(String),plan Enum, final_amount double
 */

import java.io.Serializable;
import java.time.LocalDate;

import static com.utils.CustomerUtils.*;

@SuppressWarnings("serial")
public class Customer implements Serializable{
	private int custId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String address;
	private String phoneNo;
	private LocalDate regDate;
	private LocalDate planEndDate;
	private MessPlan plan;
	private double final_amt;
	private static int incID;
	static {
		incID = 100;
	}
	public Customer(String fname, String lname, String email, String password, String address,
			String phoneNo,LocalDate regDate, MessPlan plan) {
		super();
		incID++;
		this.custId = incID;
		this.firstName = fname;
		this.lastName = lname;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phoneNo = phoneNo;
		this.regDate = regDate;
		this.plan = plan;
		this.planEndDate = calcEndDate(this.plan, this.regDate);
		final_amt = plan.getPlanAmt();
	}
	public Customer(String email) {
		super();
		this.email = email;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Customer)
		return ((Customer) obj).getEmail().equals(email);
	return false;
	}
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId; 
	}
	public String getFname() {
		return firstName;
	}
	public void setFname(String fname) {
		this.firstName = fname;
	}
	public String getLname() {
		return lastName;
	}
	public void setLname(String lname) {
		this.lastName = lname;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}
	public LocalDate getPlanEndDate() {
		return planEndDate;
	}
	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}
	public MessPlan getPlan() {
		return plan;
	}
	public void setPlan(MessPlan plan) {
		this.plan = plan;
	}
	public double getFinal_amt() {
		return final_amt;
	}

	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", address=" + address + ", phoneNo=" + phoneNo + ", regDate=" + regDate
				+ ", planEndDate=" + planEndDate + ", plan=" + plan + ", final amount=" + final_amt + "]";
	}
	public void setFinal_amt(double final_amt) {
		this.final_amt = final_amt;
	}

	
	
	
}
