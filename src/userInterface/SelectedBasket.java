package userInterface;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import control.CSincheong;
import entity.ELecture;

public class SelectedBasket extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private LectureTable selectedItems;
	private JLabel lb;
	private MouseListener mouseListener;
	
	CSincheong cSincheong;
	Vector<ELecture> items;
	ELecture selectedItem;
	
	public SelectedBasket() throws FileNotFoundException {
		this.mouseListener = new MouseHandler();
		
		this.setLayout(null);
		
		this.lb = new JLabel("미리담기 강좌목록");
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
			this.selectedItems.refresh("basket");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ELecture getSelectedItem() {
		return this.selectedItem;
	}
	
	public void FileWrite(Object source) {
		this.cSincheong = new CSincheong();
		this.items = this.selectedItems.getLectureInfoArray();
		
		try {
			int index = 0;
			boolean found = false;
			
			for(index = 0; index < items.size() && !found; index++) {
				if (items.get(index).getName() == source) {
					found = true;
					selectedItem = items.get(index);
				}
			}
			
			this.cSincheong.getItems(selectedItem);
			
			String name = this.selectedItem.getName();
			System.out.println(name);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
				FileWrite(name);
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
