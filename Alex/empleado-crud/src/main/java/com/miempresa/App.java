package com.miempresa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 *
 */

import java.util.Scanner;
public class App 


{
	private static final String URL = "jdbc:mysql://localhost:3306/empresa";
	private static final String USER = "root";
	private static final String PASSWORD = "SOMAhynlxl2523@";
	
	private static void addEmployee(Scanner scanner) {
		scanner.nextLine();
		
		System.out.println("Ingrese su nombre");
		String nombre = scanner.nextLine();
		scanner.nextLine();
		
		
		System.out.println("Ingrese el salario");
		double salario = scanner.nextDouble();
		
		scanner.nextLine();
	
	
		System.out.println("Ingrese el puesto");
		String puesto = scanner.nextLine();
		
		
		
		try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement stmt = conn.prepareStatement("INSERT INTO empleados(nombre, puesto, salario) VALUES(?,?,?)");) {
			stmt.setString(1, nombre);
			stmt.setString(2, puesto);
			stmt.setDouble(3, salario);
			stmt.executeUpdate();
			
			System.out.println("Se ejecuto correctamente");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	private static void readEmployee() {
		
		
		try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM empleados");) {	
			
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id") + ", Nombre: " + rs.getString("nombre") + ", Puesto: " + rs.getString("puesto") + ", Salario " + rs.getDouble("salario"));
				
			}
		
			System.out.println("Se ejecuto correctamente");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public static void updateEmployee(Scanner scanner) {
		scanner.nextLine();
		System.out.println("Ingrese ID del empleado");
		int id = scanner.nextInt();
		
		scanner.nextLine();
		System.out.println("Ingrese el nombre");
		String nombre = scanner.nextLine();
		scanner.nextLine();
		
		System.out.println("Ingrese el salario");
		double salario = scanner.nextDouble();
		scanner.nextLine();
		
		System.out.println("Ingrese el puesto");
		String puesto = scanner.nextLine();
		
	
		try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement stmt = conn.prepareStatement("UPDATE empleados SET nombre=?, puesto=?, salario=? WHERE id=?");) {
			
			stmt.setString(1, nombre);
			stmt.setString(2, puesto);
			stmt.setDouble(3, salario);
			
			stmt.setInt(4, id);
			stmt.executeUpdate();
			
			System.out.println("Se ejecuto correctamente");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void deleteEmployee(Scanner scanner) {
		scanner.nextLine();
		System.out.println("Ingrese ID del empleado");
		int id = scanner.nextInt();

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement stmt = conn
						.prepareStatement("DELETE FROM empleados WHERE id=?");) {

			stmt.setInt(1, id);
			stmt.executeUpdate();

			System.out.println("Se ejecuto correctamente");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
    public static void main( String[] args ){
     
    	Scanner scanner = new Scanner(System.in);
    	
    	/*
    	 * CRUD				SQL 		VERBO HTTP
    	 * C -> CREATE 		-> INSERT 		-> 	POST 
    	 * R -> -READ 		-> SELECT 		-> 	GET
    	 * U -> -UPDATE 	-> UPDATE 		-> 	PUT
    	 * D -> -DELETE 	-> DELETE		-> 	DELETE
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	*/
    	
    	while (true) {
    		
    		System.out.println("1: Agregar empleado\n2; Leer empleado\n3: Actualizar empleado \n4: Eliminar Empleado");
    		int option = scanner.nextInt();
    		switch (option) {
    		case 1:
    			addEmployee(scanner);
    			break;
    		case 2:
    			readEmployee();
    			break;
    		case 3:
    			updateEmployee(scanner);
    			break;
    		case 4:
    			deleteEmployee(scanner);
    			break;
    		case 5:
    			System.out.println("Salió del sistema");
    			return;
    		default:
    		System.out.println("La opcion elegida no existe");
    		
    		}
    	}
    	
    	
    	
    }
}
