import java.util.ArrayList;

public class Account {

	private double balance;
	private String name;
	private String surname;
	private int number;
	private int pin;
	private ArrayList<Integer> numbers = new ArrayList<Integer>();
	
	public Account(String name, String surname) {
		this.name = name;
		this.surname = surname;
		this.balance = 0;
		numbers = new ArrayList<>();
		generateRandomNumber();
		generateRandompin();
	}
	
	private void generateRandomNumber() {
		boolean existing;
		do {
			existing = false;
			this.number = (int)(Math.random() * 899999 + 100000);
			for (int x: this.numbers)
				if (x == this.number) {
					existing = true;
					break;
				}
		} while (existing);
		numbers.add(this.number);
	}
	
	private void generateRandompin() {
		this.pin = (int)(Math.random() * 8999 + 1000);
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public void setNumber(int number) {
		this.number = number;
		this.numbers.add(this.number);
	}
	
	public int getPin() {
		return this.pin;
	}
	
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void addBalance(double balance) {
		this.balance += balance;
	}
	
	public void removeBalance(double balance) {
		this.balance -= balance;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
