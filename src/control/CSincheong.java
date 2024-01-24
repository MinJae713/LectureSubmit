package control;

import java.io.IOException;
import java.util.Vector;

import dao.DAOSincheong;
import entity.ELecture;

public class CSincheong {
	private DAOSincheong daoSincheong;
	public CSincheong() {
		this.daoSincheong = new DAOSincheong();
	}

	public Vector<ELecture> getItems(ELecture selectedItem) throws IOException {
		// TODO Auto-generated method stub
		return this.daoSincheong.getItems(selectedItem);
		// 강좌 정보를 입력 받아서 DAOSincheong클래스의 getItems메소드호출, 호출시 입력 받은 강좌정보를 매개변수로 입력
		// 수행 결과로 반환 받은  ELecture형 벡터배열을 VSincheong에 반환
	}

}
