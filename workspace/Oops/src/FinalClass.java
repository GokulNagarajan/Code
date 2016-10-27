
public class FinalClass {
	final static int VALUE=1;
	final static int COUNT=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FinalDerived fd=new FinalDerived();
		fd.display();
		//VALUE=0;
		System.out.println("Value : "+VALUE);
		//COUNT=1;
		System.out.println("Count : "+COUNT);
	}

}
final class FinalBase
{
	public FinalBase() {
		// TODO Auto-generated constructor stub
	}
	public final void display()
	{
		System.out.println("Inside Final Base");
	}
}
final class FinalDerived 
//extends FinalBase
{
	public FinalDerived() {
		// TODO Auto-generated constructor stub
	}
	public final void display()
	{
		//super.display();
		System.out.println("Inside Final Derived");
	}
}
