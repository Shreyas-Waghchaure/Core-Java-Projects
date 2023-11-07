package com.tester;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.core.BankAccount;
import com.exception.InvalidInputException;

import static com.utils.BankAccountUtils.*;
import static com.validationrules.ValidationRules.*;

public class BankTester {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)){
			Map<Integer, BankAccount> accounts = new HashMap<>(populateMap());
			boolean exit = false;
			
			while(!exit) {
				System.out.println("Options 1. Create A/C 2. Display all accts 3. Show a/c summary \n"
						+ "4. Transfer Funds 5. Close A/c 6. Disable unused accts \n"
						+ "7. Sort accts as per acct no \n" + "8. Sort accts as per  balance \n"
						+ "9.display the accounts sorted as per creation date n customer name \n"
						+ "10. Delete account which are inactive for 2 years \n0. Exit");
				
				try {
					switch(sc.nextInt()) {
					case 1:
						BankAccount account = validateAllExeption(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble(), sc.next(), accounts);
						accounts.put(account.getAccNo(), account);
						break;
					case 2:
						accounts.values().forEach(i->System.out.println(i));
						break;
					case 3:
						System.out.println("Enter Account number:");
						account = accounts.get(sc.nextInt());
						System.out.println(account);
						break;
					case 4:
						System.out.println("Enter your account number and source account number and amount to transfer:");
						BankAccount srcAcc = accounts.get(sc.nextInt());
						if(srcAcc == null)
							throw new InvalidInputException("Invalid account number");
						BankAccount destAcc = accounts.get(sc.nextInt());
						if(destAcc == null)
							throw new InvalidInputException("Invalid account number");
						srcAcc.transferFunds(destAcc, sc.nextDouble());
						break;
					case 5:
						System.out.println("Enter account number:");
						accounts.remove(sc.nextInt());
						break;
					case 6:
						disableAccount(accounts);
						break;
					case 7:
						Map<Integer,BankAccount> sortMap = new TreeMap<Integer, BankAccount>(accounts);
						
						for(BankAccount bac:sortMap.values()) {
							System.out.println(bac);
						}
						break;
					}
				}catch(Exception e) {
					System.out.println(e);
				}
			}
		}
	}
}
