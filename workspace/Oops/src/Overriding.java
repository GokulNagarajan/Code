
public class Overriding {

	public static void main(String[] args) {
		System.out.println("Base object");
		Base1 b=new Base1();
		b.display();
		//System.out.println(b.fun());
		b.print();
		//b.show();
		System.out.println("Derived object");
		Derived1 d=new Derived1();
		d.display();
		//System.out.println(d.fun());
		d.print();
		d.show();
		System.out.println("Overriding Base object");
		//upcasting
		b=d;
		//System.out.println(b.fun());
		b.display();
		b.print();
		//b.show();
		System.out.println("covariant type");
		Base1 b1=b.fun();
		b1.display();
		//System.out.println(b1.fun());
		b1.print();
		//b1.show();
	}

}
