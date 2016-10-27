import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ReadThread extends Thread{
	private String in;
	
	ReadThread(String in)
	{
		this.in=in;
	}
	@Override
	synchronized public void run()
	{
		BufferedReader fin = null;
		String s;
		try {
			fin = new BufferedReader(new FileReader(in));
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
				FileCopyThread.s+=s+"\n";
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
	}
}
