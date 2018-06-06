package com.raja.oopslab.exception.bank;

public class InvalidDebit extends Exception {
	public InvalidDebit() {
		System.out.print("Please enter valid debit amount");
	}
}