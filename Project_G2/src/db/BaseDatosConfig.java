package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDatosConfig {
	private static final String JDBC_URL = "jdbc:sqlite:./data/hermes.db";
	
	public static void createTable() {
		try (Connection connection = DriverManager.getConnection(JDBC_URL);
				Statement statement = connection.createStatement()) {
			
			String createTableSQL = "CREATE TABLE IF NOT EXISTS paquetes ("+
									"id INT PRIMARY KEY, " +
									"id_envio TEXT, " +
									"remitente TEXT, " + 
									"contenido TEXT, " +
									"estado_entrega TEXT)";
			statement.execute(createTableSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
	
	