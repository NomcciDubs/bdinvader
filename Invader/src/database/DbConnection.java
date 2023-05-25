package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	Connection connection;
	public void connect(){
		String jdbcUrl = "jdbc:oracle:thin:@//localhost:1521/xe"; // URL de conexion de Oracle
        String username = "PROYECTOFINAL"; //Nombre de usuario
        String password = "123"; //Contrasenia del usuario

        try {
            // Cargar el controlador JDBC de Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establecer la conexion
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
	}
	public void close(){
        try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
