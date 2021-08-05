import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppointmentMainTest {
	
	private static ArrayList<Appointment> apptList = new ArrayList<Appointment>();
	private static LocalDate lcDate;
	private static LocalTime lcTime;
	private static Appointment apt;
	@Before
	public void setUp() throws Exception {
		lcDate = LocalDate.parse("05/08/2020",DateTimeFormatter.ofPattern("d/MM/yyyy"));
		lcTime = LocalTime.parse("23:59", DateTimeFormatter.ofPattern("H:mm"));
		apt = new Appointment("PSH", lcDate, lcTime, "John", "Singapore");
	}

	
	public void addAppointMent() {
		assertNotNull("Check if there are any values in the ArrayList",apptList);
	}
	
	
	@After
	public void tearDown() throws Exception {
		lcDate = null;
		lcTime = null;
		apt = null;
	}
}
