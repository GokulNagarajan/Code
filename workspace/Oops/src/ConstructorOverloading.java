
public class ConstructorOverloading {
	public ConstructorOverloading()
	{
		System.out.println("Construct without parameter");
	}
	public ConstructorOverloading(int i)
	{
		System.out.println("Construct with int parameter & value "+i);
	}
	public ConstructorOverloading(double i)
	{
		System.out.println("Construct with double parameter & value "+i);
	}
	public ConstructorOverloading(int i,double j)
	{
		System.out.println("Construct with int & double parameter & int value "+i+" double value "+j);
	}
	public ConstructorOverloading(double i,int j)
	{
		System.out.println("Construct with double & int parameter & double value "+i+" int value "+j);
	}
	public ConstructorOverloading(int i,int j)
	{
		System.out.println("Construct with two int parameters & values "+i+" "+j);
	}
	public ConstructorOverloading(double i,double j)
	{
		System.out.println("Construct with two double parameters & values "+i+" "+j);
	}
	
	
	
}
