package com.login.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.login.config.ConnectionData;
import com.login.dto.LoginDto;
import com.login.dto.Response;
import com.login.entity.LoginEntity;

public class LoginService {
	
	ConnectionData connectionData = new ConnectionData();
	
	public Response registerLogin(LoginDto loginDto) {
		try (Connection conn = DriverManager.getConnection(connectionData.getUrl(),connectionData.getUser(), connectionData.getPassword());
				PreparedStatement stmt = conn.prepareStatement("INSERT INTO usuario(nombre, correo_electronico, constrasenia) VALUES(?,?,?)");){
			
			LoginEntity loginEntity = new LoginEntity();
			loginEntity.setNombre(loginDto.getNombre());
			loginEntity.setContrasenia(loginDto.getContrasenia());
			loginEntity.setCorreoElectonico(loginDto.getCorreoElectonico());
			
			stmt.setString(1, loginEntity.getNombre());
			stmt.setString(2, loginEntity.getCorreoElectonico());
			stmt.setString(3, loginEntity.getContrasenia());
			stmt.executeUpdate();
			return new Response(201, "Success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public Response getLogin(int id) {
		return null;
	}

}
