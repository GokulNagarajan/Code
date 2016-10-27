import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteThread extends Thread{
	private String out;

	WriteThread(String out)
	{
		this.out=out;
	}
	@Override
	synchronized public void run()
	{
		BufferedWriter fout = null;
		try {
			fout = new BufferedWriter(new FileWriter(out));
			fout.write(FileCopyThread.s);
		} catch (Exception e) {
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
