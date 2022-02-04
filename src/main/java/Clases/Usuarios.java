package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Conexion;

public class Usuarios {
	
		
	private int idUsuario;
	private String usuario;
	private String contrasena;
	private String documento;
	private String nombre;
	private String apellido;
	private String correElectronico;
	private Boolean estado;
	private Boolean perfilCreado;
	private Rol rol;
	String sql=null;

	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	Conexion C = new Conexion();
	int rows;
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getDocumento() {	return documento;	}

	public Boolean getPerfilCreado() {	return perfilCreado;}

	public void setPerfilCreado(Boolean perfilCreado) {	this.perfilCreado = perfilCreado;	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreElectronico() {
		return correElectronico;
	}
	public void setCorreElectronico(String correElectronico) {
		this.correElectronico = correElectronico;
	}	
	public boolean getestado() {
		return estado;
	}
	public void setestado(boolean estado) {this.estado = estado;}
	public void setrol(Rol rol) {this.rol = rol;}
	public Rol getrol() {return rol;}


	public List ListarUsuario() throws Exception{

		List<Usuarios> User = new ArrayList<>();
		List<Estudiantes> Student = new ArrayList<>();

		sql = "SELECT idUsuario, documento, NombreUsuario, ApellidoUsuario, Usuario, CorreoElectronico, roles.NombreRol, Estado, perfilCreado FROM Usuarios JOIN roles ON roles.idRol = Usuarios.FK_Rol";

		try {

			con = C.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()){

				Usuarios Usu=new Usuarios();

				Usu.setIdUsuario(rs.getInt(1));
				Usu.setDocumento(rs.getString(2));
				Usu.setNombre(rs.getString(3));
				Usu.setApellido(rs.getString(4));
				Usu.setUsuario(rs.getString(5));
				Usu.setCorreElectronico(rs.getString(6));
				Usu.setrol(new Rol());
				Usu.getrol().setNombreRol(rs.getString(7));
				Usu.setestado(rs.getBoolean(8));
				Usu.setPerfilCreado(rs.getBoolean(9));


				User.add(Usu);


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


	public int AgregarUsuario(Usuarios us) throws SQLException{
		sql = "INSERT INTO Usuarios(NombreUsuario, ApellidoUsuario, Usuario, Contrasena, documento, Estado, CorreoElectronico, FK_Rol, perfilCreado) VALUES (?,?,?,?,?,?,?,?,?)";

		try {

			con = C.conectar();
			ps = con.prepareStatement(sql);

			ps.setString(1, us.getNombre());
			ps.setString(2, us.getApellido());
			ps.setString(3, us.getUsuario());
			ps.setString(4, us.getContrasena());
			ps.setString(5, us.getDocumento());
			ps.setBoolean(6, us.getestado());
			ps.setString(7, us.getCorreElectronico());
			ps.setInt(8, us.getrol().getIdRol());
			ps.setBoolean(9, us.getPerfilCreado());

			System.out.println(sql);

			ps.executeUpdate();
			ps.close();
			System.out.println("Se ejecuto la sentencia");

		}catch(Exception e) {
			System.out.println("Error agregar"+e.getMessage());
		}
		finally {
			con.close();
		}
		return rows;
	}

	public int cambiarEstado(Usuarios u) throws SQLException {
		sql="UPDATE Usuarios SET Estado=? "+
				"WHERE idUsuario="+u.getIdUsuario();
		try {

			con=C.conectar();
			ps=con.prepareStatement(sql);
			ps.setBoolean(1, u.getestado());

			System.out.println(ps);
			ps.executeUpdate();
			ps.close();
			System.out.println("Se actualiz� el estado del usuario");
		}catch(Exception e) {
			System.out.println("Error en la actualizaci�n del estado usuario "+e.getMessage());
		}
		finally {
			con.close();
		}
		return rows;
	}

	public void EliminarUsuario(int id) throws SQLException {
		sql = "DELETE FROM Usuarios WHERE idUsuario="+id;

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
	public int Actualizar(Usuarios us) throws SQLException {
		sql = "update usuarios set NombreUsuario=?,ApellidoUsuario=?,Usuario=?,Contrasena=?,documento=?,Estado=?,CorreoElectronico=?,FK_Rol=? "+"where idUsuario="+us.getIdUsuario();

		Usuarios Us= new Usuarios();

		try {

			con = C.conectar();
			ps = con.prepareStatement(sql);

			ps.setString(1, us.getNombre());
			ps.setString(2, us.getApellido());
			ps.setString(3, us.getUsuario());
			ps.setString(4, us.getContrasena());
			ps.setString(5, us.getDocumento());
			ps.setBoolean(6, us.getestado());
			ps.setString(7, us.getCorreElectronico());
			ps.setInt(8, us.getrol().getIdRol());

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


	public Usuarios ConsultarUsuario(int id) throws SQLException {
		sql = "SELECT * FROM usuarios WHERE idUsuario="+id;
		Usuarios Us= new Usuarios();

		try {

			con = C.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {

				Us.setIdUsuario(rs.getInt(1));
				Us.setDocumento(rs.getString(6));
				Us.setNombre(rs.getString(2));
				Us.setApellido(rs.getString(3));
				Us.setUsuario(rs.getString(4));
				Us.setContrasena(rs.getString(5));
				Us.setCorreElectronico(rs.getString(8));

				Us.setrol(new Rol());
				Us.getrol().setIdRol(rs.getInt(9));

				Us.setestado(rs.getBoolean(7));


				System.out.println("Se ejecuto la sentencia");
			}

			ps.close();

		}catch(Exception e) {
			System.out.println("Error "+e.getMessage());
		}
		finally {
			con.close();
		}

		return Us;
	}

	public String getRolRep(){
		return this.rol!=null ? this.rol.getNombreRol() : " ";
	}

	public String getEstadoRep(){
		return this.estado==true ? "Activo" : "Inactivo";
	}

}
