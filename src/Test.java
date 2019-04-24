import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<User> UserList = new ArrayList<>();
	private static User mainAcc;
	
	private static void mainMenuText() {
		
		System.out.println("___________________________________________________________________\n"
				+ "\n----MAIN MENU----\n\n"
				+ "1) Create User\n"
				+ "2) Remove User\n"
				+ "3) Add Money\n"
				+ "4) Withdraw Money\n"
				+ "5) Transfter Money To Another User\n"
				+ "6) User Info\n"
				+ "\n0. Exit\n"
				+ "___________________________________________________________________\n");
		System.out.print("Your Choice: ");
		
	}
	
	private static void existingAccs() {
		
		System.out.println("\n**There Are No Existing Users!**");
		
	}
	
	private static void existingAcc() {
		
		System.out.print("\n**User doesn't exist!**\n");
		
	}
	
	private static void lenghtAcc() {

		System.out.println("\n**Lenght Of User Number Is Six**\n");
		
	}

	private static void lenghtPIN() {

		System.out.println("\n**Lenght Of PIN Is Four**\n");
		
	}
	
	private static void belowZero() {
		
		System.out.println("\n**Value Can't Be Below Zero!**");
		
	}
	
	private static User checkAcc(ArrayList<User> UserList, int accNumber) {
		
		for (User checkAcc: UserList) {
			if (checkAcc.getNumber() == accNumber) {
				return checkAcc;
			}
		}
		return null;
		
	}
	
	private static boolean checkAccNumber(int accNumber) {
		
		if (Integer.toString(accNumber).length() != 6)
			return true;
		else
			return false;
		
	}
	
	private static boolean checkPIN(int pin) {
		
		if (Integer.toString(pin).length() != 4)
			return true;
		else
			return false;
		
	}
	
	private static void createUser() {
		
		System.out.println("\n---CREATE User---\n");
		input.nextLine();
		String name, surname;
		System.out.print("Your Name: ");
		name = input.nextLine();
		System.out.print("Your Surname: ");
		surname = input.nextLine();
		mainAcc = new User(name, surname);
		System.out.println("\n**You Have Created Your User Successfully!**\n");
		System.out.println(mainAcc + mainAcc.attention());
		UserList.add(mainAcc);
		
	}
	
	private static void removeUser() {
		
		int accNumber, pin;
		if (UserList.isEmpty()) {
			existingAccs();
			return;
		}
		System.out.println("\n---REMOVE User---\n");
		do {
			System.out.print("User Number: ");
			accNumber = input.nextInt();
			if (Integer.toString(accNumber).length() != 6)
				lenghtAcc();
		} while (checkAccNumber(accNumber));
		mainAcc = checkAcc(UserList, accNumber);
		if (mainAcc == null)
			existingAcc();
		else {
			do {
				System.out.print("PIN: ");
				pin = input.nextInt();
				if (Integer.toString(pin).length() != 4)
					lenghtPIN();
			} while (checkPIN(pin) && mainAcc.getPin() != pin);
			if (pin == mainAcc.getPin()) {
				UserList.remove(mainAcc);
				System.out.println("\n**You Have Removed Your User Successfully!**\n");
			}
			else
				System.out.println("\n**Wrong PIN**\n");
		}
		
	}
	
	private static void addMoney() {
		
		if (UserList.isEmpty()) {
			existingAccs();
			return;
		}
		
		int accNumber, pin;
		double value;
		System.out.println("\n---ADD MONEY---\n");
		do {
			System.out.print("User Number: ");
			accNumber = input.nextInt();
			if (Integer.toString(accNumber).length() != 6)
				lenghtAcc();
		} while (checkAccNumber(accNumber));
		mainAcc = checkAcc(UserList, accNumber);
		if (mainAcc == null)
			existingAcc();
		else {
			do {
				System.out.print("PIN: ");
				pin = input.nextInt();
				if (Integer.toString(pin).length() != 4)
					lenghtPIN();
			} while (checkPIN(pin));
			if (pin == mainAcc.getPin()) {
				do {
					System.out.print("Value: ");
					value = input.nextDouble();
					if (value < 0)
						belowZero();
				} while (value < 0);
				mainAcc.addBalance(value);
				System.out.println("\n**Money Successfully Added To Your User!**\n");
			} else
				System.out.println("\n**Wrong PIN**\n");
		}
		
	}
	
	private static void withdrawMoney() {
		
		if (UserList.isEmpty()) {
			existingAccs();
			return;
		}
		
		int accNumber, pin;
		double value;
		System.out.println("\n---WITHDRAWAL---\n");
		do {
			System.out.print("User Number: ");
			accNumber = input.nextInt();
			if (Integer.toString(accNumber).length() != 6)
				lenghtAcc();
		} while (checkAccNumber(accNumber));
		mainAcc = checkAcc(UserList, accNumber);
		if (mainAcc == null)
			existingAcc();
		else {
			if (mainAcc.getBalance() == 0) {
				System.out.println("\n**Not Enough Founds On Selected User For Withrawal!**\n");
				return;
			}
			do {
				System.out.print("PIN: ");
				pin = input.nextInt();
				if (Integer.toString(pin).length() != 4)
					lenghtPIN();
			} while (checkPIN(pin));
			if (pin == mainAcc.getPin()) {
				do {
					System.out.print("Value: ");
					value = input.nextDouble();
					if (value < 0)
						belowZero();
					else if (value > mainAcc.getBalance())
					System.out.println("\n**Not Enough Founds**\n");
				} while (value < 0 || value > mainAcc.getBalance());
				mainAcc.removeBalance(value);
				System.out.println("\n**Don't Forget To PickUp Your Money Before Leaving! :)**\n");
			} else
				System.out.println("\n**Wrong PIN**\n");
		}

	}
	
	private static void transferMoney() {
		
		if (UserList.isEmpty() || UserList.size() < 2) {
			if (UserList.isEmpty())
				existingAccs();
			else
				System.out.println("\n**Minimal Number Of Users For Transfer Is 2 (Two)!**\n");
			return;
		}
		
		int accNumber, pin;
		double value;
		System.out.println("\n---MONEY TRANSFER---\n");
		do {
			System.out.print("Source User: ");
			accNumber = input.nextInt();
			if (Integer.toString(accNumber).length() != 6)
				lenghtAcc();
		} while (checkAccNumber(accNumber));
		mainAcc = checkAcc(UserList, accNumber);
		User targetAcc = null;
		if (mainAcc == null)
			existingAcc();
		else {
			if (mainAcc.getBalance() == 0) {
				System.out.println("\n**Not Enough Founds On Selected User For Transfer!**\n");
				return;
			}
			do {
				System.out.print("PIN: ");
				pin = input.nextInt();
				if (Integer.toString(pin).length() != 4)
					lenghtPIN();
			} while (checkPIN(pin));
			if (pin == mainAcc.getPin()) {
				do {
					do {
						System.out.print("Target User: ");
						accNumber = input.nextInt();
						if (Integer.toString(accNumber).length() != 6)
							lenghtAcc();
					} while (checkAccNumber(accNumber));
					for (User checkAcc: UserList) {
						if (checkAcc.getNumber() == accNumber) {
							targetAcc = checkAcc;
							break;
						}
					}
					if (targetAcc == null) {
						existingAcc();
						System.out.println();
					} else if (targetAcc == mainAcc)
						System.out.println("\n**You Can't Tranfer Money To Source User**\n");
				} while (targetAcc == null || targetAcc == mainAcc);
				do {
					System.out.print("Value: ");
					value = input.nextDouble();
					if (value < 0)
						belowZero();
					else if (value > mainAcc.getBalance())
						System.out.println("\n**Not Enough Founds**\n");
				} while (value < 0 || value > mainAcc.getBalance());
				mainAcc.removeBalance(value);
				targetAcc.addBalance(value);
				System.out.println("\n**Transfer Successful!**\n");
			} else
				System.out.println("\n**Wrong PIN**\n");
		}
		
	}
	
	private static void accStatus() {
		
		int accNumber, pin;
		if (UserList.isEmpty()) {
			existingAccs();
			return;
		}
		System.out.println("\n---User STATUS---\n");
		do {
			System.out.print("User Number: ");
			accNumber = input.nextInt();
			if (Integer.toString(accNumber).length() != 6)
				lenghtAcc();
		} while (checkAccNumber(accNumber));
		mainAcc = checkAcc(UserList, accNumber);
		if (mainAcc == null)
			existingAcc();
		else {
			do {
				System.out.print("PIN: ");
				pin = input.nextInt();
				if (Integer.toString(pin).length() != 4)
					lenghtPIN();
			} while (checkPIN(pin) && mainAcc.getPin() != pin);
			if (pin == mainAcc.getPin())
				System.out.println(mainAcc);
			else
				System.out.println("\n**Wrong PIN**\n");
		}


		
	}
	
	private static void mainMenu() {
		
		byte choice;
		do {
			
			mainMenuText();
			choice = input.nextByte();
			
			switch (choice) {
			
			case 1:
				createUser();
				break;
				
			case 2:
				removeUser();
				break;
				
			case 3:
				addMoney();
				break;
				
			case 4:
				withdrawMoney();
				break;
				
			case 5:
				transferMoney();
				break;
				
			case 6:
				accStatus();
				break;
				
			default:
				if (choice != 0)
					System.out.println("\n**There Are No Available Options For Your Choice**\n");
				break;
			
			}
			
		} while (choice != 0);
		System.out.println("\n**The ATM Has Stopped**");
		
	}
	
	public static void main(String[] args) {
		
		mainMenu();
		input.close();
		
	}
	
}
