
public class LocalInner {
	static int num=10;
	private int count=5;
	public void display()
	{
		class InnerLocalInner
		{
			void display()
			{
			System.out.println("local class static data"+num);
			System.out.println("local class non static data"+count);
			}
		}
		InnerLocalInner i=new InnerLocalInner();
		i.display();
	}
}
