import java.util.Scanner;
public class Problem1 {
	private static Scanner scan;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scan = new Scanner(System.in);
		String inputString = new String();
		int i=0,inputLen,count=1,k=0;
		char [] input;
		System.out.println("Enter the Input");
		inputString=scan.nextLine();
		input=inputString.toCharArray();
		inputLen=inputString.length();
		char [] compressedInput = new char[2*inputLen];
		System.out.println("Compressed Input String");
		for(i=0;i<inputLen-1;i++)
		{
			if(input[i]==input[i+1])
				count++;
			else
			{
				compressedInput[k++]=input[i];
				compressedInput[k++]=(char) count;
				System.out.print(input[i]);
				if(count>1)
					System.out.print(count);
				count=1;
			}
		}
		compressedInput[k++]=input[i];
		compressedInput[k++]=(char) count;
		System.out.print(input[i]);
		if(count>1)
			System.out.print(count);
		System.out.println();
		System.out.println("Decompressed Input String");
		for(i=0;i<k;i++)
		{
			count=(int)compressedInput[i+1];
			for(;count>0;count--)
				System.out.print(compressedInput[i]);	
			i=i+1;
		}	
	}
}
