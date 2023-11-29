package classes;

import java.io.Serializable;

public class usuario implements Serializable{
	
	private int dni;
	private String nombreCompleto;
	private String correoElectronico;
	private String contraseña;
	
	public usuario(int dni,String nombreCompleto,String correoElectronico,String contraseña){
		this.dni=dni;
		this.nombreCompleto=nombreCompleto;
		this.correoElectronico=correoElectronico;
		this.contraseña=contraseña;
	}
		
		
	public int getDni() {
		return dni;
	}
	
	public void setDni(int dni) {
		this.dni=dni;
	}
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto=nombreCompleto;
	}
	
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico=correoElectronico;
	}
	
	public String getContraseña() {
		return contraseña;
	}
	
	public void setContraseña(String contraseña) {
		this.contraseña=contraseña;
	}
	
	
	public void mostrarInformacionUsuario() {
		System.out.println("El DNI del Usuario: "+dni);
		System.out.println("El nombre completo del Usuario: "+nombreCompleto);
		System.out.println("El correo electronico del Usuario: "+correoElectronico);
	}
	
	public String toString() {
        return dni + "," + nombreCompleto + "," + correoElectronico + "," + contraseña;
    }
	
	
}