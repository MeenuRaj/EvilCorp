import java.util.ArrayList;


	public class CheckInfo {  

			ArrayList<Check> checklist;

			public CheckInfo() {
				checklist = new ArrayList<Check>();
			}

			public void addItem(Check check) {
				checklist.add(check);
			}

			public ArrayList<Check> getChecks() {
				return checklist;
			}

	}