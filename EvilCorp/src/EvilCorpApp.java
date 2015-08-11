import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class EvilCorpApp {

	public static void main(String[] args) throws ParseException {

		String filename = (System.getProperty("user.dir") + File.separatorChar + "BankAccounts.txt");
		BankInfo bankInfo = new BankInfo();
		BufferedReader reader = null;
		try {
			System.out.println("read from a file");
			reader = new BufferedReader(new FileReader(filename));

			String line = reader.readLine();
			while (line != null) {
				CreateAccount oldAccs = new CreateAccount();
				oldAccs.setName(line);
				// System.out.println(line);
				line = reader.readLine();
				oldAccs.setAccount(Integer.parseInt(line));
				line = reader.readLine();
				oldAccs.setBalance(Double.parseDouble(line));
				line = reader.readLine();
				bankInfo.addItem(oldAccs);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("File does not exist");
		} finally {

		}

		ArrayList<CreateAccount> delete = new ArrayList<CreateAccount>();
		System.out.println("Welcome to Evil Corp Savings and Loan");
		Scanner scan = new Scanner(System.in);
		int accountNum = 0;
		double finalAmount = 0;
		int resp = Validator.getInt(scan,
				"Enter an account # or -1 to stop entering accounts:  " );
		System.out.println();
		while (resp != -1) {

			if (resp != -1)
				accountNum = resp;
			else
				break;
			CreateAccount createAccount = new CreateAccount();
			createAccount.setAccount(accountNum);
			String name = Validator.getString(scan,
					"Enter the name for account # " + accountNum
					+ ":  ");
			createAccount.setName(name);
			
			Double balance = Validator.getDouble(scan,
					"Enter the Balance for account # " + accountNum
					+ ":  ");
			createAccount.setBalance(balance);
			System.out
					.println("Enter an account # or -1 to stop entering accounts:  ");
			resp = scan.nextInt();
			bankInfo.addItem(createAccount);

		}

		ArrayList<CreateAccount> initialList = bankInfo.getAccounts();

		for (CreateAccount oldAccs : initialList) {
		//	System.out.println("The balance for account number " + oldAccs.getAccount() + " "
				//	+ oldAccs.getName() + " " + oldAccs.getBalance());
			
			System.out.println(oldAccs.getName()+"'s balance for account number " + oldAccs.getAccount() + " is " + oldAccs.getBalance());
		}
		System.out.println();
		System.out
				.println("Enter a transaction type:\n C - Check\n DC - Debit Card\n D - Deposit\n W - Withdrawal\n or -1 to finish");
		String type = scan.next();
		while (!type.equals("-1")) {

			System.out.println("Enter the account #:  ");
			accountNum = scan.nextInt();
			scan.nextLine();

			ArrayList<CreateAccount> alist = bankInfo.getAccounts();
			for (CreateAccount curr_account : alist) {
				if (curr_account.getAccount() == accountNum) {

					if (type.equalsIgnoreCase("C")) {
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

						// checkInfo.addItem(newCheck);
						curr_account.addChecks(newCheck);

					}

					else if (type.equalsIgnoreCase("D")) {
						System.out.println("Enter the transaction amount:  ");
						double amount = scan.nextDouble();
						finalAmount = curr_account.add(amount);
						curr_account.setBalance(finalAmount);
					} else {
						System.out.println("Enter the transaction amount:  ");
						double amount = scan.nextDouble();
						finalAmount = curr_account.subtract(amount);
						curr_account.setBalance(finalAmount);
					}

					if (curr_account.getBalance() == 0) {
						System.out
								.println("You're balance is $0.00, would you like to close your account?");
						String response = scan.next();
						if (response.equalsIgnoreCase("y")) {
							alist.remove(curr_account);
							break;
						}

					}
				}
			}

			ArrayList<CreateAccount> middleList = bankInfo.getAccounts();
			for (CreateAccount oldAccs : middleList) {
				System.out.println("The balance for " + oldAccs.getAccount()
						+ " " + oldAccs.getName() + " " + oldAccs.getBalance());
			}

			System.out
					.println("Enter a transaction type:\n C - Check\n DC - Debit Card\n D - Deposit\n W - Withdrawal\n or -1 to finish");
			type = scan.next();

		}

		// This writes everything to a file
		ArrayList<CreateAccount> finalList = bankInfo.getAccounts();
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new File(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (CreateAccount cacc : finalList) {
			// System.out.println("The balance for " +cacc.getAccount()+" "+
			// cacc.getName()+ " " +cacc.getBalance());
			writer.println(cacc.getName());
			writer.println(cacc.getAccount());
			writer.println(cacc.getBalance());
		}
		writer.close();

	}
}
