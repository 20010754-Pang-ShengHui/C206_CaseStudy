import java.util.ArrayList;

public class RequestQuoteMain {
	private static ArrayList<RequestQuote> reqQuoteList = new ArrayList<RequestQuote>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Cannot load program from here. Please use C206_CaseStudy.java!");
	}	
	public static void start(String un,String role) {
		menu();
		int choice = Helper.readInt("Enter choice > ");
		while (choice!=4) {
		
			if (choice==1) {
	
				String proptype = Helper.readString("Enter property type > ");
				int area = Helper.readInt("Enter area size > ");
				String Name = Helper.readString("Enter name > ");
				String NumEmail = Helper.readString("Enter contact number & email > ");
				double budget = Helper.readDouble("Enter budget > ");
				String enddate = Helper.readString("Enter target completion date > ");
				String renotype =Helper.readString("Enter renovation type > ");
				int rooms = Helper.readInt("Enter number of rooms to renovate > ");
				int toilets = Helper.readInt("Enter number of toilets to renovate > ");
				String renostyle = Helper.readString("Enter prefered renovation style > ");
				String req = Helper.readString("Enter (urgent) for urgent request > " );
				
				RequestQuote reqquote = new RequestQuote(proptype,area,Name,NumEmail,budget,enddate,renotype,rooms,toilets,renostyle,req);
				addRequestquote(reqquote);
				menu();
		        
			} else if (choice == 2) {
				viewRequestquote();
				menu();
				
			} else if (choice == 3) {
				deleteRequestquote();
				menu();
			
		    } else if (choice==4) {
			    System.out.println("Bye!");
			    menu();
		    }
			choice=Helper.readInt("Enter choice > ");
		} 
		
	}
	//add request for quote
	public static void addRequestquote(RequestQuote reqquote) {		
			
		reqQuoteList.add(reqquote);
		System.out.println("Request added");
	}
		
	
	//view request for quote
	public static void viewRequestquote() {
		System.out.println("VIEW ALL REQUESTS FOR QUOTATIONS");
		String output=String.format("%-15s %-10s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s", "Property type", 
				"Area Size", "Request Name", "Contact Number and Email", "Budget", "Target Completion Date", "Renovation Type", 
				"Number of rooms to renovate", "Number of toilets to renovate", "Renovation Style","Request urgency");
		
		if (reqQuoteList.isEmpty()) {
			
			Helper.line(70, "-");
			System.out.println("There are no requests for quotations currently."); 
			
		  
		} else {
		
		    for (int i = 0; i < reqQuoteList.size(); i++) {
			
		    	RequestQuote rq = reqQuoteList.get(i);
			    output+=(String.format("%-15s %-10d %-15s %-15s %-15.2f %-15s %-15s %-15s %-15s %-15s %-15s",rq.getproptype(),
			    	rq.getarea(), rq.getname(), rq.getNumEmail(), rq.getbudget(), 
					rq.getenddate(), rq.getrenotype(), rq.getrooms(), rq.gettoilets(), rq.getrenostyle(), rq.getreq()));
		    }
		}
		
	}
	
	//delete request for quote
	
	
	public static void deleteRequestquote() {
		if (!reqQuoteList.isEmpty()) {
			viewRequestquote();
			String delreqquote = Helper.readString("Enter request name to delete: ");
			char yn = Helper.readChar("Are you sure you want to delete? (Y/N) > ");
			    
			if (yn=='Y' || yn=='y') {
			    for (int i = 0; i < reqQuoteList.size(); i++) {
				
			    	RequestQuote rq = reqQuoteList.get(i);
			    	if (delreqquote == rq.getname()) {
				    	reqQuoteList.remove(rq);
					    System.out.println("Your request for quote is successfully deleted!");
				    }
			
		        }
			        
			} else if (yn=='N' || yn=='n') {
				System.out.println("Deletion canceled!");
			}
		} else {
			Helper.line(70, "-");
			System.out.println("There are no request for quote.");
			}
		}
	public static void menu() {
		Helper.line(50, "-");
		String output = "REQUEST FOR QUOTE Page\n";
		output += "1. Add REQUEST FOR QUOTE\n";
		output += "2. View REQUEST FOR QUOTE\n";
		output += "3. REQUEST FOR QUOTE\n";
		output += "4. Quit";
		System.out.println(output);
	}
	
	}
