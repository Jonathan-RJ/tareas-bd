package com.login.dto;

public class LoginDto {
	
	private String nombre;
	
	private String correoElectonico;
	
	private String contrasenia;

	public LoginDto() {
		
	}

	public LoginDto(String nombre, String correoElectonico, String contrasenia) {
		this.nombre = nombre;
		this.correoElectonico = correoElectonico;
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreoElectonico() {
		return correoElectonico;
	}

	public void setCorreoElectonico(String correoElectonico) {
		this.correoElectonico = correoElectonico;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	
	

}
