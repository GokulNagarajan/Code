import java.util.Scanner;
public class Problem14 {
	private static Scanner scan;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,pos,i;
		String id;
		scan=new Scanner(System.in);
		while(true)
		{
		try
		{
		System.out.println("Enter the number of Employees : ");
		n=scan.nextInt();
		if(n>0)
			break;
		else
			System.out.println("Enter the number of Employees greater than 0");
		}
		catch(Exception e)
		{
			System.out.println("Enter the valid number of Employees");
			scan.next();
		}
		}
		Employee [] employees=new Employee[n];
		getDetails(employees,n);
		System.out.println("--------------------------------------------------");
		displayRecords(employees,n);
		scan.nextLine();
		Binarysearchtree bst=new Binarysearchtree();
		for(i=0;i<n;i++)
			insert(employees[i],bst);
		System.out.println("--------------------------------------------------");
		System.out.println("Inorder traversal :");
		inorder(bst.root);
		System.out.println("--------------------------------------------------");
		System.out.println("Preorder traversal :");
		preorder(bst.root);
		System.out.println("--------------------------------------------------");
		System.out.println("Postorder traversal :");
		postorder(bst.root);
		System.out.println("--------------------------------------------------");
		System.out.println("Enter the Employee Id to be searched : ");
		id=scan.nextLine();
		pos=search(employees,n,id);
		if(pos>=0)
		{
			System.out.println("Employee Id present in record : ");
			printRecord(employees,pos);	
		}
		else
			System.out.println("Employee Id not present in record");
		
	}
	public static void getDetails(Employee [] employees,int n)
	{
		int i;
		System.out.println("Enter the Employee details ");
		for(i=0;i<n;i++)
		{
			employees[i]=new Employee();
			getData(employees[i]);
		}
	}	
	public static void getData(Employee emp)
	{
		scan.nextLine();
		System.out.println("Enter the Id : ");
		emp.employeeId=scan.nextLine();
		System.out.println("Enter the Name : ");
		emp.employeeName=scan.nextLine();
		while(true)
		{
		try
		{
			System.out.println("Enter the Age : ");
			emp.age=scan.nextInt();
			if(emp.age>0)
				break;
			else
				System.out.println("Enter the age greater than 0");
		}
		catch(Exception e)
		{
			System.out.println("Enter the valid age for Employees");
			scan.next();
		}
		}
		while(true)
		{
		try
		{
			System.out.println("Enter the Salary : ");
			emp.salary=scan.nextDouble();
			if(emp.salary>0)
				break;
			else
				System.out.println("Enter the salary greater than 0");
		}
		catch(Exception e)
		{
			System.out.println("Enter the valid salary for Employees");
			scan.next();
		}
		}
	}
	public static void setEmployee(Employee e,String Eid,String Ename,int age,double sal)
	{
		e.employeeId=Eid;
		e.employeeName=Ename;
		e.age=age;
		e.salary=sal;
	}
	public static void displayEmployee(Employee E)
	{
		System.out.println(E.employeeId+" \t\t"+E.employeeName+" \t"+E.age+" \t"+E.salary);
	}
	public static void displayRecords(Employee[] er,int n)
	{
		int i;
		System.out.println("EmployeeeId\t Name \t Age \t Salary");
		for(i=0;i<n;i++)
			displayEmployee(er[i]);		
	}
	public static int search(Employee[] er,int n,String id)
	{
		int i,j;
		for(i=0,j=n-1;i<n/2;i++,j--)
		{
			if(er[i].employeeId.equals(id))
				return i;
			else if(er[j].employeeId.equals(id))
				return j;
		}
		if(er[j].employeeId.equals(id))
			return i;
		return -1;
	}
	public static void printRecord(Employee[] er,int pos)
	{
		System.out.println("EmployeeeId\tName\tAge\tSalary");
		displayEmployee(er[pos]);
	}
	public static Node nodeInsert(Employee emp,Node root)
	{
		if(root==null)
		{
			root=new Node(emp);
			return root;
		}
		if(root.age>emp.age)
			root.left=nodeInsert(emp,root.left);
		else
			root.right=nodeInsert(emp,root.right);
		return root;
	}
	public static void insert(Employee emp,Binarysearchtree bst)
	{
		bst.root=nodeInsert(emp,bst.root);
	}
	public static void inorder(Node root)
	{
		if(root!=null)
		{
			inorder(root.left);
			System.out.println(root.id+" \t"+root.name+" \t"+root.age+" \t"+root.salary);
			inorder(root.right);
		}
	}
	public static void preorder(Node root)
	{
		if(root!=null)
		{
			System.out.println(root.id+" \t"+root.name+" \t"+root.age+" \t"+root.salary);
			preorder(root.left);
			preorder(root.right);
		}
	}
	public static void postorder(Node root)
	{
		if(root!=null)
		{
			postorder(root.left);
			postorder(root.right);
			System.out.println(root.id+" \t"+root.name+" \t"+root.age+" \t"+root.salary);
		}
	}
}
