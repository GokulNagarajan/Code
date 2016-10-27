import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Exception.DaoException;

import com.mindtree.entity.User;
import com.mindtree.service.UserDao;


public class UserMain implements UserDao{
	private static Statement stmt;
	private ResultSet rs;
	private String sql;
	public static void main(String[] args) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","Welcome123");  
			System.out.println("Connecting the database");
			System.out.println();
			stmt=con.createStatement();
			UserMain usermain=new UserMain();
			User user=new User("gokul","gokuln1607raja@gmail.com",22,"gokul");
			//usermain.addUser(user);
			usermain.addUser(user);
			usermain.getUser("gokul","gokul");
			usermain.getUser("gokul","gokul1");
			
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void getUser(String userName, String password) throws DaoException {
		// TODO Auto-generated method stub
		sql="SELECT COUNT(*) FROM USER WHERE USERNAME LIKE '"+userName+"' and PASSWORD LIKE '"+password+"'";
		try {
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				if(rs.getInt(1)>0)
					System.out.println("Valid User access credentials");
				else
					throw new DaoException("Invalid User access credentials");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println(e.toString());
			throw new DaoException("Connection Problem");	
		}
	}

	public void addUser(User user) throws DaoException {
		// TODO Auto-generated method stub
		sql="SELECT COUNT(*) FROM USER WHERE USERNAME LIKE '"+user.username+"' and PASSWORD LIKE '"+user.password+"'";
		try {
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				if(rs.getInt(1)<1)
				{
					sql="INSERT INTO USER (email,username,age,password) VALUES ('"+user.email+"','"+user.username+"','"+user.age+"','"+user.password+"')";
					stmt.executeUpdate(sql);
					System.out.println("New User data added");
				}
				else
				throw new DaoException("User already exists");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println(e.toString());
			throw new DaoException("Connection Problem");	
		}
	}
	
}
