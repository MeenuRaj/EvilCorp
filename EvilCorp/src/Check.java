import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Check{
	
	private int month;
	private int day;
	private int year;
	private double amount;
	
	

	public Check(){
	
	this.month = 0;
	this.day = 0;
	this.year = 0;
	}

	public int getMonth() { 
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	public long calculate()
	{
		Calendar calendar = new GregorianCalendar(year, month, day);
		Calendar now = new GregorianCalendar();
		Date startDate = calendar.getTime();
		Date endDate = now.getTime();
		long startDateMS = startDate.getTime();
		long endDateMS = endDate.getTime();
		long elapsedMS = endDateMS - startDateMS;
		long elapsedDays = elapsedMS / (24*60*60*1000);
		return elapsedDays;
	} 
	
	
}