public class MethodOverloading {
	static class Overloader
	{
		void display()
		{
			System.out.println("Method with no argument");
		}
/*
 		int display()
 		{
			return -1;
		}
		int display(int i)
		{
			return i;
		}
		String display(int i,int j)
		{
			return i;
		}
*/		
		String display(String i)
		{
			return i;
		}
		void display(int i)
		{
			System.out.println("Method with 1 int argument & value "+i);
		}
		void display(double i)
		{
			System.out.println("Method with 1 double argument & value "+i);
		}
		void display(int i,double j)
		{
			System.out.println("Method with 1 int argument & value "+i+" and  1 double argument & value "+j);
		}
		void display(double i,int j)
		{
			System.out.println("Method with 1 double argument & value "+i+" and 1 int argument & value "+j);
		}
		void display(int i,int j)
		{
			System.out.println("Method with 2 int arguments & values "+i+" "+j);
		}
		void display(double i,double j)
		{
			System.out.println("Method with 2 double arguments & values "+i+" "+j);
		}
		void display(long i)
		{
			System.out.println("Method with 1 long argument & value "+i);
		}
		void display(long i,long j)
		{
			System.out.println("Method with 2 long arguments & values "+i+" "+j);
		}
		void display(int i,long j)
		{
			System.out.println("Method with 1 int argument & value "+i+" and 1 long argument & value "+j);
		}
		void display(long i,int j)
		{
			System.out.println("Method with 1 long argument & value "+i+" and 1 int argument & value "+j);
		}
		
	}

	public static void main(String[] args) {
		MethodOverloading.Overloader od=new MethodOverloading.Overloader();
		//MethodOverloading m=new MethodOverloading();
		//MethodOverloading.Overloader o=m.new Overloader();
		System.out.println("\nMethod Overloading\n");
		od.display();
		od.display(5);
		System.out.println(" String display "+od.display("5"));
		od.display(7.5);
		od.display(30000);
		od.display((long)30000);
		od.display(32,15.2);
		od.display(2.5,6);
		od.display(16,19);
		od.display(7.7,3.2);
		od.display(10000, 20000);
		od.display((long)10000, (long)20000);
		od.display(10000, (long)20000);
		od.display((long)10000, 20000);
		System.out.println("Method with 1 int argument & value "+display());
		System.out.println("Method with 1 int argument & value "+display(10));
		System.out.println("\nConstructor Overloading\n");
		ConstructorOverloading cd=new ConstructorOverloading();
		cd=new ConstructorOverloading(5);
		cd=new ConstructorOverloading(7.5);
		cd=new ConstructorOverloading(32,15.2);
		cd=new ConstructorOverloading(2.5,6);
		cd=new ConstructorOverloading(16,19);
		cd=new ConstructorOverloading(7.7,3.2);
	}
	private static int display(int i) {
		// TODO Auto-generated method stub
		return i;
	}

	private static int display() {
		// TODO Auto-generated method stub
		return -1;
	}	
}
	