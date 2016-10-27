
public class MethodInner {
	static int num=10;
	private int count=5;
	public class InnerMethodInner
	{
		void display()
		{
			System.out.println("member inner class static data"+num);
			System.out.println("member inner class non static data"+count);
		}
	}
}
