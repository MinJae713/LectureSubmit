package control;

import java.io.FileNotFoundException;

import dao.ELogin;
import exception.InvalidUserException;

public class CLogin {
	
	private ELogin eLogin;
	public CLogin() {
		this.eLogin = new ELogin();
	}

	public void authenticate(String userId, String password) throws FileNotFoundException, InvalidUserException {
		
		this.eLogin.authenticate(userId, password);
		return;
	}
	
}
