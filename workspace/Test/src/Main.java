
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A() {
			
			@Override
			public void print() {
				// TODO Auto-generated method stub
			System.out.println("hello");	
			}
		};
		a.print();
	}

}
interface A
{
	void print();
}