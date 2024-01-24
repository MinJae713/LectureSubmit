package userInterface;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanelBas extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton bassub;
	
	public ButtonPanelBas(ActionListener actionBas) {
		bassub = new JButton("���ð��� �̸����");
		
		LayoutManager layoutManager = new FlowLayout(FlowLayout.CENTER, 10, 10);
		this.setLayout(layoutManager);
		
		this.add(bassub);
		this.bassub.addActionListener(actionBas);
		
	}
	
}
