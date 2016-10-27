import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class AccountMainTest {
	Account newAccount=new Account("108","gokul",2500);
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
	public void testGetAccounts() {
		//fail("Not yet implemented");
		AccountMain.addAccount(newAccount);
		assertEquals(1, AccountMain.getAccounts(newAccount.accountNo));
	}

	@Test
	public void testCheckBalance() {
		//fail("Not yet implemented");
		System.out.println(AccountMain.getbalance(newAccount.accountNo));
		assertEquals(2500, AccountMain.getbalance(newAccount.accountNo),0);
	}

	@Test
	public void testCheckWithdraw() throws MyException {
		//fail("Not yet implemented");
		if(AccountMain.checkWithdraw(newAccount.accountNo, 500)==1)
		assertEquals(2000, AccountMain.getbalance(newAccount.accountNo),0);
	}


	@Test
	public void testCheckDeposit() throws MyException {
		//fail("Not yet implemented");
		if(AccountMain.checkDeposit(newAccount.accountNo, 1000)==1)
			assertEquals(3500, AccountMain.getbalance(newAccount.accountNo),0);
	}
}
