package view;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import control.CDirectory;
import entity.EDirectory;

public class VDirectory {
	private CDirectory cDirectory;
	
	public VDirectory() {
		this.cDirectory = new CDirectory();
	}

	public String show(String fileName) throws FileNotFoundException {
			Vector<EDirectory> items;
			items = this.cDirectory.getItems(fileName);
			
			System.out.println("번호를 선택하세요.");
			for(EDirectory item: items) {
				System.out.println(item.getNumber() + " " + item.getName());
			}
			System.out.print("선택번호 : ");
			
			Scanner scanner = new Scanner(System.in);
			int number = scanner.nextInt();
		//	scanner.close();
			
			int index = 0;
			boolean found = false;
			String hyperLink = null;
			for(index = 0; index < items.size() && !found; index++) {
				if (items.get(index).getNumber() == number) {
					found = true;
					hyperLink = items.get(index).getHyperLink();
				}
			}
			//return hyperLink
			return hyperLink;
	}

}
