import java.util.ArrayList;

public class AdminPackageMain extends AdminPackage{

	public AdminPackageMain(int PackCode, String PackDesc, String PackStart, String PackEnd, int PackAmt) {
		super(PackCode, PackDesc, PackStart, PackEnd, PackAmt);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<AdminPackage> PackageList = new ArrayList<AdminPackage>();
		PackageList.add(new AdminPackage (1,"d", "2019", "2020", 2932));
		
		String output = "Package Management\n";
		output += "1. Add Package\n";
		output += "2. View Packages\n";
		output += "3. Delete Package by Package Code\n";
		output += "4. Quit";
		System.out.println(output);
		int choice = Helper.readInt("Enter choice > ");
		while (choice!=4) {
		}
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
		}
	
//Option 1 Add Package
	public static AdminPackageMain inputPackage() {	
		AdminPackageMain pkg =null;
		
		int code = Helper.readInt("Enter Package Code > ");
		String desc = Helper.readString("Enter Description > ");
		String SD = Helper.readString("Enter Start Date > ");
		String ED = Helper.readString("Enter End date");
		int amt = Helper.readInt("Enter operating system");
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
			String output = String.format(String.format("%-10s %-30s %-10s %-10s %-20s\n", "PACKAGE CODE", "PACKAGE DESCRIPTION",
					"PACKAGE START DATE", "PACKAGE END DATE","PACKAGE AMOUNT "));
			 output += retrieveAllPackages(PackageList);	
			System.out.println(output);
	}
	
	//Option 3 Delete Package
	//d
	
}

