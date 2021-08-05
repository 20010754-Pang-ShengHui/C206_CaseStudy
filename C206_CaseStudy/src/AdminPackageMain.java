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
		output += "2. View ackages\n";
		output += "3. Delete Package by Package Code\n";
		output += "4. Quit";
		System.out.println(output);
		int choice = Helper.readInt("Enter choice > ");
		
		
		public static String retrieveAllPackages(ArrayList<AdminPackage> PackageList) {
			String output = "";

			for (int i = 0; i < PackageList.size(); i++) {

				output += String.format("%-10d %-30s %-10s %-10s %-20d\n", PackageList.get(i).getPackCode(), PackageList.get(i).getPackDesc(), Packagelist.get(i).getPackStart(), Packagelist.get(i).getPackEnd(),Packagelist.get(i).getPackAmt());
			}
			return;
		}
		public static void viewAllPackages(ArrayList<AdminPackage> PackageList) {
			ResourceCentre.setHeader("PACKAGES");
			String output = String.format("%-10d %-30s %-10s %-10s %-20d\n", PackageList.get(i).getPackCode(), PackageList.get(i).getPackDesc(), Packagelist.get(i).getPackStart(), Packagelist.get(i).getPackEnd(),Packagelist.get(i).getPackAmt());
			 output += retrieveAllPackages(PackageList);	
			System.out.println(output);
		}

	}
}

