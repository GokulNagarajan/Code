
public class Student extends Person
	{
		double percentage;
		public Student()
		{
			super();
			percentage=0;
		}
		public Student(String name,double percentage)
		{
			super(name);
			this.percentage=percentage;
		}
		public void display()
		{		
			System.out.println("Student Name \t\tPercentage");
			System.out.println(name+"\t\t\t"+percentage);
		}
		public boolean isOutstanding()
		{
			if(percentage>85)
				return true;
			return false;
		}
	}