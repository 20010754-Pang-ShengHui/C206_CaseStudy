import java.util.ArrayList;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AppointmentMain {


	private static ArrayList<Appointment> apptList = new ArrayList<Appointment>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Cannot load program from here. Please use C206_CaseStudy.java!");
	}
	
	public static void start(String un,String role) {
		int choice = -1;
		while (choice!=5) {
			Helper.line(70, "-");
			String output = "Appointment Page\n";
			output += "1. Add Appointment\n";
			output += "2. View Appointment\n";
			output += "3. Change Appointment\n";
			output += "4. Delete Appointment\n";
			output += "5. Logout & Quit";
			System.out.println(output);
			choice = Helper.readInt("Enter choice > ");
			if (choice==1) {
				String usN = Helper.readString("Enter Username > ");
				String date = Helper.readString("Enter date (DD/MM/YYYY) > ");
				String time = Helper.readString("Enter time in 24Hrs (HH:MM) > ");
				String dName = Helper.readString("Enter Designer Name > ");
				String addr = Helper.readString("Enter Address > ");
				
				boolean matchDate = Pattern.matches("^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$",date);
				boolean matchTime = Pattern.matches("^(2[0-3]|[01]?[0-9]):([0-5]?[0-9])$",time);
				if (matchTime && matchDate) {
					LocalDate lcDate = LocalDate.parse(date,DateTimeFormatter.ofPattern("d/MM/yyyy"));
					LocalTime lcTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("H:mm"));
					Appointment apt = new Appointment(usN, lcDate,lcTime, dName, addr);
					addApt(apptList,apt);					
				}
				else {
					System.out.println("Invalid Date and Time entered!");
				}
				
			}
			else if (choice==2) {
				viewApt();
			} else if (choice==3) {
				changeApt();
			}
			else if (choice==4) {
				deleteApt();
			}
		}
		if (choice==5) {
			System.out.println("Logging out...");
			try {
				Thread.sleep(1000);
	         } catch (Exception e) {
	            System.out.println(e);
	         }
			System.out.println("Bye!");
			System.exit(0);
		}
		
	}
	
	public static void addApt(ArrayList<Appointment> aptList, Appointment apt) {
		aptList.add(apt);
		System.out.println("Appointment Added!");
	}
	
	public static String retrieveAllAppointments(ArrayList<Appointment> aptList) {
		String o = "";
		for (int i = 0;i<aptList.size();i++) {
			Appointment a = aptList.get(i);
			o+=String.format("%-4d %-10s %-13s %-15s %-10s %s\n",
					i+1,a.getuName(),a.getDoA(),a.getToA(),a.getdName(),a.getAddress()
					);
		}
		return o;
	}
	
	public static void coviewApt() {
		String o = String.format(
				"%-4s %-10s %-13s %-15s %-10s %s\n",
				"No.","Username","Date-of-Appt","Time-of-Appt","Designer","Address");
		o+=retrieveAllAppointments(apptList);
		System.out.println(o);
		
	}
	
	public static void viewApt() {
		if (!apptList.isEmpty()) {
			coviewApt();
		}
		else { 
			Helper.line(70, "-");
			System.out.println("There are no Appointments made at the moment.");
		}
		
	}
	
	private static void changeApt() {

		if (!apptList.isEmpty()) {
			viewApt();
			int cApt = (Helper.readInt("Appointment no. > ")-1);
			Helper.line(70, "-");
			int choice = 0;
			while (choice!=3) {
				viewApt();
				String output = "Change Appointment Page\n";
				output += "1. Change Date\n";
				output += "2. Change Time\n";
				output += "3. Back\n";
				output += "4. Logout & Quit";
				System.out.println(output);
				choice = Helper.readInt("Enter choice > ");
				if (choice==1) {
					for (int i = 0;i<apptList.size();i++) {
						Appointment a = apptList.get(i);
						if (cApt==i) {
							String date = Helper.readString("Enter new date (DD/MM/YYYY) > ");
							boolean matchDate = Pattern.matches("^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$",date);
							if (matchDate) {
								LocalDate lcDate = LocalDate.parse(date,DateTimeFormatter.ofPattern("d/MM/yyyy"));
								cDate(apptList,a,lcDate);
								break;
							} else {
								System.out.println("Invalid Date entered!");
							}
						}
					}
					System.out.println("Date is successfully changed!");
				}
				else if (choice==2) {
					for (int i = 0;i<apptList.size();i++) {
						Appointment a = apptList.get(i);
						if (cApt==i) {
							String time = Helper.readString("Enter new time in 24Hrs (HH:MM) > ");
							boolean matchTime = Pattern.matches("^(2[0-3]|[01]?[0-9]):([0-5]?[0-9])$",time);
							if (matchTime) {
								LocalTime lcTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("H:mm"));
								cTime(apptList,a,lcTime);
								break;
							} else {
								System.out.println("Invalid Time entered!");
							}
						}
					}
					System.out.println("Time is successfully changed!");

				} else if (choice>4 || choice<0) {
					System.out.println("Invalid Input!");
				} else if (choice==4) {
					System.out.println("Bye!");
					System.exit(1);
				}
			}
			if (choice==3) {
				System.out.println("Going back...");
				try {
		            Thread.sleep(500);
		         } catch (Exception e) {
		            System.out.println(e);
		         }
			}
		} else {
			Helper.line(70, "-");
			System.out.println("There are no Appointments made at the moment.");
		}
	}
	
	public static void cDate(ArrayList<Appointment> apptList,Appointment a,LocalDate lcd) {
		for (int i = 0;i<apptList.size();i++) {
			if (apptList.get(i)==a) {
					a.setDoA(lcd);
			}
		}
	}

	public static void cTime(ArrayList<Appointment> apptList,Appointment a,LocalTime lct) {
		for (int i = 0;i<apptList.size();i++) {
			if (apptList.get(i)==a) {
				a.setToA(lct);
			}
		}
	}
	
	private static void deleteApt() {
		if (!apptList.isEmpty()) {
			viewApt();
			int dApt = (Helper.readInt("Appointment no. > ")-1);
			char yn = Helper.readChar("Are you sure you want to delete? (Y/N) > ");
			if (yn=='Y' || yn=='y') {
				for (int i = 0;i<apptList.size();i++) {
					Appointment a = apptList.get(i);
					if (i==dApt) {
						cDelapt(apptList,a);
						System.out.println("Deleting Appointment no. "+(dApt+1)+"...");
						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							System.out.println(e);
						}
						System.out.println("Your Appointment is successfully deleted!");
						break;
					}
				}
				
			} else if (yn=='N' || yn=='n') {
				System.out.println("Deletion canceled!");
				System.out.println("Going back...");
				try {
		            Thread.sleep(500);
		         } catch (Exception e) {
		            System.out.println(e);
		         }
			} else {
				System.out.println("Invalid Input!");
			}
		} else {
			Helper.line(70, "-");
			System.out.println("There are no Appointments made at the moment.");
		
		}
	}
	
	public static void cDelapt(ArrayList<Appointment> apptList,Appointment a) {
		apptList.remove(a);
	}
}
