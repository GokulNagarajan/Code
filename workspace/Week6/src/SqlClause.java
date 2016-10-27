import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class SqlClause {

	public static void main(String[] args) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","Welcome123");  
			System.out.println("Connecting the database");
			Statement stmt=con.createStatement();
			String space="";
			String sql="select department_id,sum(salary)"+" from employee"+" group by department_id";
			System.out.println("\nSelecting Sum of salary paid in each Department");
			ResultSet rs=stmt.executeQuery(sql);
			System.out.println("------------------------------------------------------------------------------------------------");
			System.out.println("Department Id\tSum(Salary)");
			System.out.println("------------------------------------------------------------------------------------------------");
			while(rs.next())
			{
				for(int i=0;i<(15-rs.getString(1).length());i++)
					space+=" ";
				System.out.println(rs.getInt(1)+space+rs.getInt(2));
				space="";
			}
			System.out.println("------------------------------------------------------------------------------------------------");
			System.out.println("\nSelecting number of employees in each Department");
			sql="select department_id,count(*)"+" from employee"+" group by department_id";
			rs=stmt.executeQuery(sql);
			System.out.println("------------------------------------------------------------------------------------------------");
			System.out.println("Department Id\tNumber Of Employees");
			System.out.println("------------------------------------------------------------------------------------------------");
			while(rs.next())
			{
				for(int i=0;i<(15-rs.getString(1).length());i++)
					space+=" ";
				System.out.println(rs.getInt(1)+space+rs.getInt(2));
				space="";
			}
			System.out.println("------------------------------------------------------------------------------------------------");
			System.out.println("\nSelecting Sum of salary paid in Department Id 50");
			sql="select department_id,sum(salary)"+" from employee"+" where department_id ='50'";
			rs=stmt.executeQuery(sql);
			System.out.println("------------------------------------------------------------------------------------------------");
			System.out.println("Department Id\tSum(Salary)");
			System.out.println("------------------------------------------------------------------------------------------------");
			while(rs.next())
			{
				for(int i=0;i<(15-rs.getString(1).length());i++)
					space+=" ";
				System.out.println(rs.getInt(1)+space+rs.getInt(2));
				space="";
			}
			System.out.println("------------------------------------------------------------------------------------------------");
			System.out.println("\nSelecting number of employees in each Department having atleast 2 employees");
			sql="select department_id,count(*)"+" from employee"+" group by department_id"+" having count(*)>=2";
			rs=stmt.executeQuery(sql);
			System.out.println("------------------------------------------------------------------------------------------------");
			System.out.println("Department Id\tNumber Of Employees");
			System.out.println("------------------------------------------------------------------------------------------------");
			while(rs.next())
			{
				for(int i=0;i<(15-rs.getString(1).length());i++)
					space+=" ";
				System.out.println(rs.getInt(1)+space+rs.getInt(2));
				space="";
			}
			System.out.println("------------------------------------------------------------------------------------------------");
			System.out.println("\nClosing the database");
			con.close();  
		}
		catch(Exception e)
		{ System.out.println(e);}  
	}
}
