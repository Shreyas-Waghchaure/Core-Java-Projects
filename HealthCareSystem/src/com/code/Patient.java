package com.code;

import java.time.LocalDate;

/*SerialNo (int), patientName(String), age(int), gender(String), address(String), phoneNumber(String), disease(String), 
  admitDate(LocalDate), Bill(double), annualIncome(double),roomType ( GENERAL(2000), SPECIAL(5000), 
  SEMI-SPECIAL(3000),ICU(7000)).
 */

public class Patient {
	private int serialNo;
	private String patientName;
	private int age;
	private String gender;
	private String address;
	private String phoneNo;
	private String disease;
	private LocalDate admitDate;
	private double bill;
	private double annualIncome;
	private Rooms room;
	public Patient(int serialNo, String patientName, int age, String gender, String address, String phoneNo,
			String disease, LocalDate admitDate, double bill, double annualIncome, Rooms room) {
		super();
		this.serialNo = serialNo;
		this.patientName = patientName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phoneNo = phoneNo;
		this.disease = disease;
		this.admitDate = admitDate;
		this.bill = bill;
		this.annualIncome = annualIncome;
		this.room = room;
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public LocalDate getAdmitDate() {
		return admitDate;
	}
	public void setAdmitDate(LocalDate admitDate) {
		this.admitDate = admitDate;
	}
	public double getBill() {
		return bill;
	}
	public void setBill(double bill) {
		this.bill = bill;
	}
	public double getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}
	public Rooms getRoom() {
		return room;
	}
	public void setRoom(Rooms room) {
		this.room = room;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Patient)
			return phoneNo.equals(((Patient) obj).getPhoneNo());
		return false;
	}
	@Override
	public String toString() {
		return "Patient [serialNo=" + serialNo + ", patientName=" + patientName + ", age=" + age + ", gender=" + gender
				+ ", address=" + address + ", phoneNo=" + phoneNo + ", disease=" + disease + ", admitDate=" + admitDate
				+ ", bill=" + bill + ", annualIncome=" + annualIncome + ", room=" + room + "]";
	}
	
}
