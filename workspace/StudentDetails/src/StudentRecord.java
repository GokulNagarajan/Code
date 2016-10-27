import java.util.Scanner;



public class StudentRecord {
	Student [] student;
	int n,s;
	int [] topperId=new int[10];
	double [] totalMark=new double[10];
	Scanner scan=new Scanner(System.in);
	public StudentRecord(int n,int s)
	{
		this.n=n;
		this.s=s;
		student=new Student[s];
	}
}
