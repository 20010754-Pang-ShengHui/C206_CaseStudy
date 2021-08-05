import java.util.ArrayList;

public class C206_CaseStudy {

	private static ArrayList<Account> accList = new ArrayList<>();
	private static String loginUser;
	private static String loginPassword;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start();
	}

	private static void start() {
		accList.add(new Account("PSH","Admin","1234@123.123.com","12345678"));
		menuList();
		Helper.line(50, "-");
		int choice = Helper.readInt("Enter choice > ");
		
		while (choice!=3 && !memAuthen(loginUser,loginPassword)) {
			if (choice==1) {
				addUser();
			} else if (choice==2) {
				String username = Helper.readString("Username > ");
				String Pw = Helper.readString("Password > ");
				memAuthen(username,Pw);
				
				
				
			} else if (choice>3 || choice<1) {
				System.out.println("Invalid Choice!");
			}
		}
		if (choice==3) {
				System.out.println("Bye!");
		}
		
	}

	
	private static void menuList() {
		Helper.line(50, "-");
		String output = "Login/Signup Page\n";
		output += "1. Visitor Account Registration\n";
		output += "2. Login\n";
		output += "3. Quit";
		System.out.println(output);
	}


	private static boolean memAuthen(String username,String Pw) {
		boolean success = false;
		for (int i = 0;i<accList.size();i++) {
			Account a = accList.get(i);
			if (a.getName().equals(username) && a.getPassword().equals(Pw)) {
				loginUser=username;
				loginPassword=Pw;
				System.out.println("Authentication Success!");
				success = true;
				break;
			}
		}
		return success;
	}
	
	private static void memberhome(String username,String role) {
		if (role.equals("Member")) {
			Helper.line(50, "-");
			String output = "Login/Signup Page\n";
			output += "1. Visitor Account Registration\n";
			output += "2. Login\n";
			output += "3. Quit";
			System.out.println(output);
			
		} else if (role.equals("Admin")) {
			adminView();
			int choice = Helper.readInt("Enter choice > ");
			
			while (choice!=6) {
				if (choice==5) {
					AppointmentMain.start(username,role);
				}
			}
			
		} else if (role.equals("Designer")) {
			Helper.line(50, "-");
			String output = "Home Page\n";
			output += "1. Manage Customer\n";
			output += "2. Manage Package\n";
			output += "3. Manage Request for Quotation\n";
			output += "4. Manage Quotation\n";
			output += "5. Manage Appoitment\n";
			output += "6. Quit";
			System.out.println(output);
			
		}
	}
	
	private static void adminView() {
		Helper.line(50, "-");
		String output = "Home Page\n";
		output += "1. Manage Account\n";
		output += "2. Manage Package\n";
		output += "3. Manage Request for Quotation\n";
		output += "4. Manage Quotation\n";
		output += "5. Manage Appoitment\n";
		output += "6. Quit";
		System.out.println(output);
	}
	
	private static void addUser() {
		String name = Helper.readString("Enter name > ");
		String role = Helper.readString("Enter role >");
		String email = Helper.readString("Enter email >");
		String password = Helper.readString("Enter password >");
		
		
		Account acc  = new Account(name,role,email,password);
		accList.add(acc);
		
		
	}
	
	private void viewUser() {
		String output = "";
		output += String.format("%-20s %-10s\n", "ITEM", "PRICE");
	//	for (Item show : itemList) {
	//		output += String.format("%-20s %-10.2f\n", wordProper(show.getType()), show.getPrice());
	//	}
		System.out.println(output);
	
	}
	
	private void delUser() {
		String name = Helper.readString("Enter name to delete > ");
	//	for (Item i : itemList) {
	//		if (i.getPrice().equals lowest.getPrice()) {
	//			remove
//			}
//		}
		
	}
}
