package Controller;

import Clases.Curso;
import Clases.Estudiantes;
import Clases.Padres;
import Clases.Usuarios;
import Model.ConfigEmail;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PadresController", value = "/PadresController")
public class PadresController extends HttpServlet {

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
                  /* case "Eliminar":
                        Eliminar(request,response);
                        break;*/
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
        doGet(request, response);
    }

    public void listar(HttpServletRequest request, HttpServletResponse response){

        Padres Padre = new Padres();
        Usuarios user = new Usuarios();
        Estudiantes es = new Estudiantes();

        int id = es.getFKUsuario();

        try {
            List pa = Padre.ListarPadre();
            user = user.ConsultarUsuario(id);
            request.setAttribute("PA", pa);
            request.setAttribute("US", user);
            request.getRequestDispatcher("views/Padres.jsp").forward(request, response);
            System.out.println("Usuarios Encontrados");
        }catch (Exception e) {
            System.out.println("no se encontraron Usuarios "+ e.getMessage());
        }finally {
            Padre = null;
        }

    }

    public void Agregar(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        Padres pa = new Padres();

        Usuarios us = new Usuarios();
        us.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));

        Estudiantes c = new Estudiantes();
        c.setIdEstudiante(Integer.parseInt(request.getParameter("idUsuario2")));


        if (request.getParameter("Creado")!=null){
            us.setPerfilCreado(true);
        }else {
            us.setPerfilCreado(false);
        }

        pa.setEstudiantes(c);
        pa.setUsers(us);

        String destinatario = request.getParameter("correo");
        String asunto="ABACO REGISTRO DE ESTUDIANTE";
        String cuerpo="<h1> Se ha registrado tu usuario en Abaco </h1>";
        try {
            ConfigEmail.EnviarCorreo(host, puerto, remitente, contrasena, destinatario, asunto, cuerpo);
            System.out.println("Se envi� el mensaje al nuevo usuario");
        }catch(Exception e) {
            System.out.println("Se produjo un error al enviar el mensaje al nuevo usuario "+e.getMessage());
        }


        try {
            pa.Agregar(pa);
            response.sendRedirect("PadresController?accion=listar");
            System.out.println("se agrego roles");
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

    public void obtenerEstudiante(HttpServletRequest request){

        Estudiantes es = new Estudiantes();
        List<Estudiantes> Student = null;

        try {
            Student = es.ListarEstudiante();
            request.setAttribute("Student", Student);
            System.out.println("Enviado a la vista");
        }catch (Exception e) {
            System.out.println("no se encontraron Roles "+ e.getMessage());
        }finally {
        }

    }
    public void Buscar(HttpServletRequest request, HttpServletResponse response){

        Estudiantes C = new Estudiantes();
        Usuarios Us = new Usuarios();
        List<Estudiantes> estudy = null;

        int id =Integer.parseInt(request.getParameter("id"));

        try {
            this.obtenerUsuario(request);
            this.obtenerEstudiante(request);
            estudy = C.ListarEstudiante();
            request.setAttribute("Student", estudy);
            Us = Us.ConsultarUsuario(id);
            request.setAttribute("User", Us);
            request.getRequestDispatcher("views/AgregarPadres.jsp").forward(request, response);
            System.out.println("se envio al editor de Estudiantes");
        }catch (Exception e) {
            System.out.println("no se encontraron Usuarios "+ e.getMessage());
        }finally {
            // Us = null;
        }

    }
}
