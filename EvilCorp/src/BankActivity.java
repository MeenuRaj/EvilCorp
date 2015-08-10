import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class BankActivity {

	private CreateAccount account;
	private double amount;
	private String date;
	
	public BankActivity(){
		this.account = new CreateAccount();
		this.amount = 0;
		this.date = "";
	}

	public CreateAccount getAccount() {
		return account;
	}

	public void setAccount(CreateAccount account) {
		this.account = account;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void readDate() throws ParseException {
		DateFormat dateF = new SimpleDateFormat();
		Date date = new Date();
		date = dateF.parse(getDate());
	}
	
	public double subtract(double amount){
		double total = initial - amount;
		initial = total;
		return initial;
	}
	
	public double add(){
		double initial = account.getBalance();
		double total = initial + amount;
		initial = total;
		return initial;
	}
	
	
}
