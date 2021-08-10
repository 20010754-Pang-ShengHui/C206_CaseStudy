import java.util.ArrayList;

public class RequestQuoteMain {
	private static ArrayList<RequestQuote> reqQuoteList = new ArrayList<RequestQuote>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void start(String un,String role) {
		Helper.line(50, "-");
		String output = "REQUEST FOR QUOTE Page\n";
		output += "1. Add REQUEST FOR QUOTE\n";
		output += "2. View REQUEST FOR QUOTE\n";
		output += "3. REQUEST FOR QUOTE\n";
		output += "4. Quit";
		System.out.println(output);
		int choice = Helper.readInt("Enter choice > ");
		while (choice!=4) {
		
			if (choice==1) {
	
				String proptype = Helper.readString("Enter property type > ");
				int area = Helper.readInt("Enter area size > ");
				String Name = Helper.readString("Enter name > ");
				String NumEmail = Helper.readString("Enter contact number & email > ");
				int budget = Helper.readInt("Enter budget > ");
				String enddate = Helper.readString("Enter target completion date > ");
				String renotype =Helper.readString("Enter renovation type > ");
				int rooms = Helper.readInt("Enter number of rooms to renovate > ");
				int toilets = Helper.readInt("Enter number of toilets to renovate > ");
				String renostyle = Helper.readString("Enter prefered renovation style > ");
				String req = Helper.readString("Enter (urgent) for urgent request > " );
				
				requestquote reqquote = new RequestQuote(proptype,area,Name,NumEmail,budget,enddate,renotype,rooms,toilets,renostyle,req);
				addRequestQuote(reqQuoteList, reqquote);
		        break;
		        
			} else if (choice == 2) {
				viewRequestQuote(reqQuoteList);
				
			} else if (choice == 3) {
				deleteRequestQuote();
			
			
			
		    } else if (choice==4) {
			    System.out.println("Bye!");
			    System.exit(0);
		    }
		} 
	}	
	//add request for quote
	public static void addRequestquote(ArrayList<RequestQuote> reqQuoteList, RequestQuote reqquote) {		
			
		reqQuoteList.add(reqquote);
		System.out.println("Request added");
	}
		
	
	//view request for quote
	public static void viewRequestquote(ArrayList<RequestQuote> reqQuoteList) {
		
		
		if (reqQuoteList.isEmpty()) {
			
			Helper.line(70, "-");
			System.out.println("There are no requests for quotations currently."); 
			
		  
		} else {
			 System.out.println("VIEW ALL REQUESTS FOR QUOTATIONS");
		     System.out.println(String.format("%-15s %-10d %-15s %-15s %-15.2f %-15s %-15s %-15s %-15s %-15s %-15s", "Property type", 
				"Area Size", "Request Name", "Contact Number and Email", "Budget", "Target Completion Date", "Renovation Type", 
				"Number of rooms to renovate", "Number of toilets to renovate", "Renovation Style","Request urgency"));
		
		    for (int i = 0; i < reqQuoteList.size(); i++) {
			
		    	RequestQuote rq = reqQuoteList.get(i);
			    System.out.println(String.format("%-15s %-10d %-15s %-15s %-15.2f %-15s %-15s %-15s %-15s %-15s %-15s",rq.getproptype(),
			    	rq.getarea(), rq.getname(), rq.getNumEmail(), rq.getbudget(), 
					rq.getenddate(), rq.getrenotype(), rq.getrooms(), rq.gettoilets(), rq.getrenostyle(), rq.getreq()));
			    break;
			
		    }
		}
		
	}
	
	//delete request for quote
	public static void deleteRQ(ArrayList<RequestQuote> reqQuoteList, RequestQuote reqquote) {
		for (int i = 0;i< reqQuoteList.size(); i++) {
			if (reqQuoteList.get(i) == rq) {
				reqQuoteList.remove(rq);
			}
			
		}
	}	
	
	public static void deleteRequestquote() {
		if (!reqQuoteList.isEmpty()) {
			viewRequestQuote(reqQuoteList);
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
	
	}
