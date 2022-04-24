package Clases;

import Model.Conexion;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


	public class Profesor extends Usuarios {

		private int idProfesor;
		private int FKUsuario;
		private int FKCurso;
		private Curso cursoAsignado;
		private Usuarios Profesor;

		String sql=null;
		String sql2=null;

		Connection con;
		PreparedStatement ps;
		PreparedStatement ps2;
		ResultSet rs;

		Conexion C = new Conexion();
		int rows;

		public int getIdProfesor() {return idProfesor;}

		public void setIdProfesor(int idProfesor) {	this.idProfesor = idProfesor; }

		public int getFKUsuario() {	return FKUsuario;	}

		public void setFKUsuario(int FKUsuario) { this.FKUsuario = FKUsuario; }

		public Curso getCursoAsignado() { return cursoAsignado;	}

		public void setCursoAsignado(Curso cursoAsignado) {	this.cursoAsignado = cursoAsignado;	}

		public Usuarios getProfesor() {	return Profesor;}

		public void setProfesor(Usuarios profesor) { Profesor = profesor; }

		public int getFKCurso() { return FKCurso; }

		public void setFKCurso(int FKCurso) { this.FKCurso = FKCurso; }

		public List ListarProfesor() throws Exception{
			List<Usuarios> User = new ArrayList<>();
			sql = "SELECT idProfesor, usuarios.NombreUsuario, usuarios.ApellidoUsuario, usuarios.documento, usuarios.CorreoElectronico, curso.nombreCurso, curso.grupo FROM profesor JOIN usuarios on usuarios.idUsuario = profesor.FK_usuario \n" +
					"JOIN curso on curso.idCurso = profesor.FK_cursoAsignado";
			try {

				con = C.conectar();
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();

				while(rs.next()){

					Profesor pro=new Profesor();

					pro.setIdProfesor(rs.getInt(1));
					pro.setProfesor(new Usuarios());
					pro.getProfesor().setNombre(rs.getString(2));
					pro.getProfesor().setApellido(rs.getString(3));
					pro.getProfesor().setDocumento(rs.getString(4));
					pro.getProfesor().setCorreElectronico(rs.getString(5));
					pro.setCursoAsignado(new Curso());
					pro.getCursoAsignado().setNombreCurso(rs.getString(6));
					pro.getCursoAsignado().setGrupo(rs.getString(7));

					User.add(pro);

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

		public Clases.Profesor ConsultarProfesor(int id) throws SQLException {
			sql = "SELECT * FROM Profesor WHERE idProfesor="+id;
			Profesor pro = new Profesor();

			try {

				con = C.conectar();
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();

				while(rs.next()) {

					pro.setIdProfesor(1);
					pro.setProfesor(new Usuarios());
					pro.getProfesor().setIdUsuario(rs.getInt(2));
					pro.setFKUsuario(rs.getInt(2));
					pro.setCursoAsignado(new Curso());
					pro.getCursoAsignado().setIdCurso(rs.getInt(3));

					System.out.println("Se ejecuto la sentencia");
				}

				ps.close();

			}catch(Exception e) {
				System.out.println("Error "+e.getMessage());
			}
			finally {
				con.close();
			}
			return pro;
		}

		public int Agregar(Profesor pro) throws SQLException {
			sql = "INSERT INTO profesor (FK_usuario, FK_CursoAsignado) VALUES (?,?)";


			try {

				con = C.conectar();
				ps = con.prepareStatement(sql);

				ps.setInt(1, pro.getProfesor().getIdUsuario());
				ps.setInt(2, pro.getCursoAsignado().getIdCurso());

				System.out.println(sql);

				ps.executeUpdate();
				ps.close();
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



		public void CalificarActividad (Actividad actividad, Nota nota) {

		}

		public void AsignarActividad (Actividad actividad, Curso curso) {

		}


		public void EliminarProfesor(int id) throws SQLException {

			sql = "DELETE FROM profesor WHERE idProfesor="+id;
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

		public void Editar(HttpServletRequest request, HttpServletResponse response){

			Profesor Us = new Profesor();

			Us.setIdProfesor(Integer.parseInt(request.getParameter("idPadre")));
			Us.setFKCurso(Integer.parseInt(request.getParameter("CodigoEstudiante")));



			try {
				Us.Actualizar(Us);
				response.sendRedirect("ProfesorController?accion=listar");
				System.out.println("se envio al listado de Usuarios");
			}catch (Exception e) {
				System.out.println("no se encontraron "+ e.getMessage());
			}finally {
				Us = null;
			}

		}



		public void BuscarEditar(HttpServletRequest request, HttpServletResponse response){

			Profesor pa = new Profesor();
			Usuarios Us = new Usuarios();
			Usuarios User = new Usuarios();



			int id =Integer.parseInt(request.getParameter("id"));


			try {
				pa= pa.BuscarProfe(id);
				User = Us.ConsultarUsuario(pa.getFKUsuario());
				request.setAttribute("User", User);
				request.setAttribute("Profe", pa);
				request.getRequestDispatcher("views/ProfesorEditar.jsp").forward(request, response);
				System.out.println("se envio al editor de Usuarios");

			}catch (Exception e) {
				System.out.println("no se encontraron Usuarios "+ e.getMessage());
			}finally {
				Us = null;
			}

		}

		public int Actualizar(Profesor Pa) throws SQLException {
			sql = "update profesor set FK_CursoAsignado=? "+"where idProfesor="+Pa.getIdProfesor();

			Padres pa= new Padres();

			try {

				con = C.conectar();
				ps = con.prepareStatement(sql);

				ps.setInt(1, Pa.getFKCurso());

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

		public Profesor BuscarProfe(int id) throws Exception{

			sql = "SELECT * FROM profesor WHERE idProfesor="+id;
			Profesor Us= new Profesor();

			try {

				con = C.conectar();
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();

				while(rs.next()) {

					Us.setIdProfesor(rs.getInt(1));
					Us.setFKUsuario(rs.getInt(2));
					Us.setFKCurso(rs.getInt(3));

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


