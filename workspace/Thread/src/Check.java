
public class Check {

	public static void main(String[] args) {
		My1 my1=new My1();
		My2 my2=new My2();
		Thread t=new Thread(my2);
		my1.start();
		t.start();
	}

}
