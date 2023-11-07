package com.validationrules;

import java.time.LocalDate;
import java.util.Map;

import com.core.AccType;
import com.core.BankAccount;
import com.exception.InsufficientBalanceException;
import com.exception.InvalidInputException;

public class ValidationRules {

	public static void checkMinBalance(AccType actype, double amt) throws InsufficientBalanceException {
		if (actype.getMinBalance() > amt)
			throw new InsufficientBalanceException("Insufficent balance");
	}

	public static AccType parseAndValidateType(String acType) {
		return AccType.valueOf(acType.toUpperCase());
	}

	public static BankAccount validateAllExeption(int acctNo, String cName, String acType, double balance,
			String creationDate, Map<Integer, BankAccount> map)
			throws InvalidInputException, InsufficientBalanceException {
		if (map.containsKey(acctNo))
			throw new InvalidInputException("Duplicate Account number");
		AccType type = parseAndValidateType(acType);
		checkMinBalance(type, balance);
		LocalDate date = LocalDate.parse(creationDate);
		return new BankAccount(acctNo, cName, type, balance, date);
	}
}
