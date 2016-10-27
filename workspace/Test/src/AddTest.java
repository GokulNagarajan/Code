import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class AddTest {
	
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
	public void testSum() {
		//fail("Not yet implemented");
		//assertEquals(10, Add.sum(4, 7));
		assertEquals(11, Add.sum(4, 7));
		assertEquals(30.5, Add.sum(10.5, 20), 0);
		
	}

}
