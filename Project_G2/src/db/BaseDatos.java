package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDatos {
	private static final String JDBC_URL = "jdbc:sqlite:./data/sample.db";
	
	public static void createTable() {
		try (Connection connection = DriverManager.getConnection(JDBC_URL);
				Statement statement = connection.createStatement()) {
			
			String createTableSQL = "CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY, nombre TEXT)";
			statement.execute(createTableSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
	
	

