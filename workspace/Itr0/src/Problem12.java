import java.util.Scanner;
public class Problem12 {
	private static Scanner scan;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long number,i,sum=0;
		scan = new Scanner(System.in);
		do
		{
			do
			{
			try
			{
			System.out.println("enter the Number");
			number=scan.nextLong();
			break;
			}
			catch(Exception e)
			{
				System.out.println("The Number is not valid");
				scan.next();
			}
			}while(true);
			if(number>1&&number<=2000000)
			{
			for(i=2;i<=number;i++)
			{
				if(i<10)
				{
					if(isprime(i)==1)
					sum=sum+i;
				}
				else
				{
				if(i%2!=0&&i%10!=5)
				{	
					if(isprime(i)==1)
						sum=sum+i;
				}
				}
			}
			break;
			}
			else
			{
				System.out.println("enter the Number greater than 1 and less than 2000000");
			}
		}while(true);
		System.out.println("Sum of Prime Numbers less than "+number+" = "+sum);
	}
	public static int isprime(long n)
	{
		int x;
		for(x=2;x<=Math.sqrt(n);x++)
		{
			if(n%x==0)
				return 0;
		}
		System.out.println(n);
		return 1;
	}
}
