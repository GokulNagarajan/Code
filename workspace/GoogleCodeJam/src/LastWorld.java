import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LastWorld {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		char [] inputArray = null;
		BufferedReader fin;
		BufferedWriter fout;
		fin=new BufferedReader(new FileReader("D:\\Google Code jam\\A-small-practice.in"));
		fout=new BufferedWriter(new FileWriter("D:\\Google Code jam\\Small-output.txt"));
		System.out.println("Small Input Completed");
		fun(fin,fout,inputArray);
		fin.close();
		fout.close();
		fin=new BufferedReader(new FileReader("D:\\Google Code jam\\A-large-practice.in"));
		fout=new BufferedWriter(new FileWriter("D:\\Google Code jam\\Large-output.txt"));
		System.out.println("Large Input Completed");
		fun(fin,fout,inputArray);
		fin.close();
		fout.close();
		}
	private static void fun(BufferedReader fin, BufferedWriter fout,
			char[] inputArray) throws IOException {
		// TODO Auto-generated method stub
		String input,str,result;
		int x=1;
		fin.readLine();
		while((input=fin.readLine())!=null)
		{
			inputArray=input.toCharArray();
			int n=inputArray.length;
			result=String.valueOf(inputArray[0]);
		for(int i=1;i<n;i++)
		{
			if(result.charAt(0)>inputArray[i])
				result=result+inputArray[i];
			else
				result=String.valueOf(inputArray[i])+result;
			
		}	
		str="Case #"+x+": ";
		fout.write(str);
		fout.write(result);
		x++;
		fout.newLine();
		}
	}
}
