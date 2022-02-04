package Clases;

import Model.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Estudiantes extends Usuarios {

	private int idEstudiante;
	private int FKUsuario;
	private Curso curso;
	private Usuarios estudiante;

	String sql=null;
	String sql2=null;

	Connection con;
	PreparedStatement ps;
	PreparedStatement ps2;
	ResultSet rs;

	Conexion C = new Conexion();
	int rows;

	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Usuarios getEstudiante() {return estudiante;}
	public void setEstudiante(Usuarios estudiante) {this.estudiante = estudiante;}

	public int getIdEstudiante() {return idEstudiante;}
	public void setIdEstudiante(int idEstudiante) {this.idEstudiante = idEstudiante;}

	public int getFKUsuario() {return FKUsuario;}
	public void setFKUsuario(int FKUsuario) {this.FKUsuario = FKUsuario;}

	public List ListarEstudiante() throws Exception{

		List<Usuarios> User = new ArrayList<>();
		sql = "SELECT idEstudiante, usuarios.NombreUsuario, usuarios.ApellidoUsuario, usuarios.documento, usuarios.CorreoElectronico, curso.nombreCurso, curso.grupo FROM estudiante JOIN usuarios on usuarios.idUsuario = estudiante.FK_usuario \n" +
				"JOIN curso on curso.idCurso = estudiante.FK_Curso";
		try {

			con = C.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()){

				Estudiantes es=new Estudiantes();

				es.setIdEstudiante(rs.getInt(1));
				es.setEstudiante(new Usuarios());
				es.getEstudiante().setNombre(rs.getString(2));
				es.getEstudiante().setApellido(rs.getString(3));
				es.getEstudiante().setDocumento(rs.getString(4));
				es.getEstudiante().setCorreElectronico(rs.getString(5));
				es.setCurso(new Curso());
				es.getCurso().setNombreCurso(rs.getString(6));
				es.getCurso().setGrupo(rs.getString(7));

				User.add(es);

			}
			ps.close();

			System.out.println("Se ejecuto la sentencia");
		}catch (Exception e) {
			System.out.println("Error "+e.getMessage());
		}
		finally {
			con.close();
		}
		return User;
	}

	public Estudiantes ConsultarEstudiante(int id) throws SQLException {
		sql = "SELECT * FROM estudiante WHERE idEstudiante="+id;
		Estudiantes es = new Estudiantes();

		try {

			con = C.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {

				es.setIdEstudiante(1);
				es.setEstudiante(new Usuarios());
				es.getEstudiante().setIdUsuario(rs.getInt(2));
				es.setFKUsuario(rs.getInt(2));
				es.setCurso(new Curso());
				es.getCurso().setIdCurso(rs.getInt(3));


				System.out.println("Se ejecuto la sentencia");
			}

			ps.close();

		}catch(Exception e) {
			System.out.println("Error "+e.getMessage());
		}
		finally {
			con.close();
		}
		return es;
	}

	public int arreglar (Estudiantes es) throws SQLException {
		sql= "update usuarios set perfilCreado=false" + " where idUsuario=" + es.getEstudiante().getIdUsuario();

		try {

			con = C.conectar();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			System.out.println("Se ejecuto la sentencia");
			System.out.println(sql);

		}catch(Exception e){

			System.out.println("Error "+e.getMessage());

		}
		finally {
			con.close();
		}
		return rows;
	}

	public int Agregar(Estudiantes es) throws SQLException {
		sql = "INSERT INTO estudiante (FK_usuario, FK_Curso) VALUES (?,?)";
		sql2= "update usuarios set perfilCreado=?" + " where idUsuario=" + es.getEstudiante().getIdUsuario();


		try {

			con = C.conectar();
			ps = con.prepareStatement(sql);
			ps2 = con.prepareStatement(sql2);

			ps.setInt(1, es.getEstudiante().getIdUsuario());
			ps.setInt(2, es.getCurso().getIdCurso());
			ps2.setBoolean(1, es.getEstudiante().getPerfilCreado());

			System.out.println(sql);
			System.out.println(sql2);

			ps.executeUpdate();
			ps2.executeUpdate();
			ps.close();
			ps2.close();
			System.out.println("Se ejecuto la sentencia");

		}catch(Exception e) {
			System.out.println(sql);
			System.out.println("Error no se pudo agregar "+e.getMessage());
		}
		finally {
			con.close();
		}
		return rows;
	}

	public void EliminarEstudiante(int id) throws SQLException {

		sql = "DELETE FROM estudiante WHERE idestudiante="+id;
		sql2= "update usuarios set perfilCreado=false" + " where idUsuario=" + id;

		try {

			con = C.conectar();
			ps = con.prepareStatement(sql);
			ps2 = con.prepareStatement(sql2);
			ps.executeUpdate();
			ps2.executeUpdate();
			ps.close();
			ps2.close();
			System.out.println("Se ejecuto la sentencia");

		}catch(Exception e){

			System.out.println("Error "+e.getMessage());

		}
		finally {
			con.close();
		}
	}

}
