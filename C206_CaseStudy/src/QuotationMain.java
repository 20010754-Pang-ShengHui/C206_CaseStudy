import java.util.ArrayList;

public class QuotationMain {
	
	private static ArrayList<Quotation> quoteList = new ArrayList<Quotation>();

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
	
    public void addQuotation(ArrayList<Quotation> quoteList) {
		
		int reqid = Helper.readInt("Enter Request ID: ");
		int quotid = Helper.readInt("Enter Quotation ID:");
		String categ = Helper.readString("Enter Renovation Category: ");
		String descrip = Helper.readString("Enter Description: ");
		double price = Helper.readDouble("Enter Item Price: ");
		String desname = Helper.readString("Enter Designer Name: ");
		String startdate = Helper.readString("Enter Start Date(mm/dd/yyyy): ");
		double totalamt = Helper.readDouble("Enter Total Amount: $");
		
		Quotation quote = new Quotation(reqid, quotid, categ, descrip, price, desname, startdate, totalamt);
		quoteList.add(quote);
		
	}
	
	public void viewQuotations(ArrayList<Quotation> quoteList) {
		
		System.out.println("VIEW ALL QUOTATIONS");
		System.out.println(String.format("%-10s %-30s %-10s %-10s %-20s %-10s %-10s %-20s\n", "REQUEST ID", 
				"QUOTATION ID", "CATEGORY", "DESCRIPTION", "PRICE", "DESIGNER NAME", "START DATE", 
				"TOTAL AMOUNT"));
		
		for (int i = 0; i < quoteList.size(); i++) {
			
			Quotation q = quoteList.get(i);
			System.out.println(String.format("%-10d %-10d %-13s %-15s %-.2f %-15s %-15s %-.2f\n", q.getReqid(), 
					q.getQuotid(), q.getCateg(), q.getDescrip(), q.getPrice(), q.getDesname(), 
					q.getStartdate(), q.getTotalamt()));
		}
		
	}
	
	public void deleteQuotation(ArrayList<Quotation> quoteList) {
		
		int delquote = Helper.readInt("Enter a Quotation ID to delete: ");
		
		for (int i = 0; i < quoteList.size(); i++) {
			
			Quotation q = quoteList.get(i);
			if (delquote == q.getQuotid()) {
				
			}
		
	    }
		
	}

}
