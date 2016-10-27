import java.util.Scanner;
public class StudentDetailsMain {
	private static Scanner scan;
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			scan=new Scanner(System.in);
			int n,s;
			StudentRecord record;
			String id;
			do
			{
			try
			{
			System.out.println("Enter the number of Students :");
			n=scan.nextInt();
			if(n>0)
			{
			System.out.println("Enter the number of Subjects : ");
			s=scan.nextInt();		
			if(s>0)
			{	
				record=new StudentRecord(n,s);
				System.out.println();
				break;
			}
			else
				System.out.println("Enter number Subjects greater than 0");
			}
			else
				System.out.println("Enter number of Students greater than 0");
			}
			catch(Exception e)
			{
				System.out.println("Enter valid input");
				scan.next();
			}
			}while(true);
			getDetails(record,n,s);
			displayInorder(record,n,s);
			System.out.println();
			displayClassAverage(record,n,s);
			displaySort(record,n,s);
			displayTop3(record,n,s);
			displayMarklist(record,n,s);
			System.out.println("Enter the Student Id to get marksheet");
			scan.nextLine();
			id=scan.nextLine();
			displayMarksheet(record,n,s, id);
			displayBubbleSort(record,n,s);
			displayquickSort(record,n,s);			
		}
		public static void getDetails(StudentRecord record,int n,int s)
		{
			for(int i=0;i<n;i++)
			{
				record.student[i]=new Student(s);
				getData(record.student[i],s);
			}
		}
		public static void displayInorder(StudentRecord record,int n,int s)
		{
			System.out.println("Records in the order of insertion");
			System.out.print("  studentId   \tstudentName");
			for(int i=0;i<s;i++)
				System.out.print("   \tSubject "+(i+1));
			System.out.print("\ttotal   \tpercentage");
			System.out.println();
			
			for(int i=0;i<n;i++)
			{
				displayData(record.student[i],s);
				System.out.println();
			}
		}
		public static void displayClassAverage(StudentRecord record,int n,int s)
		{
			double total_avg=0.0;
			double [] Subject_avg=new double[s];
			for(int i=0;i<s;i++)
				Subject_avg[i]=0.0;
			for(int j=0;j<s;j++)
			{
				for(int i=0;i<n;i++)
				{
					Subject_avg[j]=Subject_avg[j]+record.student[i].subject[j].marks;
				}
			}
			for(int i=0;i<s;i++)
			{
				Subject_avg[i]=Subject_avg[i]/s;
				total_avg=total_avg+Subject_avg[i];
				System.out.println("Class Average in Subject "+(i+1)+" : "+Subject_avg[i]);
			}
			total_avg=total_avg/s;
			System.out.println();
			System.out.println("Class Average in total     :"+total_avg);
			System.out.println();
		}
		public static void displaySort(StudentRecord record,int n,int s)
		{
			int i,j,id;
			double value;
			for(i=0;i<n;i++)
			{
				record.topperId[i]=i;
				record.totalMark[i]=record.student[i].total;
			}
			for(i=1;i<n;i++)
			{
				j=i;
				value=record.totalMark[i];
				id=record.topperId[i];
				for(;j>0&&record.totalMark[j-1]<value;j--)
				{
					record.topperId[j]=record.topperId[j-1];
					record.totalMark[j]=record.totalMark[j-1];
				}
				record.totalMark[j]=value;
				record.topperId[j]=id;
			}
			System.out.println("Student details in sorted order");
			System.out.print("  studentId   \tstudentName");
			for( i=0;i<s;i++)
				System.out.print("   \tSubject "+(i+1));
			System.out.print("\ttotal   \tpercentage");
			System.out.println();
			for(i=0;i<n;i++)
			{
				displayData(record.student[record.topperId[i]],s);
				System.out.println();
			}
			System.out.println();
		}
		public static void displayBubbleSort(StudentRecord record,int n,int s)
		{
			int i,j,temp;
			double totaltemp;
			for(i=0;i<n;i++)
			{
				record.topperId[i]=i;
				record.totalMark[i]=record.student[i].total;
			}
			  for(i=0;i<n-1;i++)
			{
				for(j=i+1;j<n;j++)
				{
					if(record.totalMark[j]>record.totalMark[i])
					{
					temp=record.topperId[i];
					record.topperId[i]=record.topperId[j];
					record.topperId[j]=temp;
					totaltemp=record.totalMark[i];
					record.totalMark[i]=record.totalMark[j];
					record.totalMark[j]=totaltemp;
					}
				}
				
			}
			System.out.println("Student details in bubble sorted order");
			System.out.print("  studentId   \tstudentName");
			for( i=0;i<s;i++)
				System.out.print("   \tSubject "+(i+1));
			System.out.print("\ttotal   \tpercentage");
			System.out.println();
			for(i=0;i<n;i++)
			{
				displayData(record.student[record.topperId[i]],s);
				System.out.println();
			}
			System.out.println();
		}
		public static int partition(int arr[],double tot[],int low,int high)
		{
			int i=low-1,j,temp;
			double pivot=tot[high];
			double totaltemp;
			for(j=low;j<high;j++)
			{
				if(tot[j]>pivot)
				{
					i=i+1;
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
					totaltemp=tot[i];
					tot[i]=tot[j];
					tot[j]=totaltemp;
				}
			}
			temp=arr[i+1];
			arr[i+1]=arr[high];
			arr[high]=temp;
			totaltemp=tot[i+1];
			tot[i+1]=tot[high];
			tot[high]=totaltemp;
			return i+1;
		}
		public static void quicksort(int arr[],double tot[],int low,int high)
		{
			if(low<high)
			{
			int part=partition(arr,tot,low,high);
			quicksort(arr,tot,low,part-1);
			quicksort(arr,tot,part+1,high);
			}
		}
		public static void displayquickSort(StudentRecord record,int n,int s)
		{
			int i;
			for(i=0;i<n;i++)
			{
				record.topperId[i]=i;
				record.totalMark[i]=record.student[i].total;
			}
			quicksort(record.topperId,record.totalMark,0,n);
			System.out.println("Student details in quick sorted order");
			System.out.print("  studentId   \tstudentName");
			for( i=0;i<s;i++)
				System.out.print("   \tSubject "+(i+1));
			System.out.print("\ttotal   \tpercentage");
			System.out.println();
			for(i=0;i<n;i++)
			{
				displayData(record.student[record.topperId[i]],s);
				System.out.println();
			}
			System.out.println();
		}
		public static void displayTop3(StudentRecord record,int n,int s)
		{
			int x=3,i,j,min,temp;
			double totaltemp;
			System.out.println();
			System.out.println("Top 3 Student details");
			System.out.print("  studentId   \tstudentName");
			for( i=0;i<s;i++)
				System.out.print("   \tSubject "+(i+1));
			System.out.print("\ttotal   \tpercentage");
			System.out.println();
			if(n<3)
				x=n;	
			for(i=0;i<n;i++)
			{
				record.topperId[i]=i;
				record.totalMark[i]=record.student[i].total;
			}
			for(i=0;i<x;i++)
			{
				min=i;
				for(j=i+1;j<n;j++)
				{
					if(record.totalMark[j]>record.totalMark[min])
						min=j;
				}
				if(min!=i)
				{
					temp=record.topperId[i];
					record.topperId[i]=record.topperId[min];
					record.topperId[min]=temp;
					totaltemp=record.totalMark[i];
					record.totalMark[i]=record.totalMark[min];
					record.totalMark[min]=totaltemp;
				}
				
			}
			for(i=0;i<x;i++)
			{
				displayData(record.student[record.topperId[i]],s);
				System.out.println();
			}
			System.out.println();
		}
		public static void displayMarklist(StudentRecord record,int n,int s)
		{
			System.out.println();
			System.out.println("Student Marklist");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
			System.out.print("  studentId   \tstudentName");
			for(int i=0;i<s;i++)
				System.out.print("   \tSubject "+(i+1));
			System.out.print("\ttotal   \tpercentage");
			System.out.println();
			
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
			System.out.println();
			for(int i=0;i<n;i++)
			{
				System.out.print("\t "+record.student[i].studentId);
				System.out.print("\t "+record.student[i].studentName);
				for(int j=0;j<s;j++)
					System.out.print("\t\t "+record.student[i].subject[j].marks);
				System.out.print("\t\t "+record.student[i].total);
				System.out.print("\t\t "+record.student[i].percentage);
				System.out.println();
			}
			System.out.println();
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
			System.out.println();
		}
		public static void displayMarksheet(StudentRecord record,int n,int s,String id)
		{
			System.out.println();
			int count=0;
			for(int i=0;i<n;i++)
				if(record.student[i].studentId.equals(id))
				{	
					count++;
					System.out.println("Student id present in record at position "+i);
				}
			if(count==0)
			{
				System.out.println("Student id not in record");
				return;
			}
			System.out.println("Student Marksheet");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
			System.out.println();
			for(int i=0;i<n;i++)
			{
				if(record.student[i].studentId.equals(id))
				{
					System.out.println("\t\t\t Student Id   : "+record.student[i].studentId);
					System.out.println("\t\t\t Student Name : "+record.student[i].studentName);
					for(int j=0;j<s;j++)
						System.out.println("\t\t\t Subject "+(j+1)+"    : "+record.student[i].subject[j].marks);
					System.out.println("\t\t\t total        : "+record.student[i].total);
					System.out.println("\t\t\t percentage   : "+record.student[i].percentage);
					System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
				}
			}
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
		}
		public static void getData(Student stu,int s)
		{
			int i;
			scan.nextLine();
			System.out.println("Enter student id : ");
			stu.studentId=scan.nextLine();
			System.out.println("Enter student name : ");
			stu.studentName=scan.nextLine();
			for(i=0;i<s;i++)
			{
				try
				{
				System.out.println("Enter student subject "+(i+1)+" mark : ");
				stu.subject[i].marks=scan.nextDouble();
				if(stu.subject[i].marks>=0&&stu.subject[i].marks<=100)
					stu.total=stu.total+stu.subject[i].marks;
				else 
					i--;
				}
				catch(Exception e)
				{
					System.out.println("Enter valid subject mark 0 to 100 ");
					i--;
					scan.next();
				}
			}
			stu.percentage=stu.total/s;
		}
		public static void displayData(Student stu,int s)
		{
			System.out.print("\t "+stu.studentId);
			System.out.print("\t "+stu.studentName);
			for(int i=0;i<s;i++)
				System.out.print("\t\t "+stu.subject[i].marks);
			System.out.print("\t\t "+stu.total);
			System.out.print("\t\t "+stu.percentage);
		}
}
