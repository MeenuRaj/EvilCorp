import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class CreateAccount {
	
	private int account;
	private String name;
	private double balance;
	private CheckInfo checks;
	
	

	public CreateAccount(){
		
		this.account = 0;
		this.name = "";
		this.balance = 0;
		checks = new CheckInfo();
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		
		
		ArrayList<Check> classcheck = checks.getChecks();
		Collections.sort(classcheck,new TimeComp());
		for(Check thisCheck : classcheck)
		{
			double total = balance - thisCheck.getAmount();
			balance = total;
			if (balance < 0)
				balance = balance -35;
		}
		
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	public double subtract(double amount){
		double total = balance - amount;
		balance = total;
		return balance;
	}
	
	public double add(double amount){
		double total = balance + amount;
		balance = total;
		return balance;
	}
	
	public void addChecks(Check a_check) {
		checks.addItem(a_check);
	}
	
	
	
	class TimeComp implements Comparator<Check>{
		 
	    @Override
	    public int compare(Check c1, Check c2) {
	        if(c1.calculate() < c2.calculate()){
	            return 1;
	        } else {
	            return -1;
	        }
	    }
	}




}
