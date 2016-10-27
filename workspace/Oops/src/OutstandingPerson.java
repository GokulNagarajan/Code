import java.util.Scanner;

public class OutstandingPerson {
	private static Scanner scan;
	final static int N=5;
	public static void main(String[] args) {
		scan=new Scanner(System.in);
		Person[] persons=new Person[5];
		int i,booksPublished = 0,k=0;
		String name = "";
		double percentage = 0;
		for(i=0;i<N-2;i++)
		{
			if(i!=0)
				scan.nextLine();
			System.out.println("Enter Student Name");
			name=scan.nextLine();
			while(true)
			{
			try
			{
			System.out.println("Enter Student Average");
			percentage=scan.nextDouble();
			if(percentage>=0&&percentage<=100)
				break;
			else
			{
				System.out.println("Enter Student Average between 0 to 100");
			}
			}
			catch(Exception e)
			{
				System.out.println("Enter valid Student Average");
				scan.next();
			}
			}
			persons[k]=new Student(name,percentage);
			k++;
		}
		for(i=0;i<2;i++)
		{
			scan.nextLine();
			System.out.println("Enter Professor Name");
			name=scan.nextLine();
			while(true)
			{
			try
			{
			System.out.println("Enter number of Books Published");
			booksPublished=scan.nextInt();
			if(booksPublished>=0)
				break;
			else
			{
				System.out.println("Enter number of Books Published greater than or equal to zero");
			}
			}
			catch(Exception e)
			{
				System.out.println("Enter valid number of Books Published");
				scan.next();
			}
			}
			persons[k]=new Professor(name,booksPublished);
			k++;
		}
		System.out.println("\nOutstanding Person Details");
		System.out.println();
		for(i=0;i<N;i++)
		{
			if(persons[i].isOutstanding())
			{
				persons[i].display();	
				persons[i].print();	
			}	
		}
		/*
		 * Student student[]=new Student[3];
		 * Professor professor[]=new Professor[2]
		 * for(i=0;i<N-2;i++)
		 * student[i]=(Student)
		 */
	}
}
