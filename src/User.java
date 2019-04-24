
public class User {

	private Account userAcc = new Account();
	private String name;
	private String surname;
	
	public User(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	public String toString() {
		return  "----------------------------------------------"
				+ "\n--INFO--\n\n"
				+ "-Name: " + this.name
				+ "\n-Surname: " + this.surname
				+ "\n-Account number: *" + userAcc.getNumber() + "*"
				+ "\n-PIN: *" + userAcc.getPin() + "*"
				+ "\n-Balance: $" + userAcc.getBalance()
				+ "\n----------------------------------------------\n";
	}
	
	public String attention() {
		return "\nWrite down your ACCOUNT NUMBER & PIN!\nWith your ACCOUNT NUMBER & PIN you ADD/WITHDRAW or TRANSFER money!";
 
	}
	
	public int getNumber() {
		return this.userAcc.getNumber();
	}
	
	public int getPin() {
		return this.userAcc.getPin();
	}
	
	public void addBalance(double balance) {
		this.userAcc.addBalance(balance);
	}
	
	public double getBalance() {
		return this.userAcc.getBalance();
	}
	
	public void removeBalance(double balance) {
		this.userAcc.removeBalance(balance);
	}
	
}
