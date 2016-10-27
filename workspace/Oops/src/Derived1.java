class Derived1 extends Base1
{
	@Override
	Derived1 fun()
	{
		return new Derived1();
	}
	@Override
	void display()
	{
		System.out.println("Derived class display");
	}
	void show()
	{
		System.out.println("Derived class show");
	}
}