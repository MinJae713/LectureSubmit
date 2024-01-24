package control;

import java.io.FileNotFoundException;
import java.util.Vector;

import dao.DAOLecture;
import entity.ELecture;

public class CLecture {
	private DAOLecture daoLecture;
	
	public CLecture() {
		daoLecture = new DAOLecture();
	}

	public Vector<ELecture> getItems(String fileName) throws FileNotFoundException{
		// TODO Auto-generated method stub
		return this.daoLecture.getItems(fileName);
	}

}
