
public class QuotationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Cannot load program from here. Please use C206_CaseStudy.java!");
	}
	
	public static void start(String un,String role) {
		Helper.line(50, "-");
		String output = "Quotation Page\n";
		output += "1. Add Quotation\n";
		output += "2. View Quotation\n";
		output += "3. Delete Quotation\n";
		output += "4. Quit";
		System.out.println(output);
		int choice = Helper.readInt("Enter choice > ");
		while (choice!=4) {
		}
		if (choice==4) {
			System.out.println("Bye!");
			System.exit(0);
		}
		
	}

}
