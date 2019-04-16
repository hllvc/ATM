import java.util.ArrayList;

public class Number extends Balance {

	private int number;
	private ArrayList<Integer> numbers = new ArrayList<>();
	
	public Number() {
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
	
	public int getNumber() {
		return this.number;
	}
	
}
