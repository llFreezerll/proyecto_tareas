package Clases;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Model.Conexion;

public class Rol {
	
	private int idRol;
	private String nombreRol;
	String sql=null;
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
		
	Conexion C = new Conexion();
	int rows;
	
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	
	public int CrearRol(Rol Rol) throws SQLException {
		sql = "INSERT INTO roles(IdRol, NombreRol) VALUES (?)";
		
		try {
			
			con = C.conectar();
			ps = con.prepareStatement(sql);
			ps.executeUpdate(); 
			ps.close();	
			System.out.println("Se ejecuto la sentencia");
			
		}catch(Exception e) {
			System.out.println("Error "+e.getMessage());
		}
		finally {
		con.close();	
		}
		return rows;				
	}
	
	public void EliminarRol(int id) throws SQLException {
		sql = "DELETE FROM roles WHERE IdRol="+id;
		
		try {
			
			con = C.conectar();
			ps = con.prepareStatement(sql);
			ps.executeUpdate(); 
			ps.close();
			System.out.println("Se ejecuto la sentencia");
			
		}catch(Exception e){
			
			System.out.println("Error "+e.getMessage());
			
		}
		finally {
			con.close();	
		}
	}
	
	public Rol ConsultarRol(int id) throws SQLException {
		sql = "SELECT * FROM roles WHERE IdRol="+id;
		Rol r= new Rol();
		
		try {
			
			con = C.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); 
			
			while(rs.next()) {
				
				r.setIdRol(rs.getInt("IdRol"));
				r.setNombreRol(rs.getString("NombreRol"));
				System.out.println("Se ejecuto la sentencia");
			}
			
			ps.close();
			
		}catch(Exception e) {
			System.out.println("Error "+e.getMessage());
		}
		finally {
			con.close();
		}
		
		return r;
	}
	
	public List ListarRol() throws Exception {
		
		List<Rol> roles = new ArrayList<>();
		sql = "SELECT * FROM roles";
		try {
					
		con = C.conectar();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()){
			Rol r=new Rol();
			r.setIdRol(rs.getInt("IdRol"));
			r.setNombreRol(rs.getString("NombreRol"));
			roles.add(r);
			System.out.println("Se ejecuto la sentencia");
		}
		
		}catch (Exception e) {
			System.out.println("Error "+e.getMessage());
		}
		finally {
			con.close();
		}
		return roles;
		
		
	}

}
