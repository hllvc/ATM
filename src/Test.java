import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Account> AccountsList = new ArrayList<Account>();
	private static Account account1;
	
	private static Account checkAcc(ArrayList<Account> AccountsList, int accNumber) {
		
		for (Account checkAcc: AccountsList) {
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
	
	private static void createAccount() {
		
		AllText.createAccTitle();
		input.nextLine();
		String name, surname;
		AllText.name();
		name = input.nextLine();
		AllText.surname();
		surname = input.nextLine();
		account1 = new Account(name, surname);
		AllText.accCreation();
		AllText.accountInfo(account1);
		AllText.attention();
		AccountsList.add(account1);
		
	}
	
	private static void removeAccount() {
		
		if (AccountsList.isEmpty()) {
			AllText.existingAccs();
			return;
		}
		AllText.removeAccTitle();
		int accNumber = 0;
		do {
			try {
				AllText.accNumber();
				accNumber = input.nextInt();
				if (Integer.toString(accNumber).length() != 6)
					AllText.lenghtAcc();
			} catch (Exception e) {
				System.out.println("\n**NUMBER INPUT IS REQUIRED!**");
				input.nextLine();
			}
		} while (checkAccNumber(accNumber) || accNumber == 0);
		account1 = checkAcc(AccountsList, accNumber);
		if (account1 == null)
			AllText.existingAcc();
		else {
			int pin = 0;
			do {
				try {
					AllText.pin();
					pin = input.nextInt();
					if (Integer.toString(pin).length() != 4)
						AllText.lenghtPIN();
				} catch (Exception e) {
					System.out.println("\n**NUMBER INPUT IS REQUIRED!**");
					input.nextLine();
				}
			} while (checkPIN(pin) && account1.getPin() != pin || pin == 0);
			if (pin == account1.getPin()) {
				AccountsList.remove(account1);
				AllText.removedAcc();
			}
			else
				AllText.wrongPIN();
		}
		
	}
	
	private static void addMoney() {
		
		if (AccountsList.isEmpty()) {
			AllText.existingAccs();
			return;
		}
		
		AllText.addMoneyTitle();
		int accNumber = 0;
		double value;
		do {
			try {
				AllText.accNumber();
				accNumber = input.nextInt();
				if (Integer.toString(accNumber).length() != 6)
					AllText.lenghtAcc();
			} catch (Exception e) {
				System.out.println("\n**NUMBER INPUT IS REQUIRED!**");
				input.nextLine();
			}
		} while (checkAccNumber(accNumber) || accNumber == 0);
		account1 = checkAcc(AccountsList, accNumber);
		if (account1 == null)
			AllText.existingAcc();
		else {
			int pin = 0;
			do {
				try {
					AllText.pin();
					pin = input.nextInt();
					if (Integer.toString(pin).length() != 4)
						AllText.lenghtPIN();
				} catch (Exception e) {
					System.out.println("\n**NUMBER INPUT IS REQUIRED!**");
					input.nextLine();
				}
			} while (checkPIN(pin) || pin == 0);
			if (pin == account1.getPin()) {
				do {
					AllText.value();
					value = input.nextDouble();
					if (value < 0)
						AllText.belowZero();
				} while (value < 0);
				account1.addBalance(value);
				AllText.addedMoney();
			} else
				AllText.wrongPIN();
		}
		
	}
	
	private static void withdrawMoney() {
		
		if (AccountsList.isEmpty()) {
			AllText.existingAccs();
			return;
		}
		
		double value;
		AllText.withdrawalTitle();
		int accNumber = 0;
		do {
			try {
				AllText.accNumber();
				accNumber = input.nextInt();
				if (Integer.toString(accNumber).length() != 6)
					AllText.lenghtAcc();
			} catch (Exception e) {
				System.out.println("\n**NUMBER INPUT IS REQUIRED!**");
				input.nextLine();
			}
		} while (checkAccNumber(accNumber) || accNumber == 0);
		account1 = checkAcc(AccountsList, accNumber);
		if (account1 == null)
			AllText.existingAcc();
		else {
			if (account1.getBalance() == 0) {
				AllText.noFounds();
				return;
			}
			int pin = 0;
			do {
				try {
					AllText.pin();
					pin = input.nextInt();
					if (Integer.toString(pin).length() != 4)
						AllText.lenghtPIN();
				} catch (Exception e) {
					System.out.println("\n**NUMBER INPUT IS REQUIRED!**");
					input.nextLine();
				}
			} while (checkPIN(pin) || pin == 0);
			if (pin == account1.getPin()) {
				do {
					AllText.value();
					value = input.nextDouble();
					if (value < 0)
						AllText.belowZero();
					else if (value > account1.getBalance())
					AllText.noFounds();
				} while (value < 0 || value > account1.getBalance());
				account1.removeBalance(value);
				AllText.pickUpMsg();
			} else
				AllText.wrongPIN();
		}

	}
	
	private static void transferMoney() {
		
		if (AccountsList.isEmpty() || AccountsList.size() < 2) {
			if (AccountsList.isEmpty())
				AllText.existingAccs();
			else
				AllText.minAccs();
			return;
		}
		
		int accNumber = 0;
		double value;
		AllText.moneyTransferTitle();
		do {
			try {
				AllText.accNumber();
				accNumber = input.nextInt();
				if (Integer.toString(accNumber).length() != 6)
					AllText.lenghtAcc();
			} catch (Exception e) {
				System.out.println("\n**NUMBER INPUT IS REQUIRED!**");
				input.nextLine();
			}
		} while (checkAccNumber(accNumber) || accNumber == 0);
		account1 = checkAcc(AccountsList, accNumber);
		Account targetAcc = null;
		if (account1 == null)
			AllText.existingAcc();
		else {
			if (account1.getBalance() == 0) {
				AllText.noFounds();
				return;
			}
			int pin = 0;
			do {
				try {
					AllText.pin();
					pin = input.nextInt();
					if (Integer.toString(pin).length() != 4)
						AllText.lenghtPIN();
				} catch (Exception e) {
					System.out.println("\n**NUMBER INPUT IS REQUIRED!**");
					input.nextLine();
				}
			} while (checkPIN(pin) || pin == 0);
			if (pin == account1.getPin()) {
				do {
					do {
						try {
							AllText.targetAcc();
							accNumber = input.nextInt();
							if (Integer.toString(accNumber).length() != 6)
								AllText.lenghtAcc();
						} catch (Exception e) {
							System.out.println("\n**NUMBER INPUT IS REQUIRED!**");
							input.nextLine();
						}
					} while (checkAccNumber(accNumber) || accNumber == 0);
					for (Account checkAcc: AccountsList) {
						if (checkAcc.getNumber() == accNumber) {
							targetAcc = checkAcc;
							break;
						}
					}
					if (targetAcc == null) {
						AllText.existingAcc();
						System.out.println();
					} else if (targetAcc == account1)
						AllText.noToSource();
				} while (targetAcc == null || targetAcc == account1);
				do {
					AllText.value();
					value = input.nextDouble();
					if (value < 0)
						AllText.belowZero();
					else if (value > account1.getBalance())
						AllText.noFounds();
				} while (value < 0 || value > account1.getBalance());
				account1.removeBalance(value);
				targetAcc.addBalance(value);
				AllText.successfull();
			} else
				AllText.wrongPIN();
		}
		
	}
	
	private static void accStatus() {
		
		if (AccountsList.isEmpty()) {
			AllText.existingAccs();
			return;
		}
		AllText.accountStatusTitle();
		int accNumber = 0;
		do {
			try {
				AllText.accNumber();
				accNumber = input.nextInt();
				if (Integer.toString(accNumber).length() != 6)
					AllText.lenghtAcc();
			} catch (Exception e) {
				System.out.println("\n**NUMBER INPUT IS REQUIRED!**");
				input.nextLine();
			}
		} while (checkAccNumber(accNumber) || accNumber == 0);
		account1 = checkAcc(AccountsList, accNumber);
		if (account1 == null)
			AllText.existingAcc();
		else {
			int pin = 0;
			do {
				try {
					AllText.pin();
					pin = input.nextInt();
					if (Integer.toString(pin).length() != 4)
						AllText.lenghtPIN();
				} catch (Exception e) {
					System.out.println("\n**NUMBER INPUT IS REQUIRED!**");
					input.nextLine();
				}
			} while (checkPIN(pin) || pin == 0);
			if (pin == account1.getPin())
				AllText.accountInfo(account1);
			else
				AllText.wrongPIN();
		}


		
	}
	
	private static void mainMenu() {
		
		byte choice;
		try {
			do {
				
				AllText.mainMenuText();
				choice = input.nextByte();
				
				switch (choice) {
				
				case 1:
					createAccount();
					break;
					
				case 2:
					removeAccount();
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
						AllText.noOptions();
					break;
				
				}
				
			} while (choice != 0);
		} catch (Exception e) {
			System.out.println("\n**NUMBER INPUT IS REQUIRED!**");
			input.nextLine();
			mainMenu();
		}
		
	}
	
	public static void main(String[] args) {
		
		mainMenu();
		input.close();
		AllText.stopped();
		
	}
	
}
