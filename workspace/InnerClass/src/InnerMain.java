
public class InnerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticInner.InnerStaticInner sis=new StaticInner.InnerStaticInner();
		sis.display();
		AnonymusInner a=new AnonymusInner() {
			
			@Override
			void display() {
				// TODO Auto-generated method stub
				System.out.println("Anonymous class");
			}
		};
		a.display();
		MethodInner m=new MethodInner();
		MethodInner.InnerMethodInner mi=m.new InnerMethodInner();
		mi.display();
		LocalInner l=new LocalInner();
		l.display();
	}

}
