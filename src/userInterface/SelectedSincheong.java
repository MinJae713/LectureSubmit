package userInterface;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SelectedSincheong extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private LectureTable selectedItems;
	private JLabel lb;
	private MouseListener mouseListener;
	
	public SelectedSincheong() throws FileNotFoundException {
		this.mouseListener = new MouseHandler();
		
		this.setLayout(null);
		
		this.lb = new JLabel("신청한 강좌목록");
		this.lb.setLocation(200, 0);
		this.lb.setSize(500, 50);
		this.add(lb, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.selectedItems = new LectureTable(this.mouseListener);
		scrollPane.setViewportView(this.selectedItems);
		
		scrollPane.setLocation(0, 50);
		scrollPane.setSize(500, 150);
		this.add(scrollPane);
		
		this.refresh();
	}
	
	public void refresh() {
		try {
			this.selectedItems.refresh("sincheong");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private class MouseHandler implements MouseListener{
		
		@Override//마우스 떼는 순간 이벤트 발생
		public void mouseReleased(MouseEvent e) {
			 
		}

		@Override
		public void mouseClicked(MouseEvent event) {
			// TODO Auto-generated method stub
			try {
				JTable jt = (JTable)event.getSource();
				int[] row = jt.getSelectedRows();
				Object name = jt.getValueAt(row[0], 0);
				System.out.println(name);
			}catch(ArrayIndexOutOfBoundsException e) {
				
			}
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			// System.out.println("마우스 클릭");
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

	}

}
