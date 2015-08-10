import java.util.ArrayList;


public class BankInfo {

		ArrayList<CreateAccount> list;

		public BankInfo() {
			list = new ArrayList<CreateAccount>();
		}

		public void addItem(CreateAccount createAccount) {
			list.add(createAccount);
		}

		public ArrayList<CreateAccount> getAccounts() {
			return list;
		}

}
