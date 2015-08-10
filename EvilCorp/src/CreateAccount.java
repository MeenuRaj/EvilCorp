
public class CreateAccount {
	
	private int account;
	private String name;
	private double balance;
	
	public CreateAccount(){
		
		this.account = 0;
		this.name = "";
		this.balance = 0;
		
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
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	public double subtract(double amount){
		double total = balance - amount;
		return total;
	}
	
	public double add(double amount){
		double total = balance + amount;
		return total;
	}
	
	

}
