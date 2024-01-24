package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import exception.InvalidUserException;

public class ELogin {
	private String userId;
	private String password;
	
	public boolean read(Scanner scanner, String userId, String password) {
		boolean found = false;
		while(!found && scanner.hasNext()) {
		
		this.userId = scanner.next();
		this.password = scanner.next();
		
		if(this.userId.equals(userId) && this.password.equals(password)) {
			
			found = true;
			
		}
		}
		return found;
	}
	
	public void authenticate(String userID, String password) throws FileNotFoundException, InvalidUserException {
		
		// file open
		Scanner scanner = new Scanner(new File("data/login"));
		
		// validate userId & password
		if(!(read(scanner, userID, password))) {
			scanner.close();
			throw new InvalidUserException();
		}
		
		scanner.close();
	}

}
