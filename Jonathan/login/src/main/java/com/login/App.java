package com.login;

import java.util.Scanner;

import com.login.dto.LoginDto;
import com.login.service.LoginService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		
		
		LoginDto loginDto = new LoginDto();
		
		loginDto.setNombre("Jthan");
		loginDto.setContrasenia("uendgd7847");
		loginDto.setCorreoElectonico("jonibghsgbghsgil.com");
		
		LoginService loginService = new LoginService();
		System.out.println(loginService.registerLogin(loginDto).toString());
		
		
		
		
	}
}
