import java.util.ArrayList;

public class AdminPackageMain extends AdminPackage{

	public AdminPackageMain(int PackCode, String PackDesc, String PackStart, String PackEnd, int PackAmt) {
		super(PackCode, PackDesc, PackStart, PackEnd, PackAmt);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<AdminPackage> PackageList = new ArrayList<AdminPackage>();
		
		
		String output = "Package Management\n";
		output += "1. Add Package\n";
		output += "2. View Packages\n";
		output += "3. Delete Package by Package Code\n";
		output += "4. Quit";
		System.out.println(output);
		int choice = Helper.readInt("Enter choice > ");
		while (choice!=4) {
		
		if (choice==4) {
			System.out.println("Bye!");
			System.exit(0);
		}
		
		if (choice == 1){
			AdminPackageMain pkg = inputPackage();
			AdminPackageMain.addPackage(PackageList,pkg);
		}
		else if (choice == 2) {
			AdminPackageMain.viewAllPackages(PackageList);
		}
		else if (choice == 3) {
			AdminPackageMain.deletePackages(PackageList);
		}else {
			System.out.println("Invalid Number.");
		}
		}
		}
	
//Option 1 Add Package
	public static AdminPackageMain inputPackage() {	
		AdminPackageMain pkg =null;
		
		int code = Helper.readInt("Enter Package Code > ");
		String desc = Helper.readString("Enter Description > ");
		String SD = Helper.readString("Enter Start Date > ");
		String ED = Helper.readString("Enter End date > ");
		int amt = Helper.readInt("Enter Package Price > $");
		pkg = new AdminPackageMain(code, desc,SD,ED, amt);
		return pkg;
		
		
	}	
	public static void addPackage(ArrayList<AdminPackage> PackageList, AdminPackage pkg) {
		// write your code here
		PackageList.add(pkg);
		System.out.println("Package added!");
		
	}
	
	
	
	
	
	
	//Option 2 Viewing Packages	
		public static String retrieveAllPackages(ArrayList<AdminPackage> PackageList) {
			String output = "";

			for (int i = 0; i < PackageList.size(); i++) {

				output += String.format("%-10d %-30s %-10s %-10s %-20d\n", PackageList.get(i).getPackCode(), PackageList.get(i).getPackDesc(), PackageList.get(i).getPackStart(), PackageList.get(i).getPackEnd(),PackageList.get(i).getPackAmt());
			}
			return output;
		}

	

	private static void viewAllPackages(ArrayList<AdminPackage> PackageList) {
			String output = String.format(String.format("%-10s %-10s %-10s %-10s %-20s\n", "PACKAGE CODE", "PACKAGE DESCRIPTION",
					"PACKAGE START DATE", "PACKAGE END DATE","PACKAGE AMOUNT"));
			 output += retrieveAllPackages(PackageList);	
			System.out.println(output);
	}

	
	//Option 3 Delete Package
	private static void deletePackages(ArrayList<AdminPackage> PackageList) {
	int DeleteByCode = Helper.readInt("Enter Package by code to delete > ");
	char yn = Helper.readChar("Are you sure you want to delete? (Y/N) > ");
	if (yn == 'Y' || yn == 'y') {
		for (int i = 0 ; i< PackageList.size(); i++) {
			AdminPackage a = PackageList.get(i);
			if (i== DeleteByCode) {
				PackageList.remove(a);
				System.out.println("Package has been successfully deleted!");
				
				break;
			}
		}
	}
		
		else if(yn == 'n' || yn == 'N'){
				System.out.println("Deletion Cancelled!");
				System.out.println("Going back...");
				try {
					Thread.sleep(500);
				} catch(Exception e) { 
			System.out.println(e);
		}
	}else{
		Helper.line(70, "-");
		System.out.println("There are no Appointment made at the moment.");
	}
	}
}
	
	

	


