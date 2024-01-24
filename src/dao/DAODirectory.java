package dao;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import entity.EDirectory;

public class DAODirectory {
	
	
	public Vector<EDirectory> getItems(String fileName) throws FileNotFoundException{
		Vector<EDirectory> eDirectories = new Vector<EDirectory>();
		// file open
		Scanner scanner = new Scanner(new File(fileName));
		
		// validate userId & password
		while(scanner.hasNext()) {
			EDirectory eDirectory = new EDirectory();
			eDirectory.read(scanner);
			eDirectories.add(eDirectory);
		}
		// invalid userId or password
		scanner.close();
		return eDirectories;
		
	}

}
