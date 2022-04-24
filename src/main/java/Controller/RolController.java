package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Clases.Rol;
import Clases.Usuarios;
import jakarta.servlet.http.HttpSession;


@WebServlet(name = "RolController", value = "/RolController")
public class RolController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");
        try {
            if(accion != null) {
                switch (accion) {
                    case "listarRoles":
                        listarRoles(request, response);
                        break;
                    case "VistaAgregar":
                        VistaAgregar(request,response);
                        break;
                    case "AgregarRol":
                        AgregarRol(request,response);
                        break;
                    case "Eliminar":
                        Eliminar(request,response);
                        break;
                    case "BuscarRol":
                        BuscarRol(request,response);
                        break;
                    case "EditarRol":
                        EditarRol(request,response);
                    default:
                        response.sendRedirect("login.jsp");
                }
            }
        }catch (Exception e) {
            try {
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

    public void listarRoles(HttpServletRequest request, HttpServletResponse response){

        Rol rol = new Rol();

        try {
            List rolColeccion = rol.ListarRol();
            request.setAttribute("Roles", rolColeccion);
            request.getRequestDispatcher("views/role.jsp").forward(request, response);
            System.out.println("Roles Encontrados");
        }catch (Exception e) {
            System.out.println("no se encontraron Roles "+ e.getMessage());
        }finally {
            rol = null;
        }

    }
    public void VistaAgregar(HttpServletRequest request, HttpServletResponse response){

       try {

            request.getRequestDispatcher("views/AgregarRol.jsp").forward(request, response);
            System.out.println("Enviado a la vista");
        }catch (Exception e) {
            System.out.println("no se encontraron Roles "+ e.getMessage());
        }finally {
        }

    }

    public void AgregarRol(HttpServletRequest request, HttpServletResponse response){

        Rol rol = new Rol();

        if (request.getParameter("nombre")!= null){
            rol.setNombreRol(request.getParameter("nombre"));
        }

        if(request.getParameter("Estado")!=null){
            rol.setEstadoRol(true);
        }
        else {
            rol.setEstadoRol(false);
        }

        try {
            rol.CrearRol(rol);
            response.sendRedirect("RolController?accion=listarRoles");
            System.out.println("se agrego roles");
        }catch (Exception e) {
            System.out.println("no se encontraron Roles "+ e.getMessage());
        }finally {
        }

    }

    public void Eliminar(HttpServletRequest request, HttpServletResponse response){

        Rol rol = new Rol();

        if (request.getParameter("id")!= null){
            rol.setIdRol(Integer.parseInt(request.getParameter("id")));
        }

        try {
            rol.EliminarRol(rol.getIdRol());
            response.sendRedirect("RolController?accion=listarRoles");
            System.out.println("se elimino roles");
        }catch (Exception e) {
            System.out.println("no se encontraron Roles "+ e.getMessage());
        }finally {
        }

    }

    public void BuscarRol(HttpServletRequest request, HttpServletResponse response){

        Rol rol = new Rol();

        int id =Integer.parseInt(request.getParameter("id"));

        try {
            rol = rol.ConsultarRol(id);
            request.setAttribute("RolEditado", rol);
            request.getRequestDispatcher("views/RolEditar.jsp").forward(request, response);
            System.out.println("se envio al edito de roles");
        }catch (Exception e) {
            System.out.println("no se encontraron Roles "+ e.getMessage());
        }finally {
            rol = null;
        }

    }

    public void EditarRol(HttpServletRequest request, HttpServletResponse response){

        Rol rol = new Rol();

        if (request.getParameter("id") != null && request.getParameter("nombre") != null){
            rol.setNombreRol(request.getParameter("nombre"));
            rol.setIdRol(Integer.parseInt(request.getParameter("id")));
        }

        try {
            rol.Actualizar(rol);
            response.sendRedirect("RolController?accion=listarRoles");
            System.out.println("se envio al editor de roles");
        }catch (Exception e) {
            System.out.println("no se encontraron Roles "+ e.getMessage());
        }finally {
            rol = null;
        }

    }
}
