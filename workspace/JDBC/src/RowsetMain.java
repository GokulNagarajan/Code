import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import com.mindtree.dbutils.Dbutils;


public class RowsetMain {
	final static String URL="jdbc:mysql://localhost:3306/rowset";
	final static String USER="root";
	final static String PASS="Welcome123";
	static Connection conn=null;
	static JdbcRowSet rowSet =null;
	
	public static void main(String[] args)  {
		try {
			conn=Dbutils.getCon();
		    rowSet = RowSetProvider.newFactory().createJdbcRowSet();  
		    rowSet.setUrl(URL);
		    rowSet.setUsername(USER);
		    rowSet.setPassword(PASS);
		    rowSet.setCommand("SELECT * FROM user");
			System.out.println("Before Update");
			conn.setAutoCommit(false);
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
			conn.setAutoCommit(true);
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
		rowSet.first();
		rowSet.moveToInsertRow();
		rowSet.updateInt(1, 8);
		rowSet.updateString(2, "Ram");
		rowSet.updateInt(3, 22);
		rowSet.updateDouble(4, 15000);
		rowSet.insertRow();
		rowSet.moveToCurrentRow();
		conn.setAutoCommit(true);
	}
	private static void update() throws SQLException {
		conn.setAutoCommit(false);
		rowSet.first();
		rowSet.updateInt(1, 1);
		rowSet.updateString(2, "Gokul");
		rowSet.updateInt(3, 21);
		rowSet.updateDouble(4, 20000);
		rowSet.updateRow();
		conn.setAutoCommit(true);
	}
	private static void delete() throws SQLException {
		conn.setAutoCommit(false);
		rowSet.first();
		while(rowSet.next())
		{
			if(rowSet.getInt(1)==9)
				rowSet.deleteRow();
		}
		conn.setAutoCommit(true);
	}
	public static void execute() throws SQLException
	{
		rowSet.execute();
		while(rowSet.next())
		{
			System.out.println(rowSet.getInt(1)+"\t"+rowSet.getString(2)+"\t"+rowSet.getInt(3)+"\t"+rowSet.getDouble(4));
		}
		
	}
}