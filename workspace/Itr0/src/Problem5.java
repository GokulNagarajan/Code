import java.util.*;
public class Problem5 {
	private static Scanner scan;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scan=new Scanner(System.in);
		String input=new String();
		String key=new String();
		int i,inputLen,keyLen,keyCount=0;
		System.out.println("Enter the input string");
		input=scan.nextLine();
		System.out.println("Enter the key string");
		key=scan.nextLine();
		inputLen=input.length();
		keyLen=key.length();
		char [] inputString=new char[inputLen];
		char [] keyString=new char[keyLen];
		inputString=input.toCharArray();
		keyString=key.toCharArray();
		for (i = 0; i < keyLen; i++)
		{
			if ((int)keyString[i] >= 97 && (int)keyString[i]<=122)
				keyCount = keyCount + ((int)keyString[i]-97);
			else if ((int)keyString[i] >= 65 && (int)keyString[i] <= 90)
				keyCount = keyCount + (keyString[i] - 65);
			else if ((int)keyString[i] >= 48 && (int)keyString[i] <= 57)
				keyCount = keyCount + (keyString[i] - 48);
		}
		if (keyCount>26)
			keyCount = keyCount % 26;
		
		System.out.println("encrpted input ");
		for (i = 0; i < inputLen; i++)
		{
			if ((int)inputString[i] >= 97 && (int)inputString[i] <= 122)
			{
				if ((int)(inputString[i] + keyCount)>122)
					System.out.print((char)(((inputString[i] + keyCount) % 122) + 96));
				else
					System.out.print((char)(inputString[i] + keyCount));
			}
			else if ((int)inputString[i] >= 65 && (int)inputString[i] <= 90)
			{
				if ((int)(inputString[i] + keyCount)>90)
					System.out.print((char)(((inputString[i] + keyCount) % 90) + 64));
				else
					System.out.print((char)(inputString[i] + keyCount));
			}
			else if ((int)inputString[i] >= 48 && (int)inputString[i] <= 57)
			{
				if ((int)(inputString[i] + (keyCount%10))>57)
					System.out.print((char)(((inputString[i] + (keyCount%10)%57)+ 47)));
				else
					System.out.print((char)(inputString[i] + (keyCount%10)));
			}
			else
			{
				System.out.print((char)(inputString[i]));
			}
		}
	}

}
