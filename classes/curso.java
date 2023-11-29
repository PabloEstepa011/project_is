package classes;

import java.io.Serializable;
import java.time.LocalDate;

public class curso implements Serializable{
	private int idCurso;
	private String curso;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private usuario ponente;
	private String descripcion;
	
	public curso(int idCurso,String curso,LocalDate fechaInicio,LocalDate fechaFin, usuario ponente,String descripcion) {
		this.idCurso=idCurso;
		this.curso=curso;
		this.fechaInicio=fechaInicio;
		this.fechaFin=fechaFin;
		this.ponente=ponente;
		this.descripcion=descripcion;
	}
	
	public int getidCurso() {
		return idCurso;
	}
	
	public void setidCurso(int idCurso) {
		this.idCurso=idCurso;
	}
	
	public String getcurso() {
		return curso;
	}
	
	public void setcurso(String curso) {
		this.curso=curso;
	}
	
	public LocalDate getfechaInicio() {
		return fechaInicio;
	}
	
	public void setfechaInicio(LocalDate fechaInicio) {
		this.fechaInicio=fechaInicio;
	}
	
	public LocalDate getfechaFin() {
		return fechaFin;
	}
	
	public void setfechaFin(LocalDate fechaFin) {
		this.fechaFin=fechaFin;
	}
	
	public String toString() {
        return idCurso + "," + curso + "," + fechaInicio + "," + fechaFin + "," + ponente.getDni() + "," + descripcion;
	}
}
