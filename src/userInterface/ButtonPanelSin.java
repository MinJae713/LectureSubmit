package userInterface;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanelSin extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JButton Sinsub;
	
	public ButtonPanelSin(ActionListener actionSin) {
		Sinsub = new JButton("선택과목 신청하기");
		
		LayoutManager layoutManager = new FlowLayout(FlowLayout.CENTER, 10, 10);
		this.setLayout(layoutManager);
		
		this.add(Sinsub);
		this.Sinsub.addActionListener(actionSin);
	}
	
}
