package com.app.core;

import java.io.Serializable;

public enum MessPlan implements Serializable{
	 MONTHLY (3000), QUARTERLY (11700), HALFYEAR (17500), YEARLY (32000);
	
	private double planAmt;

	private MessPlan(double planAmt) {
		this.planAmt = planAmt;
	}
	
	
	public double getPlanAmt() {
		return planAmt;
	}


	public void setPlanAmt(double planAmt) {
		this.planAmt = planAmt;
	}


	@Override
	public String toString() {
		return name()+" Amount:"+planAmt;
	}
	
}
