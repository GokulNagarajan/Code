
public class Child extends Parent{
	Child(String name)
	{
		super(name);
	}
	@Override
	void fun()
	{
		System.out.println("Child name : "+name);
	}
}
