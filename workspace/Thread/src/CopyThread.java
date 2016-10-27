import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class CopyThread extends Thread{
	private String in;
	private String out;

	CopyThread(String in,String out)
	{
		this.in=in;
		this.out=out;
	}
	@Override
	public void run()
	{
		BufferedReader fin = null;
		BufferedWriter fout = null;
		String s;
		try {
			fin = new BufferedReader(new FileReader(in));
			fout = new BufferedWriter(new FileWriter(out));
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(fin!=null)
			try {
				fin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(fout!=null)
			try {
				fout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
