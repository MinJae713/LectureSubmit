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
		// ELecture형 벡터배열 생성, data/basket파일 읽는 Scanner생성
		
		FileWriter fw = new FileWriter("data/basket", true);
		// data/basket파일에 내용을 이어서 입력하는 FileWriter생성
		while(scanner.hasNext()) {
			eItem = new ELecture();
			eItem.read(scanner);
			eItems.add(eItem);
		}
		// ELecture클래스 생성, data/basket파일에 있는 강좌정보를 ELecture의 속성에 입력
		// ELecture클래스에 입력된 강좌 정보들을 벡터 배열(eItems)에 추가
		eItems.add(selectedItem);
		// basket에 입력하려는 강좌 정보를 벡터 배열에 추가
		fw.write("\n");
		fw.write(selectedItem.getNumber()+" "+selectedItem.getName()+" "+selectedItem.getProfessor()
		+" "+selectedItem.getCredit()+" "+selectedItem.getTime());
		// data/basket파일에 줄바꿈 이후, basket에 입력하려는 강좌 정보를 추가
		// 기존 파일에 있던 정보에 추가로 강좌 정보가 추가됨.
		
		fw.close();
		return eItems;
		// 강좌 정보가 입력된 ELecture형 벡터 배열을 반환
	}

}
