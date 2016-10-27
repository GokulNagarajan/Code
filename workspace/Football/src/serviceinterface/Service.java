package serviceinterface;

import java.sql.SQLException;
import java.sql.Statement;

public interface Service {
	void getDetails(Statement stmt) throws SQLException;
	void displayDetails(Statement stmt) throws SQLException;
}
