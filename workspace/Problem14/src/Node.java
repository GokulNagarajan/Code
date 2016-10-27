
public class Node {
	int age;
	String id;
	String name;
	double salary;
	Node left;
	Node right;
	public Node(Employee emp)
	{
		this.age=emp.age;
		this.id=emp.employeeId;
		this.name=emp.employeeName;
		this.salary=emp.salary;
		this.left=null;
		this.right=null;
	}
}
