import static org.junit.Assert.*; 

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuotationMainTest {
	
	private Quotation q1;
	private Quotation q2;

	private ArrayList<Quotation> quoteListTest;      
	
	@Before
	public void setUp() throws Exception {
		
		quoteListTest = new ArrayList<Quotation>();
		q1 = new Quotation(23, 45, "Kitchen", "Tiles", 250.00, "ven", "08/25/2021", 250.00);
		q2 = new Quotation(58, 98, "Bedroom", "Cabinet", 340.00, "umi", "09/10/2021", 340.00);
	}

	@Test
	public void addAppointment() {
		
		// Quotation list is not null, so that can add a new Quotation - boundary
		assertNotNull("Check if there is valid Quotation arraylist to add to", quoteListTest);
		
		
		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		QuotationMain.addQuotation(quoteListTest, q1);
		assertEquals("Check that Quotation arraylist size is 1", 1, quoteListTest.size());
		assertSame("Check that Quotation1 is added", q1, quoteListTest.get(0));

		
		// Add another item. test that the size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		QuotationMain.addQuotation(quoteListTest, q2);
		assertEquals("Check that Quotation arraylist size is 2", 2, quoteListTest.size());
		assertSame("Check that Quotation is added", q2, quoteListTest.get(1));
		
	}

	@Test
	public void deleteAppointment() {
		
		QuotationMain.addQuotation(quoteListTest, q1);
		QuotationMain.addQuotation(quoteListTest, q2);
		assertEquals("Test that Quotation arraylist size is 2", 2, quoteListTest.size());

		
		// test that account is deleted
		int quoid = q1.getQuotid();
		int delquote = QuotationMain.deleteQuotation(quoteListTest, quoid);
		assertEquals("Test that account arraylist size is 1", 1, quoteListTest.size());

		
		// test that the successful message displayed
		String delMsgTest = q1.getQuotid() + " has been successfully deleted";
		assertEquals("Test that successful message displayed", delquote, delMsgTest);

		
		// test that account deleted is the correct one
		String delMsgErrorTest = "No user with that name is found";
		delquote = QuotationMain.deleteQuotation(quoteListTest, quoid);
		assertSame("Test that Quotation deleted is Quotation 1", delquote, delMsgErrorTest);

	}
	
	@Test
	public void viewQuotations() {
		
		// Quotation list is not null, so that can add a new Quotation - boundary
		assertNotNull("Check if there is valid Quotation arraylist to add to", quoteListTest);
		
		
		// Test if the list of Quotation retrieved from the database is empty - boundary
		String allQuote = QuotationMain.viewQuotations(quoteListTest);
		String testOutput = "No users found\n";
		assertSame("Check ViewAllquotationlist", testOutput, allQuote);
		
		
		// Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		QuotationMain.addQuotation(quoteListTest, q1);
		QuotationMain.addQuotation(quoteListTest, q2);
		assertEquals("Test that account arraylist size is 2", 2, quoteListTest.size());
		
		
		// Test if the expected output string same as the list of account retrieved from the database
		allQuote = QuotationMain.viewQuotations(quoteListTest);
		testOutput = String.format("%-10d %-15d %-15s %-15s %-15.2f %-15s %-15s %-15.2f\n", 23, 45, "Kitchen", "Tiles", 250.00, "ven", "08/25/2021", 250.00);
		testOutput += String.format("%-10d %-15d %-15s %-15s %-15.2f %-15s %-15s %-15.2f\n", 58, 98, "Bedroom", "Cabinet", 340.00, "umi", "09/10/2021", 340.00);
		assertEquals("Test ViewAllQuotationsList", testOutput, allQuote);
		
		
	}
	
	@After
	public void tearDown() throws Exception {
		
		q1 = null;
		q2 = null;
		quoteListTest = null;
	}
}
