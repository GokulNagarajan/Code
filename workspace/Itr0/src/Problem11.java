//import java.util.Scanner;
public class Problem11 {
	//private static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input=new String();
		String key=new String();
		int i,inputLen,keyLen,keyCount=0;
		input="qwer123@ASD#7XYz";
		System.out.println("The Input string : "+input);
		key="salt";
		System.out.println("The Key string : "+key);
		inputLen=input.length();
		keyLen=key.length();
		char [] inputString=new char[inputLen];
		char [] keyString=new char[keyLen];
		char [] encryptString=new char[inputLen];
		inputString=input.toCharArray();
		keyString=key.toCharArray();
		for (i = 0; i < keyLen; i++)
		{
			if ((int)keyString[i] >= 97 && (int)keyString[i]<=122)
				keyCount = keyCount + ((int)keyString[i]-97);
			else if ((int)keyString[i] >= 65 && (int)keyString[i] <= 90)
				keyCount = keyCount + (keyString[i] - 65);
			else if((int)keyString[i] >= 48 && (int)keyString[i] <= 57)
				keyCount = keyCount + (keyString[i] - 48);
		}
		if (keyCount>26)
			keyCount = keyCount % 26;
		System.out.print("The Encrypted Input : ");
		for (i = 0; i < inputLen; i++)
		{
			if ((int)inputString[i] >= 97 && (int)inputString[i] <= 122)
			{
				if ((int)(inputString[i] + keyCount)>122)
					encryptString[i]=(char)(((inputString[i] + keyCount) % 122) + 96);
				else
					encryptString[i]=(char)(inputString[i] + keyCount);
				
			}
			else if ((int)inputString[i] >= 65 && (int)inputString[i] <= 90)
			{
				if ((int)(inputString[i] + keyCount)>90)
					encryptString[i]=(char)(((inputString[i] + keyCount) % 90) + 64);
				else
					encryptString[i]=(char)(inputString[i] + keyCount);
			}
			else if ((int)inputString[i] >= 48 && (int)inputString[i] <= 57)
			{
				if ((int)(inputString[i] + (keyCount%10))>57)
					encryptString[i]=((char)(((inputString[i] + (keyCount%10)%57)+ 47)));
				else
					encryptString[i]=((char)(inputString[i] + (keyCount%10)));
			}
			else
				encryptString[i]=(char)(inputString[i]);
			System.out.print(encryptString[i]);
		}
		System.out.println();
		System.out.print("The Decrypted Output : ");
		
		for (i = 0; i < inputLen; i++)
		{
			if ((int)encryptString[i] >= 97 && (int)encryptString[i] <= 122)
			{
				if ((int)(encryptString[i] - keyCount)>=97)
					System.out.print((char)(encryptString[i] - keyCount));
				else
					System.out.print((char)(encryptString[i] - keyCount+26));	
			}
			else if ((int)encryptString[i] >= 65 && (int)encryptString[i] <= 90)
			{
				if ((int)(encryptString[i] - keyCount)>=65)
					System.out.print((char)(encryptString[i] - keyCount));
				else
					System.out.print((char)(encryptString[i] - keyCount+26));
			}
			 else if ((int)encryptString[i] >= 48 && (int)encryptString[i] <= 57)
			{
				if((int)(encryptString[i] - (keyCount%10))<48)
					System.out.print((char)((int)encryptString[i] - (keyCount%10) + 10 ));
				else
					System.out.print((char)((int)encryptString[i] - (keyCount%10)));
			}
			else
				System.out.print((char)encryptString[i]);
			}
	}

}
