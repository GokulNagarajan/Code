import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class SpawnMain {
	private static Scanner scan = new Scanner(System.in);
	public static int countx = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n=8, x = 0;
		long start, end;
		BufferedWriter out = new BufferedWriter(new FileWriter("D://doc.txt"));
		while (true) {
			try {
				System.out.println("Enter the number of threads to create");
				n = scan.nextInt();
				if (n > 0)
					break;
				else
					System.out.println("Enter number greater than 0");
			} catch (Exception e) {
				System.out.println("Enter valid number");
				scan.next();
			}
		}
		Thread[] t = new Thread[n];
		start = System.currentTimeMillis();
		for (int itr = 1; itr <= n;itr = 2 * itr) {
			System.out.println("Total Number of iteratons : " + itr);
			SpawnThread.count = 0;
			for (int i = 0; i < itr; i++) {
				t[i] = new Thread(new SpawnThread());
				t[i].start();
				//synchronized(t[i]) 
				{
				try {
					t[i].join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
			end = System.currentTimeMillis();
			System.out.println("Total Time taken by " + itr + " Threads : "
					+ (end - start) + " milliseconds \nCount value : "
					+ SpawnThread.count);
			out.write("Result with " + itr + " Threads : " + SpawnThread.count);
			out.newLine();
			out.write("Total Time taken by " + itr + " Threads : "
					+ (end - start) + " milliseconds");
			out.newLine();
		}
		if (out != null)
			out.close();
		start = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 10000; j++) {
				x = countx;
				x++;
				countx = x;
			}
		}
		end = System.currentTimeMillis();
		System.out.println("Total Time taken Normally : " + (end - start)
				+ " milliseconds");
		System.out.println("Count value : " + countx);
	}

}
