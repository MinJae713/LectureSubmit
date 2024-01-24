package dao;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import entity.ELecture;

public class DAOLecture {
	
	public Vector<ELecture> getItems(String fileName) throws FileNotFoundException{
		Vector<ELecture> eItems = new Vector<ELecture>();
		// file open
		Scanner scanner = new Scanner(new File(fileName));
		
		// validate userId & password
		while(scanner.hasNext()) {
			ELecture eItem = new ELecture();
			eItem.read(scanner);
			eItems.add(eItem);
		}
		// invalid userId or password
		scanner.close();
		return eItems;
		
	}

}
