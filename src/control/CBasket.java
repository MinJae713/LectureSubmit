package control;

import java.io.IOException;
import java.util.Vector;

import dao.DAOBasket;
import entity.ELecture;

public class CBasket {
	
	private DAOBasket daoBasket;
	public CBasket() {
		this.daoBasket = new DAOBasket();
	}
	
	public Vector<ELecture> getItems(ELecture selectedItem) throws IOException{
		// TODO Auto-generated method stub
		return this.daoBasket.getItems(selectedItem);
		// 강좌 정보를 입력 받아서 DAOBasket클래스의 getItems메소드호출, 호출시 입력 받은 강좌정보를 매개변수로 입력
		// 수행 결과로 반환 받은  ELecture형 벡터배열을 VBasket에 반환
	}

}
