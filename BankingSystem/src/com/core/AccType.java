package com.core;

public enum AccType {
	SAVINGS(10000),CURRENT(5000),FD(50000);
	
	private double minBalance;

	private AccType(double minBalance) {
		this.minBalance = minBalance;
	}
	
	@Override 
	public String toString() {
		return name() + " Minimum Bakance: "+minBalance;
				
	}

	public double getMinBalance() {
		return minBalance;
	}
}
