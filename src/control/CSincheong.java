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
		// ���� ������ �Է� �޾Ƽ� DAOSincheongŬ������ getItems�޼ҵ�ȣ��, ȣ��� �Է� ���� ���������� �Ű������� �Է�
		// ���� ����� ��ȯ ����  ELecture�� ���͹迭�� VSincheong�� ��ȯ
	}

}
