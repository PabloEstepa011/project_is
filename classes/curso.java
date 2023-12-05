package classes;

import java.io.Serializable;
import java.util.Date;

public class curso implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idCurso;
	private String curso;
	private Date fechaInicio;
	private Date fechaFin;
	private usuario ponente;
	private String descripcion;
	
	public curso(int idCurso,String curso,Date fechaInicio,Date fechaFin, usuario ponente,String descripcion) {
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
	
	public Date getfechaInicio() {
		return fechaInicio;
	}
	
	public void setfechaInicio(Date fechaInicio) {
		this.fechaInicio=fechaInicio;
	}
	
	public Date getfechaFin() {
		return fechaFin;
	}
	
	public usuario getponente() {
		return ponente;
	}
	public void setdniponente(usuario ponente) {
		this.ponente=ponente;
	}
	
	public void setfechaFin(Date fechaFin) {
		this.fechaFin=fechaFin;
	}
	
	public String getdescripcion() {
		return descripcion;
	}
	
	public void setdescripcion(String descripcion) {
		this.descripcion=descripcion;
	}
	
	public String toString() {
        return idCurso + "," + curso + "," + fechaInicio + "," + fechaFin + "," + ponente.getDni() + "," + descripcion;
	}
}
