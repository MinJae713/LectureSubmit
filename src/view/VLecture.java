package view;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import control.CLecture;
import entity.ELecture;

public class VLecture {

	private CLecture cLecture;
	private ELecture selectedItem;
	
	public VLecture() {
		this.cLecture = new CLecture();
	}
	public ELecture show(String fileName) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Vector<ELecture> items;
		items = this.cLecture.getItems(fileName);
		
		System.out.println("��ȣ�� �����ϼ���.");
		for(ELecture item: items) {
			System.out.println(item.getNumber() + " " + item.getName());
		}
		System.out.print("���ù�ȣ : ");
		
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
	//	scanner.close();
		
		int index = 0;
		boolean found = false;
	//	String hyperLink = null;
		for(index = 0; index < items.size() && !found; index++) {
			if (items.get(index).getNumber() == number) {
				found = true;
				selectedItem = items.get(index);
			}
		}
		System.out.println("������ ����Ǿ����ϴ�.");
		return selectedItem;
		
	}

}
