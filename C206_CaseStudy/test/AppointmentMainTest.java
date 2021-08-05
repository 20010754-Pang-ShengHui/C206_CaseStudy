import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppointmentMainTest {
	
	private static ArrayList<Appointment> apptList;
	private static LocalDate lcDate;
	private static LocalTime lcTime;
	private static Appointment apt1;
	private static Appointment apt2;
	@Before
	public void setUp() throws Exception {
		lcDate = LocalDate.parse("05/08/2020",DateTimeFormatter.ofPattern("d/MM/yyyy"));
		lcTime = LocalTime.parse("23:59", DateTimeFormatter.ofPattern("H:mm"));
		apt1 = new Appointment("PSH", lcDate, lcTime, "John", "Singapore");
		apt2 = new Appointment("Test2", lcDate, lcTime, "John", "Singapore");
		apptList = new ArrayList<Appointment>();
	}

	@Test
	public void addAppointment() {
		
		assertNotNull("Check if there are any values in the Appointment List",apptList);
		
		AppointmentMain.addApt(apptList,apt1);
		assertEquals("Check whether the Appointment List is 1", 1,apptList.size());
		assertSame("Check whether apt1 is added",apt1,apptList.get(0));
		
		AppointmentMain.addApt(apptList,apt2);
		assertEquals("Check whether the Appointment List is 2", 2,apptList.size());
		assertSame("Check whether apt1 is added",apt2,apptList.get(1));

	}
	
	
	@After
	public void tearDown() throws Exception {
		lcDate = null;
		lcTime = null;
		apt1 = null;
		apt2 = null;
	}
}
