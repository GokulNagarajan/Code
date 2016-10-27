import java.util.Scanner;


public class TryCatchFinally {
	private static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		int n=0;
		System.out.println("Start while");
		while(true)
		{
		try
		{
			System.out.println("Try Block");
			System.out.println("Enter a number");
			n=scan.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Catch Block");
			System.out.println("Input is not an integer");
			scan.next();
			continue;
		}
		finally
		{
			System.out.println("Finally Block");
		}
		System.out.println("end while");
		break;
		}
		System.out.println("Input entered : "+n);
	}

}
