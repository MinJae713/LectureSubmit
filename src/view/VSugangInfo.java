package view;

import java.io.FileNotFoundException;

public class VSugangInfo {
	
	private VDirectory vCampus;
	private VDirectory vCollege;
	private VDirectory vDepartment;
	private VLecture vLecture;
	// 수강 정보
	
	public VSugangInfo() {
		this.vCampus = new VDirectory();
		this.vCollege = new VDirectory();
		this.vDepartment = new VDirectory();
		this.vLecture = new VLecture();
		
	}

	public void show(String userId) throws FileNotFoundException {
		System.out.println("안녕하세요." + userId);
		String fileName = this.vCampus.show("data/root");
		fileName = this.vCollege.show("data/" + fileName);
		fileName = this.vDepartment.show("data/" + fileName);
		this.vLecture.show("data/" + fileName);
	}

}
