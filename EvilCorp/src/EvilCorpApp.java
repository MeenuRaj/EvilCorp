import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class EvilCorpApp {

	public static void main(String[] args) throws ParseException {
		
		System.out.println("Welcome to Evil Corp Savings and Loan");
		System.out.println("Please create the user account(s)");
		Scanner scan = new Scanner(System.in);
		int accountNum = 0;
		double finalAmount = 0;
		BankInfo bankInfo = new BankInfo();
		//CheckInfo checkInfo = new CheckInfo();
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
						
						if(type.equalsIgnoreCase("C"))
						{
							Check newCheck = new Check();
							System.out.println("Enter the month");
							int month = scan.nextInt();
							newCheck.setMonth(month);
							
							System.out.println("Enter the day");
							int day = scan.nextInt();
							newCheck.setDay(day);
							
							System.out.println("Enter the year");
							int year = scan.nextInt();
							newCheck.setYear(year);
							
							System.out.println("Enter the amount");
							double theAmount = scan.nextDouble();
							newCheck.setAmount(theAmount);
							
							//checkInfo.addItem(newCheck);
							curr_account.addChecks(newCheck);	
							
						}
						
						else if (type.equalsIgnoreCase("D"))
						{
							System.out.println("Enter the transaction amount:  ");
							double amount = scan.nextDouble();
							finalAmount = curr_account.add(amount);
							curr_account.setBalance(finalAmount);
						}
						else 
						{	
							System.out.println("Enter the transaction amount:  ");
							double amount = scan.nextDouble();
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
			System.out.println("The balance for " +cacc.getAccount()+" : " +cacc.getBalance());
		}
		
				
		
	}
}

