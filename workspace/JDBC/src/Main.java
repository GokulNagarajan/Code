import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import com.mindtree.dbutils.Dbutils;
import com.sun.rowset.CachedRowSetImpl;


public class Main {
	final static String URL="jdbc:mysql://localhost:3306/cachedrowset";
	final static String USER="root";
	final static String PASS="Welcome123";
	static Connection conn=null;
	static CachedRowSet crs=null;
	
	public static void main(String[] args)  {
		try {
			conn=Dbutils.getCon();
			crs=new CachedRowSetImpl();
			crs.setUrl(URL);
			crs.setUsername(USER);
			crs.setPassword(PASS);
			crs.setCommand("SELECT * FROM user");
			System.out.println("Before Update");
			execute();
			update();
			System.out.println("After Update");
			execute();
			insert();
			System.out.println("After Insert");
			execute();
			delete();
			System.out.println("After Delete");
			execute();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	private static void insert() throws SQLException {
		conn.setAutoCommit(false);
		crs.first();
		crs.moveToInsertRow();
		crs.updateInt(1, 5);
		crs.updateString(2, "Arjun");
		crs.updateInt(3, 25);
		crs.updateDouble(4, 25000);
		crs.insertRow();
		crs.moveToCurrentRow();
		crs.acceptChanges(conn);
		conn.setAutoCommit(true);
	}
	private static void update() throws SQLException {
		conn.setAutoCommit(false);
		crs.first();
		crs.updateInt(1, 1);
		crs.updateString(2, "Gokul");
		crs.updateInt(3, 21);
		crs.updateDouble(4, 20000);
		crs.updateRow();
		crs.acceptChanges(conn);
		conn.setAutoCommit(true);
	}
	private static void delete() throws SQLException {
		conn.setAutoCommit(false);
		crs.first();
		while(crs.next())
		{
			if(crs.getInt(1)==5)
				crs.deleteRow();
		}
		crs.acceptChanges(conn);
		conn.setAutoCommit(true);
	}
	public static void execute() throws SQLException
	{
		crs.execute(conn);
		while(crs.next())
		{
			System.out.println(crs.getInt(1)+"\t"+crs.getString(2)+"\t"+crs.getInt(3)+"\t"+crs.getDouble(4));
		}
		
	}
}
