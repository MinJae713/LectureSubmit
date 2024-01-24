package view;

import java.io.FileNotFoundException;

public class VSugangInfo {
	
	private VDirectory vCampus;
	private VDirectory vCollege;
	private VDirectory vDepartment;
	private VLecture vLecture;
	// ���� ����
	
	public VSugangInfo() {
		this.vCampus = new VDirectory();
		this.vCollege = new VDirectory();
		this.vDepartment = new VDirectory();
		this.vLecture = new VLecture();
		
	}

	public void show(String userId) throws FileNotFoundException {
		System.out.println("�ȳ��ϼ���." + userId);
		String fileName = this.vCampus.show("data/root");
		fileName = this.vCollege.show("data/" + fileName);
		fileName = this.vDepartment.show("data/" + fileName);
		this.vLecture.show("data/" + fileName);
	}

}
