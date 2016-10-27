
public class RunThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunnableThread t=new RunnableThread();
		Thread t1=new Thread(t);
		Thread t2=new Thread(t);
		Thread t3=new Thread(t);
		Thread t4=new Thread(t);
		Thread t5=new Thread(t);
		t1.setPriority(Thread.MIN_PRIORITY);
		t3.setPriority(Thread.NORM_PRIORITY);
		t5.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

}
