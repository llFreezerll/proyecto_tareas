package Model;

import Clases.Rol;
import Clases.Usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    String sql=null;

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    Conexion C = new Conexion();
    int rows;

    public Usuarios Login (String User, String Pass) throws SQLException {
        sql = "SELECT usuarios.idUsuario,usuarios.NombreUsuario, usuarios.ApellidoUsuario, usuarios.CorreoElectronico, usuarios.Estado, usuarios.FK_Rol, roles.NombreRol FROM usuarios JOIN roles on usuarios.FK_Rol=roles.IdRol WHERE usuarios.Usuario =? AND usuarios.Contrasena = ?";
        Usuarios Us= new Usuarios();

        try {

            con = C.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, User);
            ps.setString(2,Pass);
            rs = ps.executeQuery();

            while(rs.next()) {

                Us.setIdUsuario(rs.getInt(1));
                Us.setNombre(rs.getString(2));
                Us.setApellido(rs.getString(3));
                Us.setCorreElectronico(rs.getString(4));
                Us.setestado(rs.getBoolean(5));

                Us.setrol(new Rol());
                Us.getrol().setIdRol(rs.getInt(6));
                Us.getrol().setNombreRol(rs.getString(7));

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
}
