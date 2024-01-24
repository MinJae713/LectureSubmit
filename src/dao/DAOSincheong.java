package dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import entity.ELecture;

public class DAOSincheong {
	ELecture eItem;

	public Vector<ELecture> getItems(ELecture selectedItem) throws IOException {
		Vector<ELecture> eItems = new Vector<ELecture>();
		Scanner scanner = new Scanner(new File("data/sincheong"));
		// ELecture�� ���͹迭 ����, data/sincheong���� �д� Scanner����
		
		FileWriter fw = new FileWriter("data/sincheong", true);
		// data/sincheong���Ͽ� ������ �̾ �Է��ϴ� FileWriter����
		while(scanner.hasNext()) {
			eItem = new ELecture();
			eItem.read(scanner);
			eItems.add(eItem);
		}
		// ELectureŬ���� ����, data/sincheong���Ͽ� �ִ� ���������� ELecture�� �Ӽ��� �Է�
		// ELectureŬ������ �Էµ� ���� �������� ���� �迭�� �߰�
		eItems.add(selectedItem);
		// sincheong�� �Է��Ϸ��� ���� ������ ���� �迭�� �߰�
		
		fw.write("\n");
		fw.write(selectedItem.getNumber()+" "+selectedItem.getName()+" "+selectedItem.getProfessor()
		+" "+selectedItem.getCredit()+" "+selectedItem.getTime());
		// data/sincheong���Ͽ� �ٹٲ� ����, sincheong�� �Է��Ϸ��� ���� ������ �߰�
		// ���� ���Ͽ� �ִ� ������ �߰��� ���� ������ �߰���.
		
		fw.close();
		scanner.close();
		return eItems;
		// ���� ������ �Էµ� ELecture�� ���� �迭�� ��ȯ
	}

}
