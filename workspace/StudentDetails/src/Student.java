public class Student {
	String studentId;
	String studentName;
	Double total,percentage;
	Subject [] subject;
	public Student(int s)
	{
		studentId="";
		studentName="";
		total=0.0;
		percentage=0.0;
		subject =new Subject[s];
		for(int i=0;i<s;i++)
			subject[i]=new Subject();
	}
}
