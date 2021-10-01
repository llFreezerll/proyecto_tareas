package Model;

import java.sql.*;

public class Conexion {
	
	private static final String database="jdbc:mysql://localhost:3306/Abaco";
	private static final String username="root";
	private static final String pass="";
	private static Connection con;
	
	public static Connection conectar() {
		
		try {
			con=DriverManager.getConnection(database, username, pass);
		}catch(Exception e){
			System.out.println("Error en la conexcion "+e.getMessage());
		}
		
		return con;
	}

}
