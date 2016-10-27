
public class RunnableThread implements Runnable{
	
	static int count=0;
	@Override
	public void run() {
		synchronized(RunnableThread.class)
		{
		System.out.println("Thread "+Thread.currentThread().getName());
		for(int i=1;i<=5;i++)
			System.out.println("\tloop "+i);
		count++;
		System.out.println("Count : "+count);
		}
	}

	
}
