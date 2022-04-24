package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Padres extends Usuarios {

	private  int idPadre;
	private int FKEstudiante;
	private int FKPadre;
	private Estudiantes estudiantes;
	private Usuarios users;

	String sql2=null;
	ResultSet rs2;
	PreparedStatement ps2;

	public Estudiantes getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(Estudiantes estudiante) {
		this.estudiantes = estudiante;
	}

	public Usuarios getUsers() {return users;}
	public void setUsers(Usuarios users) {this.users = users;}

	public int getIdPadre() {return idPadre;}
	public void setIdPadre(int idPadre) {this.idPadre = idPadre;}

	public int getFKEstudiante() {return FKEstudiante;}
	public void setFKEstudiante(int FKEstudiante) {this.FKEstudiante = FKEstudiante;}

	public int getFKPadre() { return FKPadre; }

	public void setFKPadre(int FKPadre) { this.FKPadre = FKPadre; }

	public void ConsultarNotas() {
		
	}



	public List ListarPadre() throws Exception{

		List<Padres> Padre = new ArrayList<>();
		List<Estudiantes> Estudiante = new ArrayList<>();
		sql = "SELECT p.idPadres, u.documento, u.NombreUsuario, u.ApellidoUsuario, u.CorreoElectronico, us.documento, us.NombreUsuario, us.ApellidoUsuario, us.CorreoElectronico, cu.nombreCurso, cu.grupo, u.idUsuario, p.FK_padre FROM padres as p INNER JOIN usuarios AS u on p.FK_padre=u.idUsuario INNER JOIN usuarios as us on p.FK_Estudiante = us.idUsuario INNER JOIN estudiante as es on p.FK_Estudiante = es.FK_usuario INNER JOIN curso as cu on es.FK_Curso=cu.idCurso;";

		try {

			con = C.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()){

				Padres pa=new Padres();
				Estudiantes es = new Estudiantes();

				pa.setIdPadre(rs.getInt(1));
				pa.setUsers(new Usuarios());
				pa.getUsers().setDocumento(rs.getString(2));
				pa.getUsers().setNombre(rs.getString(3));
				pa.getUsers().setApellido(rs.getString(4));
				pa.getUsers().setCorreElectronico(rs.getString(5));
				pa.setEstudiantes(new Estudiantes());
				pa.getEstudiantes().setEstudiante(new Usuarios());
				pa.getEstudiantes().setCurso(new Curso());
				pa.getEstudiantes().getEstudiante().setDocumento(rs.getString(6));
				pa.getEstudiantes().getEstudiante().setNombre(rs.getString(7));
				pa.getEstudiantes().getEstudiante().setApellido(rs.getString(8));
				pa.getEstudiantes().getEstudiante().setCorreElectronico(rs.getString(9));
				pa.getEstudiantes().getCurso().setNombreCurso(rs.getString(10));
				pa.getEstudiantes().getCurso().setGrupo(rs.getString(11));
				pa.getUsers().setIdUsuario(rs.getInt(12));
				pa.setFKPadre(rs.getInt(13));

				Padre.add(pa);

			}
			ps.close();

			System.out.println("Se ejecuto la sentencia");
		}catch (Exception e) {
			System.out.println("Error "+e.getMessage());
		}
		finally {
			con.close();
		}
		return Padre;
	}

	public int Agregar(Padres es) throws SQLException {
		sql = "INSERT INTO padres (FK_Estudiante, FK_padre) VALUES (?,?)";


		try {

			con = C.conectar();
			ps = con.prepareStatement(sql);

			ps.setInt(1, es.getEstudiantes().getIdEstudiante());
			ps.setInt(2, es.getUsers().getIdUsuario());

			System.out.println(sql);

			ps.executeUpdate();
			ps.close();
			System.out.println("Se ejecuto la sentencia");

		}catch(Exception e) {
			System.out.println("Error no se pudo agregar "+e.getMessage());
		}
		finally {
			con.close();
		}
		return rows;
	}

	public void Eliminar(int id) throws SQLException {

		sql = "DELETE FROM padres WHERE idPadres="+id;
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

	public int Actualizar(Padres Pa) throws SQLException {
		sql = "update padres set FK_Estudiante=? "+"where idPadres="+Pa.getIdPadre();

		Padres pa= new Padres();

		try {

			con = C.conectar();
			ps = con.prepareStatement(sql);

			ps.setInt(1, Pa.getFKEstudiante());

			System.out.println("Se ejecuto la sentencia");
			ps.executeUpdate();
			ps.close();


		}catch(Exception e) {
			System.out.println("Error "+e.getMessage());
		}
		finally {
			con.close();
		}
		return rows;
	}

	public Padres BuscarPadre(int id) throws Exception{

		sql = "SELECT * FROM padres WHERE idPadres="+id;
		Padres Us= new Padres();

		try {

			con = C.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {

				Us.setIdPadre(rs.getInt(1));
				Us.setFKEstudiante(rs.getInt(2));
				Us.setFKPadre(rs.getInt(3));

			}

			System.out.println("Se ejecuto la sentencia");
			ps.close();

		}catch(Exception e) {
			System.out.println("Error "+e.getMessage());
		}
		finally {
			con.close();
		}

		return Us;

	}


}
