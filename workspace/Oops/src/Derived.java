class Derived extends Base
{
	Derived()
	{
		super();
		System.out.println("In Derived Class");
	}
	@Override
	public void display() {
		fun();
		System.out.println("Abstract method override");	
		close();
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
