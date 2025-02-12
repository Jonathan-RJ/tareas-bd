package com.login.config;

public class ConnectionData {

	private static final String URL = "jdbc:mysql://localhost:3306/login";
	private static final String USER = "root";
	private static final String PASSWORD = "portador123";
	
	public static String getUrl() {
		return URL;
	}
	public static String getUser() {
		return USER;
	}
	public static String getPassword() {
		return PASSWORD;
	}

	
	
}