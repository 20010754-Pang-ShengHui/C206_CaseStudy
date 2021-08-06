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

		int choice = -1;
		while (choice != 3) {
			menuList();
			Helper.line(50, "-");
			choice = Helper.readInt("Enter choice > ");
			if (choice == 1) {
				Account acc = inputUserAcc();
				if (acc!=null) {
					C206_CaseStudy.addUser(accList, acc);
				}
				else {
					System.out.println("Invalid Role Entered!");
				}
			} else if (choice == 2) {
				String username = Helper.readString("Username > ");
				String Pw = Helper.readString("Password > ");
				if (memAuthen(username, Pw)) {
					memberhome(username, rl);
				} else {
				System.out.println("Invalid Username & Password!");
			}

			} else if (choice > 3 || choice < 1) {
				System.out.println("Invalid Choice!");
			}
		}
		if (choice == 3) {
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

	private static boolean memAuthen(String username, String Pw) {
		boolean success = false;
		for (int i = 0; i < accList.size(); i++) {
			Account a = accList.get(i);
			if (a.getName().equals(username) && a.getPassword().equals(Pw) &&
					a.getRole().equals("Member") || a.getRole().equals("Admin") || a.getRole().equals("Designer")) {
				loginUser = username;
				loginPassword = Pw;
				rl = a.getRole();
				System.out.println("Authentication Success!");
				success = true;
				break;
			}
			else {
				success = false;
			}
		}
		return success;
	}

	private static void memberhome(String username, String role) {
		if (role.trim().equals("Member".trim())) {
			int choice = -1;
			while (choice != 3) {
				Helper.line(50, "-");
				String output = "Home Page\n";
				output += "1. Request for Quotation\n";
				output += "2. Manage Appointment\n";
				output += "3. Logout & Quit";
				System.out.println(output);
				choice = Helper.readInt("Enter choice > ");
				if (choice == 2) {

				} else if (choice == 3) {
					System.out.println("Logging out...");
					try {
						Thread.sleep(1000);
			         } catch (Exception e) {
			            System.out.println(e);
			         }
					System.out.println("Bye!");
					System.exit(1);
				}
			}
			
			menuList();

		} else if (role.trim().equals("Admin".trim())) {
			//		Helper.line(50, "-");
			//		String output = "Home Page\n";
			//		output += "1. Manage Account\n";
			//		output += "2. Manage Package\n";
			//		output += "3. Manage Request for Quotation\n";
			//		output += "4. Manage Quotation\n";
			//		output += "5. Manage Appointment\n";
			//		output += "6. Quit";
			//		System.out.println(output);
			int choice = -1;
			while (choice != 6) {
				adminView();
				choice = Helper.readInt("Enter choice > ");
				if (choice == 1) {
					subOption1();
					choice = Helper.readInt("Enter choice > ");
					if (choice == 1) {
						Account acc = inputUserAcc();
						if (acc!=null) {
							C206_CaseStudy.addUser(accList, acc);
						}
						else {
							System.out.println("Invalid Role Entered!");
						}
					} else if (choice == 2) {
						String table = viewUser(accList);
						System.out.print(table);
					} else if (choice == 3) {
						String name = inputUserDel();
						String msg = delUser(accList, name);
						System.out.println(msg);
					}
				} else if (choice == 2) {
					AdminPackageMain.start(username, rl);

				} else if (choice == 3) {
					//Ethan add request quotation main here
				} else if (choice == 4) {
					QuotationMain.start(username, rl);
					break;
				} else if (choice == 5) {
					AppointmentMain.start(username, rl);
					break;
				} else if (choice > 6 || choice <0){
					System.out.println("invalid");
				}

			}
			System.out.println("Logging out...");
			try {
				Thread.sleep(1000);
	         } catch (Exception e) {
	            System.out.println(e);
	         }
			System.out.println("Bye!");
			System.exit(1);

		} else if (role.trim().equals("Designer".trim())) {
//		output += "1. Manage Quotation\n";
//		output += "2. Quit";
			int choice = -1;
			while (choice != 2) {
				designerView();
				choice = Helper.readInt("Enter choice > ");
				if (choice == 1) {
					QuotationMain.start(username, rl);
					break;
				}
			}
			if (choice==2) {
				System.out.println("Logging out...");
				try {
					Thread.sleep(1000);
		         } catch (Exception e) {
		            System.out.println(e);
		         }
				System.out.println("Bye!");
				System.exit(1);
			}

		}
	}

	private static void designerView() {
		Helper.line(50, "-");
		String output = "Home Page\n";
		output += "1. Manage Quotation\n";
		output += "2. Logout & Quit";
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
		output += "6. Logout & Quit";
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

	public static Account inputUserAcc() {
		Account acc = null;
		String name = Helper.readString("Enter name > ");
		String role = Helper.readString("Enter role (Admin/Member/Designer) > ");
		int contact = Helper.readInt("Enter contact number > ");
		String email = Helper.readString("Enter email > ");
		String password = Helper.readString("Enter password > ");

		while (name.isEmpty() || role.isEmpty() || email.isEmpty() || password.isEmpty()) {
			System.out.println("Please fill in all the neccessary field");
			name = Helper.readString("Enter name > ");
			role = Helper.readString("Enter role (Admin/Member/Designer) > ");
			role = rl;
			contact = Helper.readInt("Enter contact number > ");
			email = Helper.readString("Enter email >");
			password = Helper.readString("Enter password >");
		}
			if (role.equals("Admin") || role.equals("Member") || role.equals("Designer")) {
				acc = new Account(name, role, email, password, contact);
				
			}
			else {
				acc = null;
			}
		return acc;
	}

	public static void addUser(ArrayList<Account> accListTest, Account acc1) {
		accListTest.add(acc1);
		System.out.println("Account successfully created");

	}

	public static String viewUser(ArrayList<Account> accListTest) {
		String output = "";
		if (accListTest.isEmpty()) {
			output = "No users found\n";

		} else {
			System.out.print(String.format("%-20s %-10s %-20s %-10s\n", "NAME", "ROLE", "EMAIL", "CONTACT"));
			for (Account show : accListTest) {
				output += String.format("%-20s %-10s %-20s %-10s\n", show.getName(), show.getRole(), show.getEmail(),
						show.getContact());
			}
		}
		return output;

	}

	public static String inputUserDel() {
		String name = Helper.readString("Enter name to delete > ");
		return name;
	}

	public static String delUser(ArrayList<Account> accListTest, String name) {
		String output = "";
		for (Account i : accListTest) {
			if (i.getName().equalsIgnoreCase(name)) {
				accListTest.remove(i);
				output = name + " has been successfully deleted";
				break;
			} else {
				output = "No user with that name is found";
			}
		}
		return output;
	}
}
