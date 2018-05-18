import java.util.Scanner;

import javax.tools.Diagnostic;

class Customer {
	String name;
	int accNo;
	int balance;

	public Customer(String name, int accNo) {
		this.name = name;
		this.accNo = accNo;
		this.balance = 0;
	}

	public void creditTransaction(int amount) {
		Scanner input = new Scanner(System.in);
		try {
			if (amount < 0)
				throw new InvalidCredit();

			else
				balance = balance + amount;
		} catch (InvalidCredit e) {
			amount = input.nextInt();
			creditTransaction(amount);
		}
	
	}
	
	public void debitTransaction(int amount) {
		Scanner input = new Scanner(System.in);
		try {
			if (amount > balance)
				throw new InvalidDebit();

			else
				balance = balance - amount;
		} catch (InvalidDebit e) {
			amount = input.nextInt();
			debitTransaction(amount);
		}
	
	}
	
	public void displayDetails(){
		System.out.println("Customer Details");
		System.out.println("****************");
		System.out.println("Customer Name : "+this.name);
		System.out.println("Customer AccNo : "+this.accNo);
		System.out.println("Customer Current Balance : "+this.balance);
	}
	
}

class InvalidCredit extends Exception {
	public InvalidCredit() {
		System.out.print("Please enter valid credit amount");
	}
}

class InvalidDebit extends Exception {
	public InvalidDebit() {
		System.out.print("Please enter valid debit amount");
	}
}
public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String name;
		int acc_no;
		System.out.println("Enter Customer Name");
		name = input.next();
		System.out.println("Enter account number");
		acc_no = input.nextInt(); 
		Customer aCustomer = new Customer(name, acc_no);
		int choice = 0;
		while(choice != 4){
			System.out.println("\n1. Add Money\n2. Get Money\n3. Details\n4. Exit");
			choice = input.nextInt();
			switch(choice){
			case 1:
				System.out.println("Enter the amount");
				aCustomer.creditTransaction(input.nextInt());
				break;
			case 2:
				System.out.println("Enter the amount");
				aCustomer.debitTransaction(input.nextInt());
				break;
			case 3:
				aCustomer.displayDetails();
				break;
			case 4:
				System.out.println("Thank You !!!");
				break;
			}
		}
	}
}
