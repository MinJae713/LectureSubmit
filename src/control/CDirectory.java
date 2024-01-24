package control;

import java.io.FileNotFoundException;
import java.util.Vector;

import dao.DAODirectory;
import entity.EDirectory;

public class CDirectory {
	private DAODirectory daoDirectory;
	
	public CDirectory() {
		daoDirectory = new DAODirectory();
	}

	public Vector<EDirectory> getItems(String fileName) throws FileNotFoundException{
		// TODO Auto-generated method stub
		return this.daoDirectory.getItems(fileName);
	}

}
