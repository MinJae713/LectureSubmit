package userInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entity.ELecture;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private SelectionPanel selectionPanel;
	
	private ButtonPanelBas buttonPanel1;
	
	private SelectedBasket basket;
	
	private ButtonPanelSin buttonPanel2;
	
	private SelectedSincheong sincheong;
	
	ELecture selectedItem;
	ActionListener actionBas;
	ActionListener actionSin;
	ActionListener actionBasDel;
	ActionListener actionSinDel;
	
	public MainFrame() {
		this.setTitle("수강신청 프로그램");
		
		this.setLocation(100, 100);
		this.setSize(1020, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(null);
		this.actionBas = new ButtonActionHandlerBas();
		this.actionSin = new ButtonActionHandlerSin();
		
		try {
			this.selectionPanel = new SelectionPanel();
			this.selectionPanel.setSize(500, 450);
			this.selectionPanel.setLocation(0, 0);
			this.add(this.selectionPanel);
			
			this.buttonPanel1 = new ButtonPanelBas(this.actionBas);
			this.buttonPanel1.setLocation(0, 450);
			this.buttonPanel1.setSize(500, 50);
			this.add(this.buttonPanel1);
			
			this.basket = new SelectedBasket();
			this.basket.setLocation(500, 0);
			this.basket.setSize(500, 200);
			this.add(this.basket);
			
			this.buttonPanel2 = new ButtonPanelSin(this.actionSin);
			this.buttonPanel2.setLocation(500, 200);
			this.buttonPanel2.setSize(500, 50);
			this.add(this.buttonPanel2);
			
			this.sincheong = new SelectedSincheong();
			this.sincheong.setLocation(500, 250);
			this.sincheong.setSize(500, 200);
			this.add(this.sincheong);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private class ButtonActionHandlerBas implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(buttonPanel1, "강좌 미리담기 \n 정상적으로 처리되었습니다");
			basket.refresh();
		}
		
	}
	
	private class ButtonActionHandlerSin implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(buttonPanel2, "강좌 신청하기 \n 정상적으로 처리되었습니다");
			sincheong.refresh();
		}
		
	}
	
}
