import java.util.Scanner;
public class TraditionalExceptionHandling {

		private static Scanner scan=new Scanner(System.in);
		public static void main(String[] args) {
			int n=0,i,divisor = 0,index=0,inputLen,k=0;
			String input="";
			System.out.println("Enter the input number with spaces");
			input=scan.nextLine();
			char[] inputArray=input.toCharArray();
			inputLen=inputArray.length;
			for(i=0;i<inputLen;i=i+2)
			{
				if(inputArray[i]>=48&&inputArray[i]<=57)
					n++;
				else
				{
					System.out.println("Input is not valid");
					System.exit(0);
				}
			}
			int [] data=new int [n-2];
			for(i=0;i<n-2;i++)
			{
				data[i]=(int)inputArray[2*k]-48;
				k++;
			}
			if(n>0)
			{
				divisor=(int)inputArray[inputLen-1]-48;
				if(n>1)
				{
					index=(int)inputArray[inputLen-3]-48;
				}
				else 
					index=-1;
			}
			else
				divisor=0;
			System.out.println(method(data,index,divisor));
		}
		public static int method(int [] data,int index,int divisor)
		{
			int n=data.length,number=0;
			if(index<0)
			{
				System.out.println("index is empty");
				return -1;
			}
			if(n>0)
			{
				if((index<n-1)&&index>=0)
					number=data[index];
				else 
				{
					System.out.println("Number not present for the index");
					number=0;
				}
			}
			else
			{
				System.out.println("Number array is empty");
				number=0;
			}
			data=null;
			if(divisor==0)
			{	
				System.out.println("Dividing by zero");
				return -1;
			}
			System.out.println("Result : "+number+" / "+divisor+" "+number/divisor);
			return (number/divisor);
		}
}

