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
		// ���� ������ �Է� �޾Ƽ� DAOBasketŬ������ getItems�޼ҵ�ȣ��, ȣ��� �Է� ���� ���������� �Ű������� �Է�
		// ���� ����� ��ȯ ����  ELecture�� ���͹迭�� VBasket�� ��ȯ
	}

}
