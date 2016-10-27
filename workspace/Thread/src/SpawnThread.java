public class SpawnThread implements Runnable{
	int x;
	public static int count=0;
	SpawnThread()
	{
		x=0;
	}
	public void run() {
		// TODO Auto-generated method stub
		for(int j=0;j<10000;j++)
		{
			increment();
		}
		System.out.println("X: "+x);
	}
	private void increment() {
		x=count;
		x++;
		count=x;
	}
}
