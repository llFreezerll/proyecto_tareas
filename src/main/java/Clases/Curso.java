package Clases;

import Model.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Curso {
	
	private int idCurso;
	private String nombreCurso;
	private String grupo;
	String sql=null;

	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	Conexion C = new Conexion();
	int rows;


	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getNombreCurso() {
		return nombreCurso;
	}
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public List ListarCurso() throws Exception {

		List<Curso> Curso = new ArrayList<>();
		sql = "SELECT * FROM curso";
		try {

			con = C.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()){
				Curso c=new Curso();
				c.setIdCurso(rs.getInt("idCurso"));
				c.setNombreCurso(rs.getString("nombreCurso"));
				c.setGrupo(rs.getString("grupo"));
				Curso.add(c);
			}
			ps.close();

			System.out.println("Se ejecuto la sentencia");
		}catch (Exception e) {
			System.out.println("Error "+e.getMessage());
		}
		finally {
			con.close();
		}
		return Curso;


	}
	
	public int CrearCurso(Curso curso) throws SQLException {
		sql = "INSERT INTO Curso(nombreCurso, grupo) VALUES (?,?)";

		try {

			con = C.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, getNombreCurso());
			ps.setString(2, getGrupo());
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
	
	public void EliminarCurso(int id) throws SQLException {
		sql = "DELETE FROM curso WHERE idCurso="+id;

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

	public int EditarCurso (Curso curso) throws SQLException {
		sql = "update curso set nombreCurso=?, Grupo=? "+"where idCurso="+curso.getIdCurso();
		Curso c= new Curso();

		try {

			con = C.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, curso.getNombreCurso());
			ps.setString(2, curso.getGrupo());
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

	public Curso ConsultarCurso(int id) throws SQLException {
		sql = "SELECT * FROM curso WHERE idCurso="+id;
		Curso cur= new Curso();

		try {

			con = C.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {

				cur.setIdCurso(rs.getInt(1));
				cur.setNombreCurso(rs.getString(2));
				cur.setGrupo(rs.getString(3));


				System.out.println("Se ejecuto la sentencia");
			}

			ps.close();

		}catch(Exception e) {
			System.out.println("Error "+e.getMessage());
		}
		finally {
			con.close();
		}

		return cur;
	}

}
