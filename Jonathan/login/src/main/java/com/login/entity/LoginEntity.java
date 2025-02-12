package com.login.entity;


public class LoginEntity {
	
	private int id;
	
	private String nombre;
	//@column(name="correo_electronico")
	private String correoElectonico;
	
	private String contrasenia;

	public LoginEntity() {

	}

	public LoginEntity(int id, String nombre, String correoElectonico, String contrasenia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correoElectonico = correoElectonico;
		this.contrasenia = contrasenia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
