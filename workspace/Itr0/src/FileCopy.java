import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileCopy {

	public static void main(String[] args) throws IOException {
		//TextFile// TODO Auto-generated method stub
		System.out.println("Merging 10 file");
		copy("D://TextFile//1.txt","D://TextFile//MergeCopy.txt");
		copy("D://TextFile//2.txt","D://TextFile//MergeCopy.txt");
		copy("D://TextFile//3.txt","D://TextFile//MergeCopy.txt");
		copy("D://TextFile//4.txt","D://TextFile//MergeCopy.txt");
		copy("D://TextFile//5.txt","D://TextFile//MergeCopy.txt");
		copy("D://TextFile//6.txt","D://TextFile//MergeCopy.txt");
		copy("D://TextFile//7.txt","D://TextFile//MergeCopy.txt");
		copy("D://TextFile//8.txt","D://TextFile//MergeCopy.txt");
		copy("D://TextFile//9.txt","D://TextFile//MergeCopy.txt");
		copy("D://TextFile//10.txt","D://TextFile//MergeCopy.txt");
		System.out.println("Merge Completed");
		System.out.println("Opening Merged File");
		BufferedReader fin=new BufferedReader(new FileReader("D://TextFile//MergeCopy.txt"));
		String s;
		while((s=fin.readLine())!=null)
		{
			System.out.println(s);
		}
		System.out.println("Closing Merged File");
		fin.close();
	}
	public static void copy(String in,String out)
	{
		BufferedReader fin = null;
		BufferedWriter fout = null;
		String s;
		try {
			fin = new BufferedReader(new FileReader(in));
			fout = new BufferedWriter(new FileWriter(out,true));
		} catch (Exception e) {
			//TextFile// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(fin==null)
		{
			System.out.println("Input File not exists");
			System.exit(0);
		}
		try {
			while((s=fin.readLine())!=null)
			{
				fout.write(s);
				fout.newLine();
			}
		} catch (IOException e) {
			//TextFile// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(fin!=null)
				try {
					fin.close();
				} catch (IOException e1) {
					//TextFile// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			if(fout!=null)
				try {
					fout.close();
				} catch (IOException e) {
					//TextFile// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
