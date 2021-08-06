import java.util.ArrayList;

public class requestquoteMain {
	private static ArrayList<requestquote> reqQuoteList = new ArrayList<requestquote>();

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
		}
		if (choice==4) {
			System.out.println("Bye!");
			System.exit(0);
		}
		
	}
	//add request for quote
	public static void addRequestquote() {
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
		requestquote reqquote = new requestquote(proptype,area,Name,NumEmail,budget,enddate,renotype,rooms,toilets,renostyle,req);
		
		reqQuoteList.add(reqquote);
		System.out.println("Request added");
		}
		
	
	//view request for quote
	public static void viewRequestquote() {
		
	}
	//delete request for quote
public static void deleteRequestquote() {
		
	if (!reqQuoteList.isEmpty()) {
			
		viewRequestquote();
		String delreqquote = Helper.readString("Enter request name to delete: ");
		char yn = Helper.readChar("Are you sure you want to delete? (Y/N) > ");
		    
		if (yn=='Y' || yn=='y') {
		    for (int i = 0; i < reqQuoteList.size(); i++) {
			
		    	requestquote rq = reqQuoteList.get(i);
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
