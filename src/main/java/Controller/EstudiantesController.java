package Controller;

import Clases.Curso;
import Clases.Estudiantes;
import Clases.Rol;
import Clases.Usuarios;
import Model.ConfigEmail;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EstudiantesController", value = "/EstudiantesController")
public class EstudiantesController extends HttpServlet {

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
                   /*case "VistaAgregar":
                        VistaAgregar(request,response);
                        break;*/
                    case "Agregar":
                        Agregar(request,response);
                        break;
                    case "Eliminar":
                        Eliminar(request,response);
                        break;
                    case "Buscar":
                        Buscar(request,response);
                        break;
                   /* case "Editar":
                        Editar(request,response);*/
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

        Estudiantes student = new Estudiantes();

        try {
            List es = student.ListarEstudiante();
            request.setAttribute("Estudiantes", es);
            request.getRequestDispatcher("views/Estudiantes.jsp").forward(request, response);
            System.out.println("Usuarios Encontrados");
        }catch (Exception e) {
            System.out.println("no se encontraron Usuarios "+ e.getMessage());
        }finally {
            student = null;
        }

    }

    public void Agregar(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        Estudiantes Es = new Estudiantes();

            Usuarios us = new Usuarios();
            us.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));

            Curso c = new Curso();
            c.setIdCurso(Integer.parseInt(request.getParameter("RolUsu")));


        if (request.getParameter("Creado")!=null){
            us.setPerfilCreado(true);
        }else {
            us.setPerfilCreado(false);
        }

        Es.setCurso(c);
        Es.setEstudiante(us);

        try {
            Es.Agregar(Es);
            response.sendRedirect("EstudiantesController?accion=listar");
            System.out.println("se agrego Estudiantes");
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

        Estudiantes student = new Estudiantes();

        if (request.getParameter("id")!= null){
            student.setIdEstudiante(Integer.parseInt(request.getParameter("id")));
        }

        try {
            student.arreglar(student.ConsultarEstudiante(Integer.parseInt(request.getParameter("id"))));
            student.EliminarEstudiante(student.getIdEstudiante());
            response.sendRedirect("EstudiantesController?accion=listar");
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
            request.getRequestDispatcher("views/AgregarEstudiante.jsp").forward(request, response);
            System.out.println("se envio al editor de Estudiantes");
        }catch (Exception e) {
            System.out.println("no se encontraron Usuarios "+ e.getMessage());
        }finally {
            // Us = null;
        }

    }
}

