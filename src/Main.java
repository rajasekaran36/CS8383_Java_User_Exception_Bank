import java.util.Scanner;

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
				throw new InvalidAmmount();

			else
				balance = balance + amount;
		} catch (InvalidAmmount e) {
			amount = input.nextInt();
			creditTransaction(amount);
		}
	
	}
	
	public void displayDetails(){
		System.out.println("Customer Name : "+this.name);
		System.out.println("Customer AccNo : "+this.accNo);
		System.out.println("Customer Current Balance : "+this.balance);
	}
	
}

class InvalidAmmount extends Exception {
	public InvalidAmmount() {
		System.out.print("Please enter valid amount");
	}
}

public class Main {
	public static void main(String[] args) {
		Customer t = new Customer("Raja", 100);
		t.creditTransaction(-1);
		t.displayDetails();
	}
}
