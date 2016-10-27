import java.util.Scanner;
public class Problem2 {
	private static Scanner scan;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j,k,inputLen;
		String inputString = new String();
		scan =new Scanner(System.in);
		System.out.println("enter the input");
		inputString=scan.nextLine();
		inputLen=inputString.length();
		int [] count=new int[inputLen];
		char input[]=new char[inputLen];
		input=inputString.toCharArray();
		for(i=0;i<inputLen;i++)
		{ 
			count[i]=0;
			for(j=0;j<inputLen;j++)
			{
				if(input[i]==input[j])
					count[i]++;
			}
		}
		for(k=0;k<inputLen;k++)
		{
			for(i=k;i<inputLen;i++)
			{
				for(j=k;j<=i;j++)
				{
					if(count[j]==1||(i!=j||j!=k))
						System.out.print(input[j]);	
				}
				System.out.println();
			}
		}
		for(i=0;i<inputLen-1;i++)
		{
			for(j=i+1;j<inputLen;j++)
			{
				if(count[i]>1&&input[i]==input[j])
				{
				System.out.println(input[i]);
				count[j]=1;
				}
			}
		}
	}

}
