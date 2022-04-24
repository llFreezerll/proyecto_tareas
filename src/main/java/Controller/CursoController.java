package Controller;

import Clases.Curso;
import Clases.Rol;
import Clases.Usuarios;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CursoController", value = "/CursoController")
public class CursoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");
        try {
            if(accion != null) {
                switch (accion) {
                    case "listar":
                        listar(request, response);
                        break;
                    case "VistaAgregar":
                        VistaAgregar(request,response);
                        break;
                    case "Agregar":
                        Agregar(request,response);
                        break;
                    case "Eliminar":
                        Eliminar(request,response);
                        break;
                    case "Buscar":
                        Buscar(request,response);
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
        doGet(request, response);
    }


    public void listar(HttpServletRequest request, HttpServletResponse response){

        Curso curso = new Curso();

        try {
            List cur = curso.ListarCurso();
            request.setAttribute("Cursos", cur);
            request.getRequestDispatcher("views/Cursos.jsp").forward(request, response);
            System.out.println("Usuarios Encontrados");
        }catch (Exception e) {
            System.out.println("no se encontraron Usuarios "+ e.getMessage());
        }finally {
            curso = null;
        }

    }

    public void VistaAgregar(HttpServletRequest request, HttpServletResponse response){

        try {

            request.getRequestDispatcher("views/AgregarCurso.jsp").forward(request, response);
            System.out.println("Enviado a la vista");
        }catch (Exception e) {
            System.out.println("no se encontraron Roles "+ e.getMessage());
        }finally {
        }

    }

    public void Agregar(HttpServletRequest request, HttpServletResponse response){

        Curso cur = new Curso();

        if (request.getParameter("Curso")!= null || request.getParameter("Grupo")!=null){
            cur.setNombreCurso(request.getParameter("Curso"));
            cur.setGrupo(request.getParameter("Grupo"));
        }


        try {
            cur.CrearCurso(cur);
            response.sendRedirect("CursoController?accion=listar");
            System.out.println("se agrego roles");
        }catch (Exception e) {
            System.out.println("no se encontraron Roles "+ e.getMessage());
        }finally {
        }

    }
    public void Eliminar(HttpServletRequest request, HttpServletResponse response){

        Curso cur = new Curso();

        if (request.getParameter("id")!= null){
            cur.setIdCurso(Integer.parseInt(request.getParameter("id")));
        }

        try {
            cur.EliminarCurso(cur.getIdCurso());
            response.sendRedirect("CursoController?accion=listar");
            System.out.println("se elimino Curso");
        }catch (Exception e) {
            System.out.println("no se encontraron Roles "+ e.getMessage());
        }finally {
        }

    }

    public void Buscar(HttpServletRequest request, HttpServletResponse response){

        Curso cu = new Curso();

        int id =Integer.parseInt(request.getParameter("id"));

        try {
            cu = cu.ConsultarCurso(id);
            request.setAttribute("Cur", cu);
            request.getRequestDispatcher("views/CursoEditar.jsp").forward(request, response);
            System.out.println("se envio al editor de Cursos");
        }catch (Exception e) {
            System.out.println("no se encontraron Cursos "+ e.getMessage());
        }finally {
             cu = null;
        }

    }

    public void Editar(HttpServletRequest request, HttpServletResponse response){

        Curso cu = new Curso();

        if (request.getParameter("id") != null && request.getParameter("Curso") != null){

            cu.setIdCurso(Integer.parseInt(request.getParameter("id")));
            cu.setNombreCurso(request.getParameter("Curso"));
            cu.setGrupo(request.getParameter("Grupo"));


        }


        try {
            cu.EditarCurso(cu);
            response.sendRedirect("CursoController?accion=listar");
            System.out.println("se envio al editor de Usuarios");
        }catch (Exception e) {
            System.out.println("no se encontraron (Usuarios) "+ e.getMessage());
        }finally {
            cu = null;
        }

    }

}