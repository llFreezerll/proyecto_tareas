package Clases;

public class Usuarios {
	
		
	private int idUsuario;
	private String usuario;
	private String contrasena;
	private String documento;
	private String nombre;
	private String apellido;
	private String correElectronico;
	private Boolean estado;
	private String rol;
	
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
	public String getDocumento() {
		return documento;
	}
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
	public boolean estado() {
		return estado;
	}
	public void estado(boolean estado) {
		this.estado = estado;
	}
	/* hacer metodos*/
	public void CrearUsuario(String usuario, String contraseña, String documento){
		
	}
	public void ModificarUsuario(String usuario, String documento, boolean estado){
		
	}
	public void BorrarUsuario(String usuario, String documento, boolean estado) {
		
	}
	public void AsignarRol (String usuario, String documento, Rol rol) {
		
	}
}
