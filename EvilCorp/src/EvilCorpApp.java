import java.util.ArrayList;
import java.util.Scanner;


public class EvilCorpApp {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Evil Corp Savings and Loan");
		System.out.println("Please create the user account(s)");
		Scanner scan = new Scanner(System.in);
		int accountNum = 0;
		double finalAmount = 0;
		BankInfo bankInfo = new BankInfo();
		System.out.println("Enter an account # or -1 to stop entering accounts:  ");
		int resp = scan.nextInt();
		while(resp != -1)
		{

			if (resp != -1)
				accountNum = resp;
			else break;
			CreateAccount createAccount = new CreateAccount();
			createAccount.setAccount(accountNum);
			System.out.println("Enter the name for account # " +accountNum + ":  ");
			String name = scan.next();
			createAccount.setName(name);
			System.out.println("Enter the Balance for account # " +accountNum + ":  ");
			Double balance = scan.nextDouble();
			createAccount.setBalance(balance);
			System.out.println("Enter an account # or -1 to stop entering accounts:  ");
			resp = scan.nextInt();
			bankInfo.addItem(createAccount);
			
		}
		
		
		
		
		System.out.println("Enter a transaction type:\n C - Check\n DC - Debit Card\n D - Deposit\n W - Withdrawal\n or -1 to finish");
		String type = scan.next();
		while(!type.equals("-1"))	
			{
				
				System.out.println("Enter the account #:  ");
				accountNum = scan.nextInt();
				
				ArrayList<CreateAccount> alist = bankInfo.getAccounts();
				for(CreateAccount curr_account : alist)
				{
					if(curr_account.getAccount() == accountNum)
					{
						System.out.println("Enter the transaction amount:  ");
						double amount = scan.nextDouble();
						if(type.equalsIgnoreCase("D"))
						{
							finalAmount = curr_account.add(amount);
							curr_account.setBalance(finalAmount);
						}
						/*else if(type.equalsIgnoreCase("C"))
						{
							System.out.println("Enter the date of the check:  ");
							String date = scan.next();
							.setDate(date);
						}*/
						else
						{		
						finalAmount = curr_account.subtract(amount);
						curr_account.setBalance(finalAmount);
						}
					}
				}
				
				System.out.println("Enter a transaction type:\n C - Check\n DC - Debit Card\n D - Deposit\n W - Withdrawal\n or -1 to finish");
				type = scan.next();
			
		}
		
		ArrayList<CreateAccount> finalList = bankInfo.getAccounts();
		for(CreateAccount cacc : finalList)
		{
			System.out.println("The balance is: " +cacc.getBalance());
		}
		
	}
}



