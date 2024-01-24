package view;

import java.io.FileNotFoundException;
import java.util.Scanner;

import control.CLogin;
import exception.InvalidUserException;

public class VLogin {
	
	private CLogin cLogin;
	public VLogin() {
		this.cLogin = new CLogin();
	}

	public String authenticate() {
		
		try {
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("UserId : ");
			String userId = scanner.next();
			System.out.print("Password : ");
			String password = scanner.next();
			System.out.println(password);
			
		//	scanner.close();
			
			this.cLogin.authenticate(userId, password);
			
			return userId;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidUserException e) {
			e.printStackTrace();
		} 
		return null;
	}

}
