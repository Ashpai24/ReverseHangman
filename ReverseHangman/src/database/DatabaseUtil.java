package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseUtil {

	public final static String rdsMySQLdbURL = "reversehangmandb.czkvc5lxxvn2.us-east-2.rds.amazonaws.com";
	public final static String dbUsername = "AshPai2401";
	public final static String dbPassword = "Welcome2401";
	
	public final static String jdbcTag = "jdbc:mysql://";
	public final static String dbPort = "3306";
	public final static String allowMultiQueries = "?allowMultiQueries=true";
	
	public final static String dbName = "ReverseHangman";
	
	static Connection connection;
	
	protected static Connection connect() throws Exception{
		if(connection != null) {
			return connection;
		}
		
		System.out.println("Starting connection...");
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(jdbcTag+rdsMySQLdbURL + ":" + dbPort + "/" + dbName + allowMultiQueries, 
				dbUsername, dbPassword);
		System.out.println("Connected to ReverseHangman DB");
		return connection;
	}
}
