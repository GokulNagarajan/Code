import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestMainTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Before method");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After method");
	}

	@Test
	public void testMax() {
		assertEquals(9, TestMain.max(2,9,4,7,3,1));
		assertNotEquals(3, TestMain.max(2,9,4,7,3,1));
		//fail("Not yet implemented");
	}

	@Test
	public void testMin() {
		assertEquals(1, TestMain.min(2,9,4,7,3,1));
		assertNotEquals(3, TestMain.max(2,9,4,7,3,1));
		//fail("Not yet implemented");
	}

}
