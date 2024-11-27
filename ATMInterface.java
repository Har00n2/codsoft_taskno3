import java.util.Scanner;
public class ATMInterface {

	public static void main(String[] args) {
		BankAccount newAcc = new BankAccount(20000);
		ATM atm1 = new ATM(newAcc);
		atm1.showInterface();
	}

}


class BankAccount{
	private double balance;
	BankAccount(double balance){
		this.balance = balance;
	}
	
	public String deposit(double depositAmount) {
		if(depositAmount<=0) {
			System.out.println("Amount should be positive");
		}
		else {
			balance = balance + depositAmount;
			System.out.println("The amount "+depositAmount+" has been succesfully added to your account!");
		}
		return "Your Current Balance is: " + Double.toString(balance);
	}
	
	public String withdraw(double withdrawAmount) {
		if(withdrawAmount>balance) {
			System.out.println("Insufficient Balance");
		}
		else if(withdrawAmount<=0) {
			System.out.println("Amount should be positive");
		}
		else {
			balance = balance - withdrawAmount;
			System.out.println("The amount "+withdrawAmount+" has been withdrawn from your account!");
		}
		return "Your Current Balance is: " + Double.toString(balance);
	}
	
	public String checkBalance() {
		return "Your Current Balance is: " + Double.toString(balance);
	}	
}


class ATM{
	Scanner sc = new Scanner(System.in);

	private BankAccount bankAccount;
	
	ATM(BankAccount bankAccount){
		this.bankAccount = bankAccount;
	}
	
	public void showInterface() {
		
		while(true) {
			System.out.println();
			System.out.println("-----------------ATM INTERFACE-------------------------");
			   System.out.println("1. Check Balance");
	           System.out.println("2. Deposit");
	           System.out.println("3. Withdraw");
	           System.out.println("4. Exit");
	           System.out.print("Choose an option: ");
	           int option = sc.nextInt();
	           
	           switch(option) {
	           
	           case 1 :
	        	   System.out.println(bankAccount.checkBalance());
	        	   break;
	        	   
	           case 2 :
	        	   System.out.println("Enter the Amount you want to deposit: ");
	        	   double depositAmount = sc.nextDouble();
	        	   System.out.println(bankAccount.deposit(depositAmount));
	        	   break;
	        	   
	           case 3 :
	        	   System.out.println("Enter the Amount you want to withdraw: ");
	        	   double withdrawAmount = sc.nextDouble();
	        	   System.out.println(bankAccount.withdraw(withdrawAmount));
	        	   break;
	        	   
	           case 4 :
	        	   System.out.println("Thank You! See You Again");
	        	   return;
	           default:
	        	   System.out.println("Invalid option!!!");
	        	   break;
	        		   
	           }
		}
}
	
}
