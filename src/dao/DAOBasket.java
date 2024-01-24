package dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import entity.ELecture;

public class DAOBasket {
	ELecture eItem;

	public Vector<ELecture> getItems(ELecture selectedItem) throws IOException {
		Vector<ELecture> eItems = new Vector<ELecture>();
		Scanner scanner = new Scanner(new File("data/basket"));
		// ELecture�� ���͹迭 ����, data/basket���� �д� Scanner����
		
		FileWriter fw = new FileWriter("data/basket", true);
		// data/basket���Ͽ� ������ �̾ �Է��ϴ� FileWriter����
		while(scanner.hasNext()) {
			eItem = new ELecture();
			eItem.read(scanner);
			eItems.add(eItem);
		}
		// ELectureŬ���� ����, data/basket���Ͽ� �ִ� ���������� ELecture�� �Ӽ��� �Է�
		// ELectureŬ������ �Էµ� ���� �������� ���� �迭(eItems)�� �߰�
		eItems.add(selectedItem);
		// basket�� �Է��Ϸ��� ���� ������ ���� �迭�� �߰�
		fw.write("\n");
		fw.write(selectedItem.getNumber()+" "+selectedItem.getName()+" "+selectedItem.getProfessor()
		+" "+selectedItem.getCredit()+" "+selectedItem.getTime());
		// data/basket���Ͽ� �ٹٲ� ����, basket�� �Է��Ϸ��� ���� ������ �߰�
		// ���� ���Ͽ� �ִ� ������ �߰��� ���� ������ �߰���.
		
		fw.close();
		return eItems;
		// ���� ������ �Էµ� ELecture�� ���� �迭�� ��ȯ
	}

}
