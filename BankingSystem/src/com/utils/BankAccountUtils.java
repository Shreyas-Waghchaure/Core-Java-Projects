package com.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

import com.core.AccType;
import com.core.BankAccount;

public class BankAccountUtils {

	public static Map<Integer,BankAccount> populateMap(){
		Map<Integer,BankAccount> accts = new HashMap<>();
		System.out.println("Added "
				+ accts.put(101, new BankAccount(101, "Rama", AccType.SAVINGS, 15000, LocalDate.parse("2023-01-01"))));
		System.out.println("Added "
				+ accts.put(10, new BankAccount(10, "Shubham", AccType.SAVINGS, 23000, LocalDate.parse("2022-01-01"))));

		System.out.println("Added "
				+ accts.put(15, new BankAccount(15, "Kiran", AccType.FD, 150000, LocalDate.parse("2022-11-01"))));

		System.out.println("Added "
				+ accts.put(34, new BankAccount(34, "Mihir", AccType.SAVINGS, 13000, LocalDate.parse("2023-01-01"))));

		System.out.println("Added "
				+ accts.put(25, new BankAccount(25, "Rama", AccType.CURRENT, 6000, LocalDate.parse("2022-11-07"))));

		System.out.println("Added "
				+ accts.put(11, new BankAccount(11, "Rama", AccType.FD, 200000, LocalDate.parse("2023-06-01"))));

		System.out.println("Added " + accts.putIfAbsent(35,
				new BankAccount(35, "Mihir2", AccType.SAVINGS, 14000, LocalDate.parse("2020-09-21"))));
		
		return accts;
		
	}
	
	public static void disableAccount(Map<Integer,BankAccount> acc) {
		for(BankAccount bac:acc.values()) {
			long inactiveMonths = (Period.between(bac.getLastTxDate(), LocalDate.now())).toTotalMonths();
			
			if(inactiveMonths > 12) {
				bac.setActive(false);
			}
		}
		
	}
}
