
public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menuList();
		Helper.line(50, "-");
		int choice = Helper.readInt("Enter choice > ");
		
		while (choice!=3) {
			if (choice==1) {
				String username = Helper.readString("Username > ");
				String email = Helper.readString("Email Address > ");
				String Pw = Helper.readString("New Password > ");
				String cPw = Helper.readString("Confirm Password > ");
				register(username,email,Pw,cPw);
			} else if (choice==2) {
				member();
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
		String output = "Home Page\n";
		output += "1. Visitor Account Registration\n";
		output += "2. Login\n";
		output += "3. Quit";
		System.out.println(output);
	}

	private static boolean register(String username,String email, String Pw, String cpw) {
		boolean success = false;
		if (Pw.equals(cpw)) {
			
			System.out.println("Registeration Successful!");
			success = true;
		} else {
			System.out.println("Password does not match.\nRegistration Failed!");
			success = false;
		}
		return success;
	}
	
	private static void member() {
		
	}
}
