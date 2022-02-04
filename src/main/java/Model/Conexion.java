package Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	private static final String database="jdbc:mysql://localhost:3306/abaco";
	private static final String username="root";
	private static final String pass="";
	private static Connection con;
	
	public static Connection conectar() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(database, username, pass);
			System.out.println("Conexion Exitosa");
		}catch(Exception e){
			System.out.println("Error en la conexion "+e.getMessage());
		}
		
		return con;
	}

}
