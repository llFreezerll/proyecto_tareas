package Clases;

public class Estudiantes extends Usuarios {
	
	private Curso curso;
	private Nota notas;
	
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Nota getNotas() {
		return notas;
	}
	public void setNotas(Nota notas) {
		this.notas = notas;
	}
	
	public void RealizarActividad (Actividad actividad) {
		
	}

}
