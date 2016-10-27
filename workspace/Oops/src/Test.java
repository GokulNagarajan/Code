public class Test{  
 class Base{  
  void msg(){System.out.println("Base Class");}  
 	}  
 class Derive extends Base{
	 void msg(){System.out.println("Derived Class");}
 }
 class NewDerive extends Derive{
	 void msg(){System.out.println("New Derived Class");
	 return;}
 }
 public static void main(String args[]){  
  Test obj=new Test();  
  Test.Base b1,b2,b3;
  Test.Derive d1,d2,d3;
  Test.NewDerive nd1,nd2,nd3;
  System.out.println("\nBase Class Object");
  b1= obj.new Base();  
  b1.msg();  
  b2= obj.new Derive();  //upcasting derive
  b2.msg();  
  b3= obj.new NewDerive();  //upcasting newderive
  b3.msg();  
  System.out.println("\nDerived Class Object");
  d1=(Derive) b2;	//downcasting derive
  d1.msg();
  d2= obj.new Derive();  
  d2.msg();  
  d3= obj.new NewDerive();	//upcasting newderive 
  d3.msg();  
  System.out.println("\nNew Derived Class Object");
  nd1=(NewDerive)b3;	//downcasting newderive
  nd1.msg();
  nd2=(NewDerive)d3;	//downcasting newderive
  nd2.msg();
  nd3=obj.new NewDerive();
  nd3.msg();
 }  
}