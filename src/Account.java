
public class Account extends Number {

	private String name;
	private String surname;
	
	public Account(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	public String toString() {
		return  "----------------------------------------------"
				+ "\n--INFO--\n\n"
				+ "-Name: " + this.name
				+ "\n-Surname: " + this.surname
				+ "\n-Account number: *" + this.getNumber() + "*"
				+ "\n-Balance: $" + this.getBalance()
				+ "\n----------------------------------------------\n";
	}
	
	public String attention() {
		return "\nWrite down your ACCOUNT NUMBER!\nWith your ACCOUNT NUMBER you ADD/WITHDRAW or TRANSFER money!";
 
	}
	
}
