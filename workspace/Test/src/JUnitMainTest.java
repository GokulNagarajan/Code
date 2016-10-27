import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class JUnitMainTest {
	Function fun=new Function();
	String [] arr={"1","2","3"};
	int [] arr1={1,2,3};
	float [] arr2={1,2,3};
	double [] arr3={1,2,3};
	long [] arr4={1,2,3};
	String [][] arr0={{"1","2","3"},{"4","5","6"},{"7","8","9"}};
	int [][] arr11={{1,2,3},{4,5,6},{7,8,9}};
	float [][] arr12={{1,2,3},{4,5,6},{7,8,9}};
	double [][] arr13={{1,2,3},{4,5,6},{7,8,9}};
	long [][] arr14={{1,2,3},{4,5,6},{7,8,9}};
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
	public void testMain() {
		assertEquals(109.5, fun.floatValue(),10);
		assertEquals(67.77, fun.doubleValue(),10);
		assertEquals(89.5, fun.floatValue(),10);
		assertEquals(87.77, fun.doubleValue(),10);
		int [] itmp=fun.intArrayValue();
		int [][] ii=fun.intMultiArrayValue();
		long [] ltmp=fun.longArrayValue();
		long [][] ll=fun.longMultiArrayValue();
		for(int i=0;i<arr.length;i++)
			assertEquals(arr[i],String.valueOf(itmp[i]));				
		for(int i=0;i<arr.length;i++)
			assertEquals(arr[i],String.valueOf(ltmp[i]));				
		for(int i=0;i<arr0.length;i++)
			for(int j=0;j<arr0.length;j++)
				assertEquals(arr0[i][j],String.valueOf(ii[i][j]));
		for(int i=0;i<arr0.length;i++)
			for(int j=0;j<arr0.length;j++)
				assertEquals(arr0[i][j],String.valueOf(ll[i][j]));
		
	}
	
	@Test
	public void testStrValue() {
		assertEquals("JUnit Testing",fun.strValue());
	}

	@Test
	public void testIntValue() {
		assertEquals(32, fun.intValue());
	}

	@Test
	public void testFloatValue() {
		assertEquals(99.5, fun.floatValue(),0);
	}

	@Test
	public void testDoubleValue() {
		assertEquals(77.77, fun.doubleValue(),0);
	}

	@Test
	public void testLongValue() {
		assertEquals(987654321, fun.longValue());
	}

	@Test
	public void testStrArrayValue() {
		String [] stmp=fun.strArrayValue();
		for(int i=0;i<arr.length;i++)
			assertEquals(arr[i], stmp[i]);
	}

	@Test
	public void testIntArrayValue() {
		int [] itmp=fun.intArrayValue();
		for(int i=0;i<arr1.length;i++)
			assertEquals(arr1[i], itmp[i]);
	}

	@Test
	public void testFloatArrayValue() {
		float [] ftmp=fun.floatArrayValue();
		for(int i=0;i<arr2.length;i++)
			assertEquals(arr2[i], ftmp[i],0);
	}

	@Test
	public void testDoubleArrayValue() {
		double [] dtmp=fun.doubleArrayValue();
		for(int i=0;i<arr3.length;i++)
			assertEquals(arr3[i], dtmp[i],0);
	}

	@Test
	public void testLongArrayValue() {
		long [] ltmp=fun.longArrayValue();
		for(int i=0;i<arr4.length;i++)
			assertEquals(arr4[i], ltmp[i]);
	}

	@Test
	public void testStrMultiArrayValue() {
		String [][] ss=fun.strMultiArrayValue();
		for(int i=0;i<arr0.length;i++)
			for(int j=0;j<arr0.length;j++)
				assertEquals(arr0[i][j],ss[i][j]);
	}

	@Test
	public void testIntMultiArrayValue() {
		int [][] ii=fun.intMultiArrayValue();
		for(int i=0;i<arr11.length;i++)
			for(int j=0;j<arr11.length;j++)
				assertEquals(arr11[i][j],ii[i][j]);
		}

	@Test
	public void testFloatMultiArrayValue() {
		float [][] ff=fun.floatMultiArrayValue();
		for(int i=0;i<arr12.length;i++)
			for(int j=0;j<arr12.length;j++)
				assertEquals(arr12[i][j],ff[i][j],0);
		}

	@Test
	public void testDoubleMultiArrayValue() {
		double [][] dd=fun.doubleMultiArrayValue();
		for(int i=0;i<arr13.length;i++)
			for(int j=0;j<arr13.length;j++)
				assertEquals(arr13[i][j],dd[i][j],0);
		}

	@Test
	public void testLongMultiArrayValue() {
		long [][] ll=fun.longMultiArrayValue();
		for(int i=0;i<arr14.length;i++)
			for(int j=0;j<arr14.length;j++)
				assertEquals(arr14[i][j],ll[i][j]);
		}

}
