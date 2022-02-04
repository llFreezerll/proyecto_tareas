package Controller;

        import java.io.IOException;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

        import Model.*;
        import jakarta.servlet.Servlet;
        import jakarta.servlet.ServletContext;
        import jakarta.servlet.ServletException;
        import jakarta.servlet.ServletOutputStream;
        import jakarta.servlet.annotation.WebServlet;
        import jakarta.servlet.http.HttpServlet;
        import jakarta.servlet.http.HttpServletRequest;
        import jakarta.servlet.http.HttpServletResponse;

        import Clases.Rol;
        import Clases.Usuarios;
        import jakarta.servlet.http.HttpSession;
        import net.sf.jasperreports.engine.JasperExportManager;
        import net.sf.jasperreports.engine.JasperFillManager;
        import net.sf.jasperreports.engine.JasperPrint;
        import net.sf.jasperreports.engine.JasperReport;
        import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
        import net.sf.jasperreports.engine.util.JRLoader;

@WebServlet(name = "UsuarioController", value = "/UsuarioController")
public class UsuarioController extends HttpServlet {

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

    Usuarios user=new Usuarios();
    UsuarioDAO us =new UsuarioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        HttpSession sesion = request.getSession();

        try {
            if(accion != null) {
                switch (accion) {

                    case "Login":
                        user.setUsuario(request.getParameter("User"));
                        user.setContrasena(request.getParameter("Pass"));
                        try {
                            user=us.Login(user.getUsuario(), user.getContrasena());
                            if(user.getNombre()!=null && user.getestado()==true){
                                System.out.println("Se encontro usuario");
                                sesion.setAttribute("users", user);
                                request.getRequestDispatcher("index.jsp").forward(request, response);
                            }
                            else if (user.getNombre()!=null && user.getestado()==false){
                                System.out.println("Se encontro usuario pero esta inactivo");
                                request.getRequestDispatcher("UsuarioController?accion=VistaLogin&msn=Usuario inactivo consulte con el administrador").forward(request, response);
                            }
                            else {
                                System.out.println("No se encontro usuario");
                                request.getRequestDispatcher("UsuarioController?accion=VistaLogin&msn=Usuario o contraseña incorrecto").forward(request, response);
                            }

                        }catch (Exception e){
                            System.out.println("Error en el login "+ e.getMessage());
                        }
                        break;
                    case "Logout":
                        sesion.removeAttribute("users");
                        sesion.invalidate();
                        request.getRequestDispatcher("index.jsp").forward(request,response);
                        break;
                    case "VistaLogin":
                        VistaLogin(request,response);
                        break;
                    case "reporteUsuario":
                        ReporteUsuario(request,response);
                        break;
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
                        break;
                    case "changeEstado":
                        changeEstado(request,response);
                        break;
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

        Usuarios Use = new Usuarios();

        try {
            List User = Use.ListarUsuario();
            request.setAttribute("Users", User);
            request.getRequestDispatcher("views/User.jsp").forward(request, response);
            System.out.println("Usuarios Encontrados");
        }catch (Exception e) {
            System.out.println("no se encontraron Usuarios "+ e.getMessage());
        }finally {
            Use = null;
        }

    }

    public void VistaAgregar(HttpServletRequest request, HttpServletResponse response){

        try {
            this.obtenerRol(request);
            request.getRequestDispatcher("views/AgregarUsuario.jsp").forward(request, response);
            System.out.println("Enviado a la vista");
        }catch (Exception e) {
            System.out.println("no se encontraron Roles "+ e.getMessage());
        }finally {
        }

    }

    public void VistaLogin(HttpServletRequest request, HttpServletResponse response){

        try {
            request.getRequestDispatcher("views/Login.jsp").forward(request, response);
            System.out.println("Enviado a la vista de Login");
        }catch (Exception e) {
            System.out.println("no se encontraron vista de login"+ e.getMessage());
        }finally {
        }

    }

    public void obtenerRol(HttpServletRequest request){

        Rol rol = new Rol();
        List<Rol> role = null;

        try {
            role = rol.ListarRol();
            request.setAttribute("Roles", role);
            System.out.println("Enviado a la vista");
        }catch (Exception e) {
            System.out.println("no se encontraron Roles "+ e.getMessage());
        }finally {
        }

    }

    public void Agregar(HttpServletRequest request, HttpServletResponse response) throws SQLException{

        Usuarios Us = new Usuarios();


        if (request.getParameter("Documento")!= null){
            Us.setDocumento(request.getParameter("Documento"));
            Us.setNombre(request.getParameter("Nombre"));
            Us.setApellido(request.getParameter("Apellido"));
            Us.setUsuario(request.getParameter("Usuario"));
            Us.setContrasena(request.getParameter("Contrasena"));
            Us.setCorreElectronico(request.getParameter("CorreoElectronico"));
            Us.setPerfilCreado(Boolean.getBoolean("Perfil"));

            Rol r = new Rol();
            r.setIdRol(Integer.parseInt(request.getParameter("RolUsu")));
            Us.setrol(r);

        }

        if(request.getParameter("Estado")!=null){
            Us.setestado(true);
        }
        else {
            Us.setestado(false);
        }

        try {
            Us.AgregarUsuario(Us);
            response.sendRedirect("UsuarioController?accion=listar");
            System.out.println("se agrego roles");
        }catch (Exception e) {
            System.out.println("no se encontraron Roles "+ e.getMessage());
        }finally {
        }

    }

    public void Eliminar(HttpServletRequest request, HttpServletResponse response){

        Usuarios User = new Usuarios();

        if (request.getParameter("id")!= null){
            User.setIdUsuario(Integer.parseInt(request.getParameter("id")));
        }

        try {
            User.EliminarUsuario(User.getIdUsuario());
            response.sendRedirect("UsuarioController?accion=listar");
            System.out.println("se elimino roles");
        }catch (Exception e) {
            System.out.println("no se encontraron Roles "+ e.getMessage());
        }finally {
        }

    }

    public void Buscar(HttpServletRequest request, HttpServletResponse response){

        Usuarios Us = new Usuarios();

        int id =Integer.parseInt(request.getParameter("id"));

        try {
            this.obtenerRol(request);
            Us = Us.ConsultarUsuario(id);
            request.setAttribute("User", Us);
            request.getRequestDispatcher("views/UsuarioEditar.jsp").forward(request, response);
            System.out.println("se envio al editor de Usuarios");
        }catch (Exception e) {
            System.out.println("no se encontraron Usuarios "+ e.getMessage());
        }finally {
            // Us = null;
        }

    }

    public void Editar(HttpServletRequest request, HttpServletResponse response){

        Usuarios Us = new Usuarios();

        if (request.getParameter("idUsuario") != null && request.getParameter("Documento") != null){

            Us.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
            Us.setDocumento(request.getParameter("Documento"));
            Us.setNombre(request.getParameter("Nombre"));
            Us.setApellido(request.getParameter("Apellido"));
            Us.setUsuario(request.getParameter("Usuario"));
            Us.setContrasena(request.getParameter("Contrasena"));
            Us.setCorreElectronico(request.getParameter("CorreoElectronico"));

            Rol r = new Rol();
            r.setIdRol(Integer.parseInt(request.getParameter("RolUsu")));
            Us.setrol(r);

        }

        if(request.getParameter("Estado")!=null){
            Us.setestado(true);
        }
        else {
            Us.setestado(false);
        }


        try {
            Us.Actualizar(Us);
            response.sendRedirect("UsuarioController?accion=listar");
            System.out.println("se envio al editor de Usuarios");
        }catch (Exception e) {
            System.out.println("no se encontraron (Usuarios) "+ e.getMessage());
        }finally {
            Us = null;
        }

    }

    private void changeEstado(HttpServletRequest request, HttpServletResponse response) {
        try {
            Usuarios u = new Usuarios();
            u.setIdUsuario(Integer.parseInt(request.getParameter("id")));
            u.setestado(Boolean.parseBoolean(request.getParameter("es")));
            u.cambiarEstado(u);
            response.sendRedirect("UsuarioController?accion=listar");
        }catch(Exception e) {
            System.out.println("Estado NO actualizado "+e.getMessage());
        }
    }

    private void ReporteUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ServletOutputStream out = response.getOutputStream();

        try{

            java.io.InputStream logo = this.getServletConfig()
                    .getServletContext()
                    .getResourceAsStream("Reportes/Img/LogoAbaco.png");

            java.io.InputStream reporte = this.getServletConfig()
                    .getServletContext()
                    .getResourceAsStream("Reportes/UsuariosReport.jasper");

            if (logo!=null && reporte!=null){
                List<Usuarios> reporteUsuario = new ArrayList<>();
                reporteUsuario = user.ListarUsuario();

                JasperReport report = (JasperReport) JRLoader.loadObject(reporte);
                JRBeanArrayDataSource ds = new JRBeanArrayDataSource(reporteUsuario.toArray());

                Map<String, Object> parameters = new HashMap();
                parameters.put("ds", ds);
                parameters.put("logo", logo);

                response.setContentType("application/pdf");
                response.addHeader("Content-disposition", "inline; filename=ReporteUsuario.pdf");

                JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, ds);
                JasperExportManager.exportReportToPdfStream(jasperPrint, out);

                out.flush();
                out.close();
            }
            else {
                response.setContentType("text/plain");
                out.println("no se pudo generar el reporte");
                out.println("esto puede deberse a que la lista de datos no fue recibida o el "
                        + "archivo plantilla del reporte no se ha encontrado");
                out.println("contacte a soporte");
            }
        }catch (Exception e){
            response.setContentType("text/plain");
            out.print("ocurrio un error al intentar generar el reporte: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
