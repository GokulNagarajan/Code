import java.util.ArrayList;


public class ParentChild {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Parent> p=new ArrayList<Parent>();
		ArrayList<Child> c=new ArrayList<Child>();
		ArrayList<Child1> c1=new ArrayList<Child1>();
		
		int i;
		p.add(new Child1("raam"));
		p.add(new Child("jegan"));
		p.add(new Child1("mahesh"));
		p.add(new Child("gokul"));
		p.add(new Child1("shyamm"));
		p.add(new Child1("dinesh"));
		p.add(new Child("mohan"));
		p.add(new Child("raja"));
		
		System.out.println("parent list");
		for(i=0;i<p.size();i++)
		{
			p.get(i).fun();
			if(p.get(i) instanceof Child)
				c.add((Child) p.get(i));
			if(p.get(i) instanceof Child1)
				c1.add((Child1) p.get(i));
		}
		System.out.println("child list");
		for(i=0;i<c.size();i++)
			c.get(i).fun();
		System.out.println("child1 list");
		for(i=0;i<c1.size();i++)
			c1.get(i).fun();
		
	}

}
