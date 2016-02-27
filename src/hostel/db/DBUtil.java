package hostel.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static String dbURL = "jdbc:derby://localhost:1527/hosteldb;user=derbyuser;password=derbyuser;create=false;";
	private static Connection conn = null;
	private static Statement stmt = null;

	public static ResultSet executeSelectQuery(String query) throws SQLException{
		ResultSet result = null;
		try{
			createConnection();
			stmt = conn.createStatement();
			result = stmt.executeQuery(query);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	private static void createConnection(){
		try
		{
			Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
			conn = DriverManager.getConnection(dbURL); 
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
