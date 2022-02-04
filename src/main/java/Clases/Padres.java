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

	public void ConsultarNotas() {
		
	}

	public List ListarPadre() throws Exception{

		List<Padres> Padre = new ArrayList<>();
		List<Estudiantes> Estudiante = new ArrayList<>();
		sql = "SELECT p.idPadres, u.documento, u.NombreUsuario, u.ApellidoUsuario, u.CorreoElectronico, us.documento, us.NombreUsuario, us.ApellidoUsuario, us.CorreoElectronico, cu.nombreCurso, cu.grupo FROM padres as p INNER JOIN usuarios AS u on p.FK_padre=u.idUsuario INNER JOIN estudiante on p.FK_Estudiante=estudiante.idEstudiante INNER JOIN usuarios as us on estudiante.FK_usuario = us.idUsuario INNER JOIN curso as cu on estudiante.FK_Curso=cu.idCurso;";

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
		sql2= "update usuarios set perfilCreado=?" + " where idUsuario=" + es.getUsers().getIdUsuario();


		try {

			con = C.conectar();
			ps = con.prepareStatement(sql);
			ps2 = con.prepareStatement(sql2);

			ps.setInt(1, es.getEstudiantes().getIdEstudiante());
			ps.setInt(2, es.getUsers().getIdUsuario());
			ps2.setBoolean(1, es.getUsers().getPerfilCreado());

			System.out.println(sql);
			System.out.println(sql2);

			ps.executeUpdate();
			ps2.executeUpdate();
			ps.close();
			ps2.close();
			System.out.println("Se ejecuto la sentencia");

		}catch(Exception e) {
			System.out.println("Error no se pudo agregar "+e.getMessage());
		}
		finally {
			con.close();
		}
		return rows;
	}

}
