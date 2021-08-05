import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Account acc1;
	private Account acc2;

	private ArrayList<Account> accListTest;

	@Before
	public void setUp() throws Exception {

		accListTest = new ArrayList<Account>();
		acc1 = new Account("dous", "Customer", "1234@123com", "douss", 87654321);
		acc2 = new Account("teo", "Admin", "55@123com", "123", 12345678);
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);

	}

	@Test
	public void addUserTest() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid account arraylist to add to", accListTest);

		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		C206_CaseStudy.addUser(accListTest, acc1);
		assertEquals("Check that account arraylist size is 1", 1, accListTest.size());
		assertSame("Check that account1 is added", acc1, accListTest.get(0));

		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		C206_CaseStudy.addUser(accListTest, acc2);
		assertEquals("Check that account arraylist size is 2", 2, accListTest.size());
		assertSame("Check that account is added", acc2, accListTest.get(1));

	}

	@Test
	public void viewUserTest() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Check if there is valid account arraylist to add to", accListTest);
		
		// test if the list of account retrieved from the database is empty - boundary
		String allUser = C206_CaseStudy.viewUser(accListTest);
		String testOutput = "No users found\n";
		assertSame("Check that ViewAllaccountlist", testOutput, allUser);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		C206_CaseStudy.addUser(accListTest, acc1);
		C206_CaseStudy.addUser(accListTest, acc2);
		assertEquals("Test that account arraylist size is 2", 2, accListTest.size());

		// test if the expected output string same as the list of account retrieved from
		// the database
		allUser = C206_CaseStudy.viewUser(accListTest);
		testOutput = String.format("%-20s %-10s %-20s %-10s\n", "dous", "Customer", "1234@123com", "87654321");
		testOutput += String.format("%-20s %-10s %-20s %-10s\n", "teo", "Admin", "55@123com", "12345678");
		assertEquals("Test that ViewAllUserList", testOutput, allUser);

	}

	@Test
	public void delUserTest() {
		C206_CaseStudy.addUser(accListTest, acc1);
		C206_CaseStudy.addUser(accListTest, acc2);
		assertEquals("Test that account arraylist size is 2", 2, accListTest.size());

		// test that account is deleted
		String name = acc1.getName();
		String delUser = C206_CaseStudy.delUser(accListTest, name);
		assertEquals("Test that account arraylist size is 1", 1, accListTest.size());

		// test that the successful message displayed
		String delMsgTest = acc1.getName() + " has been successfully deleted";
		assertEquals("Test that successful message displayed", delUser, delMsgTest);


		// test that account deleted is the correct one
		String delMsgErrorTest = "No user with that name is found";
		delUser = C206_CaseStudy.delUser(accListTest, "jon");
		assertSame("Test that account deleted  is account 1", delUser, delMsgErrorTest);

	}

	@After
	public void tearDown() throws Exception {
	}

}
