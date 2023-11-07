package com.core;

import java.time.LocalDate;

import com.exception.InsufficientBalanceException;
import com.exception.TransactionDeniedException;
import static com.validationrules.ValidationRules.checkMinBalance;

public class BankAccount {
	private int accNo;
	private String cName;
	private AccType acType;
	private double balance;
	private LocalDate acOpeningDate;
	private LocalDate lastTxDate;
	private boolean isActive;
	public BankAccount(int accNo, String cName, AccType acType, double balance, LocalDate acOpeningDate) {
		super();
		this.accNo = accNo;
		this.cName = cName;
		this.acType = acType;
		this.balance = balance;
		this.acOpeningDate = acOpeningDate;
		this.lastTxDate = acOpeningDate;
		this.isActive = true;
	}
	@Override
	public String toString() {
		return "BankAccount [accNo=" + accNo + ", cName=" + cName + ", acType=" + acType + ", balance=" + balance
				+ ", acOpeningDate=" + acOpeningDate + ", isActive=" + isActive + "]";
	}

	//Business Logic
	
	public void deposit(double amt)throws TransactionDeniedException{
		if(!isActive)
			throw new TransactionDeniedException("Your account is not active! please contact to bank...");
		balance +=amt;
	}
	
	public void withdraw(double amt) throws TransactionDeniedException,InsufficientBalanceException{
		if(!isActive)
			throw new TransactionDeniedException("Your account is not active! please contact to bank...");
		checkMinBalance(acType, this.balance-amt);
		balance -=amt;
	}
	
	public void transferFunds(BankAccount dest,double amt)throws TransactionDeniedException,InsufficientBalanceException {
		this.withdraw(amt);
		dest.deposit(amt);
	}
	
	public void applySimpleInterest(double rates,int year) {
		balance = (balance*rates*year)/100;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public LocalDate getAcOpeningDate() {
		return acOpeningDate;
	}
	public void setAcOpeningDate(LocalDate acOpeningDate) {
		this.acOpeningDate = acOpeningDate;
	}
	public LocalDate getLastTxDate() {
		return lastTxDate;
	}
	public void setLastTxDate(LocalDate lastTxDate) {
		this.lastTxDate = lastTxDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getAccNo() {
		return accNo;
	}
	public AccType getAcType() {
		return acType;
	}
	
}
