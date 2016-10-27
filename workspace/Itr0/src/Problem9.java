import java.util.Scanner;

public class Problem9 {
	private static Scanner scan;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scan = new Scanner(System.in);
		String roman1=new String();
		String roman2=new String();
		char[] input1;
		char[] input2;
		int i,len1,len2,sum1=0,sum2=0,total=0,sum=0;
		while(true)
		{
		System.out.println("Enter the 1st roman number");
		roman1=scan.nextLine();
		len1=roman1.length();
		input1=roman1.toCharArray();
		if(isroman(input1,len1)!=1)
		{	
			System.out.println("Enter valid roman number");
			continue;
		}
		break;
		}
		while(true)
		{
		System.out.println("Enter the 2nd roman number");
		roman2=scan.nextLine();
		len2=roman2.length();
		input2=roman2.toCharArray();
		if(isroman(input2,len2)!=1)
		{	
			System.out.println("Enter valid roman number");
			continue;
		}
		break;
		}
		int [] result=new int[10];
		sum1=sum(input1,len1);
		System.out.println("roman number 1 : "+sum1);
		sum2=sum(input2,len2);
		System.out.println("roman number 2 : "+sum2);
		total = sum1+sum2;
		sum=total;
		for (i = 0; sum > 0; i++)
		{
			result[i] = sum % 10;
			sum /= 10;
		}
		System.out.println("result : "+total);
		printWords(result,i);
	}
	public static int sum(char input[],int len)
	{
		int sum=0;
		for (int i = 0; i < len; i++)
		{
			if (input[i] == 'I')
				sum += 1;
			if (input[i] == 'V')
				sum += 5;
			if (input[i] == 'X')
				sum += 10;
			if (input[i] == 'L')
				sum += 50;
			if (input[i] == 'C')
				sum += 100;
			if (input[i] == 'D')
				sum += 500;
			if (input[i] == 'M')
				sum += 1000;
			if (i<len-1&&input[i] == 'I'&&input[i + 1] == 'V')
				sum -= 2;
			if (i<len-1&&input[i] == 'I'&&input[i + 1] == 'X')
				sum -= 2;
			if (i<len-1&&input[i] == 'X'&&input[i + 1] == 'L')
				sum -= 20;
			if (i<len-1&&input[i] == 'X'&&input[i + 1] == 'C')
				sum -= 20;
			if (i<len-1&&input[i] == 'C'&&input[i + 1] == 'D')
				sum -= 200;
			if (i<len-1&&input[i] == 'C'&&input[i + 1] == 'M')
				sum -= 200;
		}
		return sum;
	}
	public static int isroman(char input[],int len)
	{
		for(int i=0;i<len;i++)
		{
			if(input[i]=='I'||input[i]=='V'||input[i]=='X'||input[i]=='L'||input[i]=='C'||input[i]=='D'||input[i]=='M')
			{
			if (i < len - 4&&input[i] == 'I'&&input[i + 1] == 'I'&&input[i + 2] == 'I'&&input[i + 3] == 'I')
			{
				System.out.println("Not a roman number");
				return 0;
			}
			else if (i < len - 2&&input[i] == 'V'&&input[i + 1] == 'V')
			{
				System.out.println("Not a roman number");
				return 0;
			}
			else if (i < len - 2&&input[i] == 'L'&&input[i + 1] == 'L')
			{
				System.out.println("Not a roman number");
				return 0;
			}
			else if (i < len - 2&&input[i] == 'D'&&input[i + 1] == 'D')
			{
				System.out.println("Not a roman number");
				return 0;
			}
			else if (i < len - 4&&input[i] == 'X'&&input[i + 1] == 'X'&&input[i + 2] == 'X'&&input[i + 3] == 'X')
			{
				System.out.println("Not a roman number");
				return 0;
			}
			else if (i < len - 4&&input[i] == 'C'&&input[i + 1] == 'C'&&input[i + 2] == 'C'&&input[i + 3] == 'C')
			{
				System.out.println("Not a roman number");
				return 0;
			}
			else if (i < len - 4&&input[i] == 'M'&&input[i + 1] == 'M'&&input[i + 2] == 'M'&&input[i + 3] == 'M')
			{
				System.out.println("Not a roman number");
				return 0;
			}
			else if (i < len - 2&&input[i] == 'I'&&input[i + 1] == 'V')
			{
				System.out.println("Not a roman number");
				return 0;
			}
			else if (i < len - 2&&input[i] == 'I'&&input[i + 1] == 'X')
			{
				System.out.println("Not a roman number");
				return 0;
			}
			else if (i < len - 2&&input[i] == 'V'&&input[i + 1] == 'X')
			{
				System.out.println("Not a roman number");
				return 0;
			}
			else if (i < len - 2&&input[i] == 'X'&&input[i + 1] == 'L')
			{
				System.out.println("Not a roman number");
				return 0;
			}
			else if (i < len - 2&&input[i] == 'L'&&input[i + 1] == 'C')
			{
				System.out.println("Not a roman number");
				return 0;
			}
			else if (i < len - 2&&input[i] == 'C'&&input[i + 1] == 'D')
			{
				System.out.println("Not a roman number");
				return 0;
			}
			else if (i < len - 2&&input[i] == 'D'&&input[i + 1] == 'M')
			{
				System.out.println("Not a roman number");
				return 0;
			}
			}
			else
			{
				System.out.println("Not a roman number");
				return 0;
			}
		}
		return 1;
	}
	public static void printWords(int result[],int n)
	{
		int i;
		for (i = n - 1; i >= 0; i--)
		{
			if (i == 2 || i == 3 || i == 5 || i == 7 || i == 9)
			{
				switch(result[i])
				{
				case 1:
					System.out.print("one ");
					break;
				case 2:
					System.out.print("two ");
					break;
				case 3:
					System.out.print("three ");
					break;
				case 4:
					System.out.print("four ");
					break;
				case 5:
					System.out.print("five ");
					break;
				case 6:
					System.out.print("six ");
					break;
				case 7:
					System.out.print("seven ");
					break;
				case 8:
					System.out.print("eight ");
					break;
				case 9:
					System.out.print("nine ");
					break;
				}
			}
			if(i==0&&result[i+1]!=1)
			{
				switch(result[i])
				{
				case 1:
					System.out.print("one ");
					break;
				case 2:
					System.out.print("two ");
					break;
				case 3:
					System.out.print("three ");
					break;
				case 4:
					System.out.print("four ");
					break;
				case 5:
					System.out.print("five ");
					break;
				case 6:
					System.out.print("six ");
					break;
				case 7:
					System.out.print("seven ");
					break;
				case 8:
					System.out.print("eight ");
					break;
				case 9:
					System.out.print("nine ");
					break;
				}
			}
			if ((i == 1 || i == 4 || i == 6 || i == 8)&&result[i]!=1)
			{
				switch(result[i])
				{
				case 2:
					System.out.print("twenty ");
					break;
				case 3:
					System.out.print("thirty ");
					break;
				case 4:
					System.out.print("forty ");
					break;
				case 5:
					System.out.print("fivty ");
					break;
				case 6:
					System.out.print("sixty ");
					break;
				case 7:
					System.out.print("seventy ");
					break;
				case 8:
					System.out.print("eighty ");
					break;
				case 9:
					System.out.print("ninety ");
					break;
				}
			}
			if ((i == 1 || i == 4 || i == 6 || i == 8)&&result[i]==1)
			{
				switch(result[i-1])
				{
				case 1:
					System.out.print("eleven ");
					break;
				case 2:
					System.out.print("twelve ");
					break;
				case 3:
					System.out.print("thirteen ");
					break;
				case 4:
					System.out.print("fourteen ");
					break;
				case 5:
					System.out.print("fifteen ");
					break;
				case 6:
					System.out.print("sixteen ");
					break;
				case 7:
					System.out.print("seventeen ");
					break;
				case 8:
					System.out.print("eighteen ");
					break;
				case 9:
					System.out.print("nineteen ");
					break;
				default:
					System.out.print("ten ");
					break;
				}
			}
			if (i == 9 && result[i] > 0)
				System.out.print("hundred ");
			if (i == 7 && (result[i] > 0 || result[i + 1] > 0 || result[i + 2] > 0))
			{
				String str=(result[i] == 1 && result[i + 1] == 0 || result[i + 2] == 0)?"crore ":"crores ";
				System.out.print(str);
			}
			if (i == 5 && result[i] > 0)
			{
				String str=(result[i] == 1 && result[i + 1] == 0 )?"lakh ":"lakhs ";
				System.out.print(str);
			}
			if (i == 3 && (result[i] > 0||result[i+1]>0))
					System.out.print("thousand ");
			if (i == 2 && result[i] > 0)
			{
				String str=(result[i-1]>0||result[i-2]>0)?"hundred and ":"hundred ";
				System.out.print(str);
			}
		}
	}

}
