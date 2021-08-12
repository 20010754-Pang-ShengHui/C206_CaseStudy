import java.util.ArrayList;

public class QuotationMain {
	
	private static ArrayList<Quotation> quoteList = new ArrayList<Quotation>();

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		System.out.println("Cannot load program from here. Please use C206_CaseStudy.java!");
//	}
	
	public static void start(String un, String role) {
		
		int choice = -1;
		
		while (choice != 4) {
			
			QuotationMain.menu();
			choice = Helper.readInt("Enter choice > ");
			
			if (choice == 1) {
				
				int reqid = Helper.readInt("Enter Request ID: ");
		        int quotid = Helper.readInt("Enter Quotation ID: ");
		        String categ = Helper.readString("Enter Renovation Category: ");
		        String descrip = Helper.readString("Enter Description: ");
		        double price = Helper.readDouble("Enter Item Price: ");
		        String desname = Helper.readString("Enter Designer Name: ");
		        String startdate = Helper.readString("Enter Start Date(mm/dd/yyyy): ");
		        double totalamt = Helper.readDouble("Enter Total Amount: $");
		
		        Quotation q1 = new Quotation(reqid, quotid, categ, descrip, price, desname, startdate, totalamt);
		        addQuotation(quoteList, q1);
		        
		        
			} else if (choice == 2) {
				viewQuotations(quoteList);
				
			} else if (choice == 3) {
				deleteQuotation();
			
		    }
			
			
			
		} if (choice == 4) {
			System.out.println("Logging out...");
			System.out.println("Bye!");
			
		}
	}
	
	public static void menu() {
		Helper.line(70, "-");
		String output = "Quotation Page\n";
		output += "1. Add Quotation\n";
		output += "2. View Quotation\n";
		output += "3. Delete Quotation\n";
		output += "4. Log out & Quit";
		System.out.println(output);

	}
	
	
    public static void addQuotation(ArrayList<Quotation> quoteList, Quotation q1) {
		
	    quoteList.add(q1);
	    System.out.println("Quotation Added!");
		
	}
	
	public static void viewQuotations(ArrayList<Quotation> quoteList) {
	
		if (quoteList.isEmpty()) {
			
			Helper.line(70, "-");
			System.out.println("There are no Quotations currently."); 
			
		  
		} else {
			 System.out.println("VIEW ALL QUOTATIONS");
		     System.out.println(String.format("%-10s %-20s %-15s %-15s %-15s %-15s %-15s %-15s\n", "REQUEST ID", 
				"QUOTATION ID", "CATEGORY", "DESCRIPTION", "PRICE", "DESIGNER NAME", "START DATE", 
				"TOTAL AMOUNT"));
		
		    for (int i = 0; i < quoteList.size(); i++) {
			
			    Quotation q = quoteList.get(i);
			    System.out.println(String.format("%-10d %-20d %-15s %-15s %-15.2f %-15s %-15s %-15.2f\n", q.getReqid(), 
					q.getQuotid(), q.getCateg(), q.getDescrip(), q.getPrice(), q.getDesname(), 
					q.getStartdate(), q.getTotalamt()));
			    
		    }
		} 
		
	}
	
	public static void DelQuo(ArrayList<Quotation> quoteList, Quotation q) {
		for (int i = 0;i< quoteList.size(); i++) {
			if (quoteList.get(i) == q) {
				quoteList.remove(q);
			}
			
		}
	}
	
	public static void deleteQuotation() {
		
		
		if (!quoteList.isEmpty()) {
			viewQuotations(quoteList);
			
			int delquote = Helper.readInt("Enter Quotaion ID to delete: ");
		    char yn = Helper.readChar("Are you sure you want to delete? (Y/N): ");
		    
		    if (yn == 'Y' || yn == 'y') {
		        for (int i = 0; i < quoteList.size(); i++) {
			
			        Quotation q = quoteList.get(i);
			        if ( delquote == q.getQuotid()) {       
			        	
			        	DelQuo(quoteList, q);
				   
				        System.out.println("Your Quotation is successfully deleted!");
				        break;
				        
			        } 
		
	            } 
		        
		    } else if (yn == 'N' || yn == 'n') {
				System.out.println("Deletion canceled!");
				System.out.println("Going back...");
				try {
		            Thread.sleep(500);
		        } catch (Exception e) {
		            System.out.println(e);
		        }
		    }
		    
		} else {
			Helper.line(70, "-");
			System.out.println("There are no Quotations currently.");
		}
		
	}

}
