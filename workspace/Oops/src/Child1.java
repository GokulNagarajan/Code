
public class Child1 extends Parent{
	Child1(String name)
	{
		super(name);
	}
	@Override
	void fun()
	{
		System.out.println("Child1 name : "+name);
	}
}
