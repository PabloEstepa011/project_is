package project;

public class usuario {
	private int dni;
	private String nombreCompleto;
	private String correoElectronico;
	private String contrasena;
	
	public usuario(int dni,String nombreCompleto,String correoElectronico,String contrasena){
		this.dni=dni;
		this.nombreCompleto=nombreCompleto;
		this.correoElectronico=correoElectronico;
		this.contrasena=contrasena;
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
	
	public String getContrasena() {
		return contrasena;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena=contrasena;
	}
	
	public void mostrarInformacionUsuario() {
		System.out.println("El DNI del Usuario: "+dni);
		System.out.println("El nombre completo del Usuario: "+nombreCompleto);
		System.out.println("El correo electronico del Usuario: "+correoElectronico);
	}
	
	
}
