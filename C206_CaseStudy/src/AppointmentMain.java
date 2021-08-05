import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AppointmentMain {


	private static ArrayList<Appointment> apptList = new ArrayList<Appointment>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Cannot load program from here. Please use C206_CaseStudy.java!");
		start("PSH","Admin");
	}
	
	public static void start(String un,String role) {
		int choice = -1;
		
		LocalDate testDate = LocalDate.parse("05/08/2021",DateTimeFormatter.ofPattern("d/MM/yyyy"));
		LocalTime testTime = LocalTime.parse("23:59", DateTimeFormatter.ofPattern("H:mm"));
		apptList.add(new Appointment("ShengHui",testDate,testTime,"LooSee","Singapore"));
		while (choice!=5) {
			Helper.line(70, "-");
			String output = "Appointment Page\n";
			output += "1. Add Appoitment\n";
			output += "2. View Appoitment\n";
			output += "3. Change Appointment\n";
			output += "4. Delete Appointment\n";
			output += "5. Quit";
			System.out.println(output);
			choice = Helper.readInt("Enter choice > ");
			if (choice==1) {
				String usN = Helper.readString("Enter Username > ");
				String date = Helper.readString("Enter date (DD/MM/YYYY) > ");
				String time = Helper.readString("Enter time in 24Hrs (HH:MM) > ");
				String dName = Helper.readString("Enter Designer Name > ");
				String addr = Helper.readString("Enter Address > ");
				LocalDate lcDate = LocalDate.parse(date,DateTimeFormatter.ofPattern("d/MM/yyyy"));
				LocalTime lcTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("H:mm"));
				apptList.add(new Appointment(usN, lcDate,lcTime, dName, addr));
				System.out.println("Appointment Added!");
			}
			else if (choice==2) {
				viewApt();
			} else if (choice==3) {
				viewApt();
				int choiceApt = Helper.readInt("Appointment no. > ")-1;
//				changeApt(choiceApt);
			}
		}
		if (choice==5) {
			System.out.println("Bye!");
			System.exit(0);
		}
		
	}
	
	private static void viewApt() {
		String o = String.format(
				"%-4s %-10s %-13s %-15s %-10s %s\n",
				"No.","Username","Date-of-Appt","Time-of-Appt","Designer","Address");
		o+="-------------------------------------------------------------------------------------------------------------------------\n";
		for (int i = 0;i<apptList.size();i++) {
			Appointment a = apptList.get(i);
			o+=String.format("%-4d %-10s %-13s %-15s %-10s %s\n",i+1,a.getuName(),a.getDoA(),a.getToA(),a.getdName(),a.getAddress());
		}
		System.out.println(o);
	}
	
//	private static void changeApt(int apt) {
//		Helper.line(70, "-");
//		String output = "Appointment Page\n";
//		output += "1. Add Appoitment\n";
//		output += "2. View Appoitment\n";
//		output += "3. Change Appointment\n";
//		output += "4. Delete Appointment\n";
//		output += "5. Quit";
//		System.out.println(output);
//		int choice = Helper.readInt("Enter choice > ");
//		for (int i = 0;i<apptList.size();i++) {
//			Appointment a = apptList.get(i);
//			o+=String.format("%-4d %-10s %-13s %-15s %-10s %s\n",i+1,a.getuName(),a.getDoA(),a.getToA(),a.getdName(),a.getAddress());
//		}
//		System.out.println(o);
//	}
}
