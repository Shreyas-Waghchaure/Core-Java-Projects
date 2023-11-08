package com.code;
/*roomType ( GENERAL(2000), SPECIAL(5000), 
 * SEMI-SPECIAL(3000),ICU(7000)).*/
public enum Rooms {
	GENERAL(2000),SEMISPECIAL(3000),SPECIAL(5000),ICU(7000);
	
	private double roombill;
	
	private Rooms(double Roombill) {
		this.roombill = Roombill;
	}

	public double getRoombill() {
		return roombill;
	}

	public void setRoombill(double roombill) {
		this.roombill = roombill;
	}
	
	@Override
	public String toString() {
		return name()+" Bill Amount: "+roombill;
	}
}
