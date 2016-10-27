import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.PreparedStatement;

public class StoredProcedure {
	private static Scanner scan = new Scanner(System.in);
	static Statement stmt =null;
	static PreparedStatement pstmt =null;
	static CallableStatement cstmt =null;
	static ResultSet rs=null;
	static String sql=null;
	static Connection con=null;
	public static void main(String[] args){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/account",
							"root", "Welcome123");
			System.out.println("Connecting the database");
			stmt= con.createStatement();
			int account1 = 0, account2 = 0;
			double amount = 0;
			sql = "CALL ViewAccounts()";
			System.out.println("\nAccount details");
			System.out.println("-----------------------------------------------------------\n");
			rs = stmt.executeQuery(sql);
			while (rs.next())
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t"
						+ rs.getDouble(3));
			System.out.println("-----------------------------------------------------------\n");
			while (true) {
				try {
					System.out.println("Enter the Sender account number");
					account1 = scan.nextInt();
					if (account1 > 0) {
						while (true) {
							try {
								System.out
										.println("Enter the Receiver account number");
								account2 = scan.nextInt();
								if (account2 > 0) {
									while (true) {
										try {
											System.out
													.println("Enter the amount to be transferred");
											amount = scan.nextDouble();
											if (amount > 0)
												break;
											else
												System.out
														.println("Enter correct account number");
										} catch (Exception e) {
											System.out
													.println("Enter valid account number");
											scan.next();
										}
									}
									break;
								} else
									System.out
											.println("Enter correct account number");
							} catch (Exception e) {
								System.out
										.println("Enter valid account number");
								scan.next();
							}
						}
						break;
					} else
						System.out.println("Enter correct account number");
				} catch (Exception e) {
					System.out.println("Enter valid account number");
					scan.next();
				}
				 /*finally {
					 if (stmt != null) {
							stmt.close();
						}
					 if (pstmt != null) {
							pstmt.close();
						}
					 if (cstmt != null) {
							cstmt.close();
						}
						if (con != null) {
							con.close();
						}

					}*/
			}

			System.out.println("Prepared Insert");
			//insert();
			System.out.println("Callable view");
			view();
			System.out.println("\nTransferring Funds");
			System.out.println("-----------------------------------------------------------\n");
			simpleStatement(account1,account2,amount);
			preparedStatement();
			callableStatement();
			System.out.println("-----------------------------------------------------------\n");
			System.out.println("\nAccount details after transfer");
			System.out.println("-----------------------------------------------------------\n");
			sql = "CALL ViewAccounts()";
			rs = stmt.executeQuery(sql);
			while (rs.next())
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t"
						+ rs.getDouble(3));
			System.out.println("-----------------------------------------------------------\n");
			System.out.println("Closing the database");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void view() {
		System.out.println("Callable statement");
		try {
			cstmt=(CallableStatement) con.prepareCall("call viewbalance"+"(?,?)");
			//cstmt=(CallableStatement) con.prepareCall(" ? = call getbalance"+"(?)");
			int accno=1001;
			cstmt.setInt(1, accno);
			cstmt.registerOutParameter(2, java.sql.Types.DOUBLE);
			//cstmt.registerOutParameter(1, java.sql.Types.DOUBLE);
			//cstmt.setInt(2, accno);
			cstmt.executeUpdate();
			//System.out.println("Balance is : "+cstmt.getDouble(1));
			System.out.println("Balance is : "+cstmt.getDouble(2));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void insert() {
		System.out.println("Prepared statement");
		try {
			pstmt=(PreparedStatement) con.prepareStatement("insert into account_table"
							+" (acc_no,acc_owner,balance) "+"VALUES(?,?,?)");
			pstmt.setInt(1, 1011);
			pstmt.setString(2,"Raja");
			pstmt.setDouble(3, 20000);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void simpleStatement(int account1, int account2, double amount)
	{
		System.out.println("Simple statement");
		sql = "call transferfunds(" + account1 + "," + account2 + ","
				+ amount + ")";
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next())
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t"
						+ rs.getDouble(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	public static void preparedStatement()
	{
		System.out.println("Prepared statement");
		try {
			pstmt=(PreparedStatement) con.prepareStatement("call transferfunds "+"(?,?,?)");
			pstmt.setInt(1, 1008);
			pstmt.setInt(2, 1007);
			pstmt.setDouble(3, 2000);
			rs=pstmt.executeQuery();
			while (rs.next())
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t"
						+ rs.getDouble(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
	}
	public static void callableStatement()
	{
		System.out.println("Callable statement");
		try {
			cstmt=(CallableStatement) con.prepareCall("call transferfunds "+"(?,?,?)");
			cstmt.setInt(1, 1006);
			cstmt.setInt(2, 1005);
			cstmt.setDouble(3, 3000);
			cstmt.execute();
			rs=stmt.executeQuery("Select * from account_table where acc_no =1005 or acc_no=1006");
			while (rs.next())
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t"
						+ rs.getDouble(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
			}
}
