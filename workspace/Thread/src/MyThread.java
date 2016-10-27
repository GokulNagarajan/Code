public class MyThread extends Thread
{
	int i;
	public MyThread()
	{
		i=0;
	}
	public MyThread(int i) {
		this.i=i;
	}
	public void run()
	{
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The number is : "+i);
	}
}