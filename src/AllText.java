
public class AllText {

	protected static void mainMenuText() {
		System.out.println("___________________________________________________________________\n"
				+ "\n----MAIN MENU----\n\n"
				+ "1) Create Account\n"
				+ "2) Remove Account\n"
				+ "3) Add Money\n"
				+ "4) Withdraw Money\n"
				+ "5) Transfter Money To Another Account\n"
				+ "6) Account Info\n"
				+ "\n0. Exit\n"
				+ "___________________________________________________________________\n");
		System.out.print("Your Choice: ");
	}
	
	protected static void accountInfo(Account account) {
		System.out.println("----------------------------------------------"
				+ "\n--INFO--\n\n"
				+ "-Name: " + account.getName()
				+ "\n-Surname: " + account.getSurname()
				+ "\n-Account number: *" + account.getNumber() + "*"
				+ "\n-PIN: *" + account.getPin() + "*"
				+ "\n-Balance: $" + account.getBalance()
				+ "\n----------------------------------------------\n");
	}
	
	protected static void existingAccs() {
		System.out.println("\n**There Are No Existing Accounts!**");
	}
	
	protected static void existingAcc() {
		System.out.print("\n**Account doesn't exist!**\n");
	}
	
	protected static void lenghtAcc() {
		System.out.println("\n**Lenght Of Account Number Is Six**\n");
	}

	protected static void lenghtPIN() {
		System.out.println("\n**Lenght Of PIN Is Four**\n");
	}
	
	protected static void belowZero() {
		System.out.println("\n**Value Can't Be Below Zero!**");
	}
	
	protected static void accCreation() {
		System.out.println("\n**You Have Created Your Account Successfully!**\n");
	}
	
	protected static void removedAcc() {
		System.out.println("\n**You Have Removed Your Account Successfully!**\n");
	}
	
	protected static void addedMoney() {
		System.out.println("\n**Money Successfully Added To Your Account!**\n");
	}
	
	protected static void accNumber() {
		System.out.print("Account Number: ");
	}
	
	protected static void pin() {
		System.out.print("PIN: ");
	}

	protected static void wrongPIN() {
		System.out.println("\n**Wrong PIN**\n");
	}
	
	protected static void value() {
		System.out.print("Value: ");
	}
	
	protected static void name() {
		System.out.print("Your Name: ");
	}
	
	protected static void surname() {
		System.out.print("Your Surname: ");
	}
	
	protected static void sourceAcc() {
		System.out.print("Source Account: ");
	}
	
	protected static void targetAcc() {
		System.out.print("Target Account: ");
	}
	
	protected static void createAccTitle() {
		System.out.println("\n---CREATE ACCOUNT---\n");
	}
	
	protected static void removeAccTitle() {
		System.out.println("\n---REMOVE ACCOUNT---\n");
	}
	
	protected static void addMoneyTitle() {
		System.out.println("\n---ADD MONEY---\n");
	}
	
	protected static void withdrawalTitle() {
		System.out.println("\n---WITHDRAWAL---\n");
	}
	
	protected static void moneyTransferTitle() {
		System.out.println("\n---MONEY TRANSFER---\n");
	}
	
	protected static void accountStatusTitle() {
		System.out.println("\n---ACCOUNT STATUS---\n");
	}
	
	protected static void attention() {
		System.out.println("\nWrite down your ACCOUNT NUMBER & PIN!\nWith your ACCOUNT NUMBER & PIN you ADD/WITHDRAW or TRANSFER money!");
	}
	
	protected static void noFounds() {
		System.out.println("\n**Not Enough Founds On Selected Account For Withrawal!**\n");
	}
	
	protected static void pickUpMsg() {
		System.out.println("\n**Don't Forget To PickUp Your Money Before Leaving! :)**\n");
	}
	
	protected static void minAccs() {
		System.out.println("\n**Minimal Number Of Accounts For Transfer Is 2 (Two)!**\n");
	}
	
	protected static void noToSource() {
		System.out.println("\n**You Can't Tranfer Money To Source Account**\n");
	}
	
	protected static void successfull() {
		System.out.println("\n**Transfer Successful!**\n");
	}
	
	protected static void noOptions() {
		System.out.println("\n**There Are No Available Options For Your Choice**\n");
	}
	
	protected static void stopped() {
		System.out.println("\n**The ATM Has Stopped**");
	}
	
}
