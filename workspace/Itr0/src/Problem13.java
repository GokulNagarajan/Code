import java.util.Scanner;
public class Problem13 {
	private static Scanner scan;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scan=new Scanner(System.in);
		String inputString = new String();
		int inputLen,i,upperCase=0,lowerCase=0,number=0,symbol=0;
		while(true)
		{
		while(true)
		{
		System.out.println("Enter the Password");
		inputString=scan.nextLine();
		inputLen=inputString.length();
		if(inputLen<8)
		{
			System.out.println("Password length is weak");
			continue;
		}
		else
			break;
		}
		char [] input=new char[inputLen];
		input=inputString.toCharArray();
		for(i=0;i<inputLen;i++)
		{
			if(input[i]>=65&&input[i]<=90)
				upperCase++;
			else if(input[i]>=97&&input[i]<=122)
				lowerCase++;
			else if(input[i]>=48&&input[i]<=57)
				number++;
			else
				symbol++;	
		}
		if(upperCase>0&&lowerCase>0&&number>0&&symbol>0)
		{
			System.out.println("Password is strong");
			break;
		}
		else
			System.out.println("Password is weak");	
		}
	}

}
