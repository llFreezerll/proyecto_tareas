package Controller;

import Clases.*;
import Model.ConfigEmail;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProfesorController", value = "/ProfesorController")
public class ProfesorController extends HttpServlet {

    private String host;
    private String puerto;
    private String remitente;
    private String contrasena;



    public void init() {
        ServletContext contexto=getServletContext();
        host=contexto.getInitParameter("host");
        puerto=contexto.getInitParameter("puerto");
        remitente=contexto.getInitParameter("remitente");
        contrasena=contexto.getInitParameter("password");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        try {
            if(accion != null) {
                switch (accion) {
                    case "listar":
                        listar(request, response);
                        break;
                   case "Buscar":
                        Buscar(request,response);
                        break;
                    case "Agregar":
                        Agregar(request,response);
                        break;
                    case "Eliminar":
                        Eliminar(request,response);
                        break;
                    case "BuscarEditar":
                        BuscarEditar(request,response);
                        break;
                    case "Editar":
                        Editar(request,response);
                    default:
                        response.sendRedirect("login.jsp");
                }
            }
        }catch (Exception e) {
            try {
                System.out.println("Error "+ e.getMessage());
                request.getRequestDispatcher("/mensaje.jsp").forward(request, response);
            }catch (Exception ex) {
                System.out.println("Error "+ e.getMessage());
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    public void listar(HttpServletRequest request, HttpServletResponse response){

        Profesor Profe = new Profesor();

        try {
            List Pro = Profe.ListarProfesor();
            request.setAttribute("Profesor", Pro);
            request.getRequestDispatcher("views/Profesores.jsp").forward(request, response);
            System.out.println("Usuarios Encontrados");
        }catch (Exception e) {
            System.out.println("no se encontraron Usuarios "+ e.getMessage());
        }finally {
            Profe = null;
        }

    }

    public void Agregar(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        Profesor Pro = new Profesor();

        Usuarios us = new Usuarios();
        us.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));

        Curso c = new Curso();
        c.setIdCurso(Integer.parseInt(request.getParameter("RolUsu")));


        Pro.setCursoAsignado(c);
        Pro.setProfesor(us);

        try {
            Pro.Agregar(Pro);
            response.sendRedirect("ProfesorController?accion=listar");
            System.out.println("se agrego Profesores");
        }catch (Exception e) {
            System.out.println("no se encontraron Roles "+ e.getMessage());
        }finally {
        }

    }



    public void obtenerUsuario(HttpServletRequest request){

        Usuarios user = new Usuarios();
        List<Usuarios> users = null;

        try {
            users = user.ListarUsuario();
            request.setAttribute("Users", users);
            System.out.println("Enviado a la vista");
        }catch (Exception e) {
            System.out.println("no se encontraron Roles "+ e.getMessage());
        }finally {
        }

    }

    public void obtenerCurso(HttpServletRequest request){

        Curso Curso = new Curso();
        List<Curso> Cur = null;

        try {
            Cur = Curso.ListarCurso();
            request.setAttribute("Curso", Cur);
            System.out.println("Enviado a la vista");
        }catch (Exception e) {
            System.out.println("no se encontraron Roles "+ e.getMessage());
        }finally {
        }

    }

    public void Eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        Profesor teacher = new Profesor();

        if (request.getParameter("id")!= null){
            teacher.setIdProfesor(Integer.parseInt(request.getParameter("id")));
        }

        try {
            teacher.EliminarProfesor(teacher.getIdProfesor());
            response.sendRedirect("ProfesorController?accion=listar");
            System.out.println("se elimino roles");
        }catch (Exception e) {
            System.out.println("no se encontraron Roles "+ e.getMessage());
        }finally {
        }

    }

    public void Buscar(HttpServletRequest request, HttpServletResponse response){

        Curso C = new Curso();
        Usuarios Us = new Usuarios();
        List<Curso> Curso = null;

        int id =Integer.parseInt(request.getParameter("id"));

        try {
            this.obtenerUsuario(request);
            this.obtenerCurso(request);
            Curso = C.ListarCurso();
            request.setAttribute("Curso", Curso);
            Us = Us.ConsultarUsuario(id);
            request.setAttribute("User", Us);
            request.getRequestDispatcher("views/AgregarProfesor.jsp").forward(request, response);
            System.out.println("se envio al editor de Profesores");
        }catch (Exception e) {
            System.out.println("no se encontraron Usuarios "+ e.getMessage());
        }finally {
            // Us = null;
        }

    }

    public void Editar(HttpServletRequest request, HttpServletResponse response){

        Profesor Us = new Profesor();

        Us.setIdProfesor(Integer.parseInt(request.getParameter("idProfesor")));
        Us.setFKCurso(Integer.parseInt(request.getParameter("CodigoCurso")));



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
            request.setAttribute("Padre", pa);
            request.getRequestDispatcher("views/ProfesorEditar.jsp").forward(request, response);
            System.out.println("se envio al editor de Usuarios");

        }catch (Exception e) {
            System.out.println("no se encontraron Usuarios "+ e.getMessage());
        }finally {
            Us = null;
        }

    }
}

