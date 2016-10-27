import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy{

	public static void main(String[] args) {
		System.out.println("Copying the file");
		try {
			copy("D://TextFile//Sample.txt","D://TextFile//Copy.txt");
			System.out.println("Copying Completed");
			BufferedReader fin=new BufferedReader(new FileReader("D://TextFile//Copy.txt"));
			String s;
			System.out.println("\nOpening Copied File\n");
			while((s=fin.readLine())!=null)
			{
				System.out.println(s);
			}
			System.out.println("\nClosing Copied File\n");
			if(fin!=null)
			fin.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
}
	public static void copy(String in,String out) throws Exception
	{
		BufferedReader fin = null;
		BufferedWriter fout = null;
		String s;
		try {
			fin = new BufferedReader(new FileReader(in));
			fout = new BufferedWriter(new FileWriter(out));
			while((s=fin.readLine())!=null)
			{
				fout.write(s);
				fout.newLine();
			}
		} catch (Exception e) {
			throw new Exception("File cannot be used");
		}
		finally
		{
			if(fin!=null)
				fin.close();
			if(fout!=null)
				fout.close();
		}
	}
}