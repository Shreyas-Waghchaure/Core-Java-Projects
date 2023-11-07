package com.exception;

public class TransactionDeniedException extends Exception{
	
	public TransactionDeniedException(String msg) {
		super(msg);
	}
}
