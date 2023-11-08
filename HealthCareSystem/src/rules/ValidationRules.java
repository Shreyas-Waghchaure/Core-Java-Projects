package rules;

import java.time.LocalDate;
import java.util.Map;

import com.code.Patient;
import com.code.Rooms;

import customeException.InvalidInputException;

public class ValidationRules {

	public static void checkPhoneNo(Map<String,Patient> patients,String phno) throws InvalidInputException {
		
		String Pattern = "^\\d{10}$";
		
		if(!phno.matches(Pattern))
			throw new InvalidInputException("Invalid phone no...");
		if(patients.containsKey(phno))
			throw new InvalidInputException("no duplicate phone no allowed");
		
	}
	
	public static LocalDate parseAndValidateDate(String date) throws InvalidInputException {
		
		LocalDate AdmitDate = LocalDate.parse(date);
		
		if(!AdmitDate.isEqual(LocalDate.now()))
			throw new InvalidInputException("Date should be Today's Date");
		
		return AdmitDate;
	}
	
	public static Rooms parseAndValidateRoom(String room) throws InvalidInputException {
		try {
			return Rooms.valueOf(room);
		}catch(Exception e) {
			throw new InvalidInputException("Invalid plan");
		}
	}
	
	public static Patient validateAll(int serialNo, String patientName, int age, String gender, String address, 
			String phoneNo,String disease, String admitDate, double bill, double annualIncome, 
			String room,Map<String,Patient>pList) throws InvalidInputException {
		
		checkPhoneNo(pList, phoneNo);
		LocalDate date = parseAndValidateDate(admitDate);
		Rooms allotedRoom = parseAndValidateRoom(room);
		return new Patient(serialNo, patientName, age, gender, address, phoneNo, disease, date, bill, annualIncome, allotedRoom);
	}
	
}
