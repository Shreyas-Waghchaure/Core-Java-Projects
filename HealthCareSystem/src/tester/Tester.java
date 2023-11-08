package tester;

import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;
import static rules.ValidationRules.*;

import com.code.Patient;
import com.code.Rooms;

public class Tester {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			
			Map<String, Patient> patientMap = new HashMap<>();
			boolean flag = false;
			
			
			while(!flag) {
				
				System.out.println("1 add patient records.\r\n" + 
						"2 display all the patients.\r\n" + 
						"3 display all the patient who has annualIncome < 30000 then they can applicable for ”Rajeev Gandhi Yojana”. \r\n" + 
						"4 display all the patient details of room type chosen from the user.\r\n" + 
						"5 Remove all the patient who has disease “Diabetese”.    \r\n" + 
						"6 Change the roomType of a patient who is from “ICU” to SPECIAL room.\r\n" + 
						"7 display all the patients who’s age  >75.\r\n" + 
						"8 Sort the patients based on gender.\r\n");
				
				System.out.println("Enter choice:");
				
				switch(sc.nextInt()) {
				case 1:
					System.out.println("Enter patient Details:serialNo,  patientName,  age,  gender,  address,  phoneNo," + 
							" disease,  admitDate,  bill,  annualIncome,  room");
					Patient patient = validateAll(sc.nextInt(), sc.next(), sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.nextDouble(), sc.next().toUpperCase(), patientMap);
					patientMap.put(patient.getPhoneNo(), patient);
					break;
				case 2:
					patientMap.forEach((k,v)->System.out.println(v));
					break;
				case 3:
					System.out.println("Patiants applicable for Rajeev Gandhi Yoojna are:");
					patientMap.values().stream().filter(p->p.getAnnualIncome()<30000).forEach(System.out::println);
					break;
				case 4:
//					display all the patient details of room type chosen from the user.
					System.out.println("Enter room type");
					String room = sc.next().toUpperCase();
					patientMap.values().stream().filter(p->p.getRoom().equals(Rooms.valueOf(room))).forEach(System.out::println);
					break;
				case 5:
//					Remove all the patient who has disease “Diabetese”.
					patientMap.values().removeIf(p->p.getDisease().equals("diabetese"));
					break;
				case 6:
//					Change the roomType of a patient who is from “ICU” to SPECIAL room.
					patientMap.values().stream().filter(p->p.getRoom() == Rooms.ICU).forEach(p->p.setRoom(Rooms.SPECIAL));
					break;
				case 7:
//					display all the patients who’s age >75.
					patientMap.values().stream().filter(p->p.getAge()>75).forEach(System.out::println);
					break;
				case 8:
					//Sort the patients based on gender.
					patientMap.values().stream().sorted((p1,p2)->p1.getGender().compareTo(p2.getGender()));
					break;
				}
				
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
