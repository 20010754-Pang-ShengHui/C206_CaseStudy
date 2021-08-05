import java.util.ArrayList;

public class C206_CaseStudy {

	private static ArrayList<Account> accList = new ArrayList<>();
	private static String loginUser;
	private static String loginPassword;
	private static String rl;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start();
	}

	private static void start() {

		accList.add(new Account("PSH", "Admin", "1234@123com", "12345678", 87654321));
		
		int choice = -1;
		while (choice != 3 && !memAuthen(loginUser, loginPassword)) {
			menuList();
			Helper.line(50, "-");
			choice = Helper.readInt("Enter choice > ");
			if (choice == 1) {
				addUser(accList, null);
			} else if (choice == 2) {
				String username = Helper.readString("Username > ");
				String Pw = Helper.readString("Password > ");
				if (memAuthen(username, Pw)) {
					memberhome(username, rl);
				}

			} else if (choice > 3 || choice < 1) {
				System.out.println("Invalid Choice!");
			}
		}
		if (choice == 3) {
			System.out.println("Bye!");
			System.out.println("Test");
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

	private static boolean memAuthen(String username, String Pw) {
		boolean success = false;
		for (int i = 0; i < accList.size(); i++) {
			Account a = accList.get(i);
			if (a.getName().equals(username) && a.getPassword().equals(Pw)) {
				loginUser = username;
				loginPassword = Pw;
				rl = a.getRole();
				System.out.println("Authentication Success!");
				success = true;
				break;
			}
			else {
				System.out.println("Wrong Password or Username");
			}
		}
		return success;
	}

	private static void memberhome(String username, String role) {
		if (role.equals("Member")) {
			Helper.line(50, "-");
			String output = "Login/Signup Page\n";
			output += "1. Visitor Account Registration\n";
			output += "2. Login\n";
			output += "3. Quit";
			System.out.println(output);
			int choice = -1;
			while (choice!=6) {
			adminView();
			choice = Helper.readInt("Enter choice > ");
				if (choice==4) {
					QuotationMain.start(username, rl);
					break;
				}
				else if (choice==5) {
					AppointmentMain.start(username,rl);
					break;
				}
			}
			

			menuList();

		} else if (role.trim().equals("Admin".trim())) {
			int choice = -1;
			while (choice != 6) {
				adminView();
				choice = Helper.readInt("Enter choice > ");
				if(choice == 1) {
					subOption1();
					choice = Helper.readInt("Enter choice > ");
					if(choice == 1) {
						Account acc = inputUser();
						C206_CaseStudy.addUser(accList, acc);
					}else if(choice == 2) {
					//	viewUser();
					}else if(choice == 3) {
					//	delUser();
					}
				}else if(choice == 2) {
					
				}else if(choice == 3) {
					
				}else if (choice == 4) {
					QuotationMain.start(username, rl);
					break;
				} else if (choice == 5) {
					AppointmentMain.start(username, rl);
					break;
				}else {
					System.out.println("invalid");
				}
				
			}

		} else if (role.trim().equals("Designer".trim())) {
			int choice = -1;
			while (choice != 2) {
				designerView();
				choice = Helper.readInt("Enter choice > ");
				if (choice == 1) {
					QuotationMain.start(username, rl);
					break;
				}
			}

		}
	}

	private static void designerView() {
		Helper.line(50, "-");
		String output = "Home Page\n";
		output += "1. Manage Quotation\n";
		output += "2. Quit";
		System.out.println(output);
	}

	private static void adminView() {
		Helper.line(50, "-");
		String output = "Home Page\n";
		output += "1. Manage Account\n";
		output += "2. Manage Package\n";
		output += "3. Manage Request for Quotation\n";
		output += "4. Manage Quotation\n";
		output += "5. Manage Appointment\n";
		output += "6. Quit";
		System.out.println(output);
	}
	private static void subOption1() {
		Helper.line(50, "-");
		String output = "";
		output += "1. Add User Account\n";
		output += "2. View User Account\n";
		output += "3. Delete User Account \n";
		output += "4. Quit";
		System.out.println(output);
	}
	
	public static Account inputUser() {
		
		String name = Helper.readString("Enter name > ");
		String role = Helper.readString("Enter role >");
		int contact = Helper.readInt("Enter contact number >");
		String email = Helper.readString("Enter email >");
		String password = Helper.readString("Enter password >");
		if (name.isEmpty() || role.isEmpty() || email.isEmpty() || password.isEmpty()) {
			System.out.println("Please fill in all the neccessary field");
		} 

		Account acc = new Account(name, role, email, password, contact);

		return acc;
		
	}
	public static void addUser(ArrayList<Account> accListTest, Account acc1) {
		accList.add(acc1);


	}

	public static String viewUser(ArrayList<Account> accListTest) {
		String output = "";
		if (accList.isEmpty()) {
			output = "No users found";

		} else {
			output += String.format("%-20s %-10s %-20s %-10s\n", "NAME", "ROLE", "EMAIL", "CONTACT");
			for (Account show : accList) {
				output += String.format("%-20s %-10s %-20s %-10s\n", show.getName(), show.getRole(), show.getEmail(),
						show.getContact());
			}
		}
		return output;

	}

	public static String delUser(ArrayList<Account> accListTest, Account acc2) {
		String name = Helper.readString("Enter name to delete > ");
		String nameConfirm  = ""; 
		for (Account i : accList) {
			if (i.getName().equalsIgnoreCase(name)) {
				accList.remove(i);
				System.out.println(name + " has been successfully deleted");
				break;
			}
		}
		return nameConfirm;
	}
}
