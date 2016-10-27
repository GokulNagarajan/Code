
public class StaticClass {
	static int VALUE=1;
	static int COUNT;
	static{
		System.out.println("Welcome before main");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticDerived sd=new StaticDerived();
		sd.display();
		VALUE=0;
		System.out.println("Value : "+VALUE);
		COUNT=1;
		System.out.println("Count : "+COUNT);
	}

}
class StaticBase
{
	StaticBase()
	{
		System.out.println("In Base Class");
	}
	public void display() {
		
	}
	public void fun()
	{
		System.out.println("Base Class Function");
	}
	public void close()
	{
		System.out.println("Closing Base Class");
	}
}
class StaticDerived extends StaticBase
{
	StaticDerived()
	{
		super();
		System.out.println("In Derived Class");
	}
	@Override
	public void display() {
		this.fun();
		System.out.println("Method override");	
		this.close();
	}
	public void fun()
	{
		super.fun();
		System.out.println("Derived Class Function");	
	}
	public void close()
	{
		super.close();
		System.out.println("Closing Derived Class");
	}
}
