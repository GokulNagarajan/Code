
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyThread {
	public static String s="";
	public static void main(String[] args) {
		ReadThread[] rt=new ReadThread[5];
		WriteThread[] wt=new WriteThread[5];
		long start,end;
		for(int i=0;i<5;i++)
		{
			rt[i]=new ReadThread("D://TextFile//"+(i+1)+".txt");
			wt[i]=new WriteThread("D://TextFile//New"+(i+1)+".txt");
		}
		try
		{
			start=System.currentTimeMillis();
			for(int i=0;i<5;i++)
			{
				s="";
				rt[i].start();
				//rt[i].join();
				wt[i].start();
				//wt[i].join();
			}
			end=System.currentTimeMillis();
			System.out.println("\nTime Taken by 5 threads : "+(end-start));
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		try
		{
			start=System.currentTimeMillis();
			run("D://TextFile//6.txt","D://TextFile//New6.txt");
			run("D://TextFile//7.txt","D://TextFile//New7.txt");
			run("D://TextFile//8.txt","D://TextFile//New8.txt");
			run("D://TextFile//9.txt","D://TextFile//New9.txt");
			run("D://TextFile//10.txt","D://TextFile//New10.txt");
			end=System.currentTimeMillis();
			System.out.println("\nTime Taken by function in 5 runs : "+(end-start)+"\n");
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
}
	public static void run(String in,String out)
	{
		BufferedReader fin = null;
		BufferedWriter fout = null;
		String s;
		try {
			fin = new BufferedReader(new FileReader(in));
			fout = new BufferedWriter(new FileWriter(out));
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
				System.out.println(s);
				fout.write(s);
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

