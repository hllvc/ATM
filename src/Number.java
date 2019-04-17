import java.util.ArrayList;

public class Number extends Balance {

	private int number;
	private int pin;
	private ArrayList<Integer> numbers = new ArrayList<>();
	
	public Number() {
		
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
	
	public int getPin() {
		return this.pin;
	}
	
}
