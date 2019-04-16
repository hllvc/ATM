
public class Balance {

	private double balance;
	
	public Balance() {
		this.balance = 0;
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
	
}
