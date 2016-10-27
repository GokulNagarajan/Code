import java.util.HashSet;
import java.util.Set;


public class MergeClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> s1=new HashSet<String>();
		s1.add("Ram");
		s1.add("Bala");
		s1.add("Gopal");
		s1.add("Sundar");
		s1.add("Aswin");
		s1.add("Mahesh");
		s1.add("Ram");
		s1.add("Aswin");
		System.out.println("Set 1");
		for(String s:s1)
			System.out.println(s);
		Set<String> s2=new HashSet<String>();
		s2.add("Amit");
		s2.add("Bala");
		s2.add("Mahesh");
		s2.add("Raj");
		s2.add("Bala");
		s2.add("Amit");
		System.out.println("\nSet 2");
		for(String s:s2)
			System.out.println(s);
		System.out.println("\nSet 3 before RetainAll");
		Set<String> s3=new HashSet<String>();
		s3.addAll(s1);
		for(String s:s3)
			System.out.println(s);
		s3.retainAll(s2);
		System.out.println("\nSet 3 after RetainAll");
		for(String s:s2)
			System.out.println(s);
		System.out.println("\nSet 4 before RemoveAll");
		Set<String> s4=new HashSet<String>();
		s4.addAll(s1);
		for(String s:s4)
			System.out.println(s);
		s4.removeAll(s2);
		System.out.println("\nSet 4 after RemoveAll");
		for(String s:s4)
			System.out.println(s);		
	}

}
