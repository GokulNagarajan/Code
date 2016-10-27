import java.util.Scanner;


public class SheepProblem {
	private static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input;
		input=scan.nextLine();
		char [] inputArray=input.toCharArray();
		for(char s:inputArray)
			System.out.println(s);
		int [] count=new int[10];
		int n=1;
		while(true)
		{
			for(int i=0;i<inputArray.length;i++)
			{
				if(inputArray[1]==0)
				{
					System.out.println("INSOMIA");
					System.exit(0);
				}
				else
					count[i]++;
			}
			if(check(count)==1)
			{
				System.out.println(input);
				System.exit(0);
			}
			n++;
			for(int i=0;i<inputArray.length;i++)
				inputArray[i]=(char) ((int)inputArray[i]*n);
		}
	
	}
	private static int check(int[] count) {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++)
		{
			if(count[i]<1)
				return 0;
		}
		return 1;
	}

}
