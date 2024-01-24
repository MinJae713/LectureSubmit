package userInterface;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.CBasket;
import entity.ELecture;

public class SelectionPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private DirectoryList campus;
	private DirectoryList college;
	private DirectoryList department;
	private LectureTable lecture;
	private ListSelectionListener listSelectionListener;
	private MouseListener mouseListener;
	
	private JPanel jp1;
	private JPanel jp2;
	
	Vector<ELecture> items;
	ELecture selectedItem;

	private CBasket cBasket;
	
	public SelectionPanel() {
		this.listSelectionListener = new ListSelectionHandler();
		this.mouseListener = new MouseHandler();
		
		// LayoutManager layoutManager = new FlowLayout(FlowLayout.CENTER, 10, 10);
		this.setLayout(null);
		
		this.jp1 = new JPanel();
		this.jp2 = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		this.campus = new DirectoryList(this.listSelectionListener);
		scrollPane.setViewportView(this.campus);
		this.jp1.add(scrollPane);
		
		scrollPane = new JScrollPane();
		this.college = new DirectoryList(this.listSelectionListener);
		scrollPane.setViewportView(this.college);
		this.jp1.add(scrollPane);
		
		scrollPane = new JScrollPane();
		this.department = new DirectoryList(this.listSelectionListener);
		scrollPane.setViewportView(this.department);
		this.jp1.add(scrollPane);
		
		scrollPane = new JScrollPane();
		this.lecture = new LectureTable(this.mouseListener);
		scrollPane.setViewportView(this.lecture);
		this.jp2.add(scrollPane);
		
		this.jp1.setSize(500, 200);
		this.jp1.setLocation(0, 10);
		
		this.jp2.setSize(500, 230);
		this.jp2.setLocation(0, 220);
		
		this.add(jp1, BorderLayout.NORTH);
		this.add(jp2, BorderLayout.CENTER);
		
		this.refresh(null);
		
	}
	
	private void refresh(Object source) {
		try {
			if (source == null) {
				String fileName = this.campus.refresh("root");
				fileName = this.college.refresh(fileName);
				fileName = this.department.refresh(fileName);
				this.lecture.refresh(fileName);
			}
			else if (source == this.campus) {
				String fileName = campus.getSelectedFileName();
				fileName = this.college.refresh(fileName);
				fileName = this.department.refresh(fileName);
				this.lecture.refresh(fileName);
			} 
			else if(source == this.college) {
				String fileName = college.getSelectedFileName();
				fileName = this.department.refresh(fileName);
				this.lecture.refresh(fileName);
			} 
			else if (source == this.department) {
				String fileName = this.department.getSelectedFileName();
				this.lecture.refresh(fileName);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void FileWrite(Object source) {
		this.cBasket = new CBasket();
		this.items = this.lecture.getLectureInfoArray();
		
		try {
			int index = 0;
			boolean found = false;
			
			for(index = 0; index < items.size() && !found; index++) {
				if (items.get(index).getName() == source) {
					found = true;
					selectedItem = items.get(index);
				}
			}
			
			this.cBasket.getItems(selectedItem);
			String name = this.selectedItem.getName();
			System.out.println(name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private class ListSelectionHandler implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent event) {
			refresh(event.getSource());
		}
	}
	
	private class MouseHandler implements MouseListener{
		
		@Override//마우스 떼는 순간 이벤트 발생
		public void mouseReleased(MouseEvent event) {
			 
		}

		@Override
		public void mouseClicked(MouseEvent event) {
			try {
				JTable jt = (JTable)event.getSource();
				int[] row = jt.getSelectedRows();
				Object name = jt.getValueAt(row[0], 0);
				FileWrite(name);
			}catch(ArrayIndexOutOfBoundsException e) {
				
			}
		}

		@Override
		public void mousePressed(MouseEvent event) {
			// TODO Auto-generated method stub
			//System.out.println("마우스 클릭");
		}

		@Override
		public void mouseEntered(MouseEvent event) {
			// TODO Auto-generated method stub
			// System.out.println("마우스 클릭");
		}

		@Override
		public void mouseExited(MouseEvent event) {
			// TODO Auto-generated method stub
			
		}

	}
	
}
