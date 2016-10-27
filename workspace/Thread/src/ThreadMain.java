
public class ThreadMain {

	public static void main(String[] args) {
		MyThread t=new MyThread(7);
		MyThread t1=new MyThread();
		MyThread t2=new MyThread();
		try {
			System.out.println("MyThread current thread : "+Thread.currentThread());
			System.out.println("Old time");
			System.out.println(System.currentTimeMillis());
			MyThread.sleep(5000);
			System.out.println("New time");
			System.out.println(System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.start();
		t1.start();
		t2.start();
		
	}
}
