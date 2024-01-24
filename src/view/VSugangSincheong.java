package view;

import java.io.FileNotFoundException;

public class VSugangSincheong {
	
	private VSugangInfo vSugangInfo;
	private VBasket vBasket;
	private VSincheong vSincheong;
	
	public VSugangSincheong() {
		this.vSugangInfo = new VSugangInfo();
		this.vBasket = new VBasket();
		this.vSincheong = new VSincheong();
	}

	public void show(String userId) {
		try {
			this.vSugangInfo.show(userId);
			this.vBasket.show();
			this.vSincheong.show();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
