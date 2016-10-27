
public class StaticInner {
	static int num=10;
	int count=5;
	static class InnerStaticInner
	{
		void display()
		{
			System.out.println("static class static data"+num);
			//System.out.println(count);
		}
	}

}
