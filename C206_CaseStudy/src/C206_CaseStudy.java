import java.util.ArrayList;

public class C206_CaseStudy {

	private static ArrayList<Account> accList = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		menuList();
		Helper.line(50, "-");
		int choice = Helper.readInt("Enter choice > ");
		
		while (choice!=3) {
			if (choice==1) {
				String username = Helper.readString("Username > ");
				String role = Helper.readString("Role > ");
				String email = Helper.readString("Email Address > ");
				String Pw = Helper.readString("New Password > ");
				String cPw = Helper.readString("Confirm Password > ");
				String status = "New";
				register(username,role,email,Pw,cPw,status);
			} else if (choice==2) {
				String username = Helper.readString("Username > ");
				String Pw = Helper.readString("New Password > ");
				// Firdaus please implement...
				
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

	private static boolean register(String un,String role,String email, String Pw, String cpw,String status) {
		boolean success = false;
		if (Pw.equals(cpw)) {
			if (Pw.length()>=8) {
				accList.add(new Account(un,role,email,Pw,cpw));
				System.out.println("Registeration Successful!");
				success = true;
			} else if (Pw.length()<=8) {
				System.out.println("Password must be atleast 8 characters and longers!\nRegistration Failed!");
			}
		} else {
			System.out.println("Password does not match.\nRegistration Failed!");
		}
		return success;
	}
	
}
