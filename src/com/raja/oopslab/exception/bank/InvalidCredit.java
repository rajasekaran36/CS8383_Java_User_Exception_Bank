package com.raja.oopslab.exception.bank;

public class InvalidCredit extends Exception {
	public InvalidCredit() {
		System.out.print("Please enter valid credit amount");
	}
}