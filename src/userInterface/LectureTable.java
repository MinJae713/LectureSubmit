package userInterface;

import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CLecture;
import entity.ELecture;

public class LectureTable extends JTable {
	private static final long serialVersionUID = 1L;
	// service
	private CLecture cLecture;
	private Vector<ELecture> eLecture;
	private DefaultTableModel tableModel;
	// model
	
	public LectureTable(MouseListener mouseListener) {
		// attributes : 자신이 갖는 고유값
		this.setPreferredSize(new Dimension(100, 200)); 
		// service 
		this.cLecture = new CLecture();
		// model : JList가 보여주는 데이터를 보유하고 관리함.
		String[] columnNames = {"강좌명",
				"담당교수",
				"시간"
		};
				
		this.tableModel = new DefaultTableModel(null, columnNames);
		
		this.setModel(this.tableModel);
		this.addMouseListener(mouseListener);
	}
	
	public Vector<ELecture> getLectureInfoArray() {
		return this.eLecture;
	}
	
	public void refresh(String fileName) throws FileNotFoundException {
		this.eLecture = this.cLecture.getItems("data/" + fileName);
		
		this.tableModel.setRowCount(0);
		for(ELecture eLecture : this.eLecture) {
			Vector<String> row = new Vector<String>();
			row.add(eLecture.getName());
			row.add(eLecture.getProfessor());
			row.add(eLecture.getTime());
			this.tableModel.addRow(row);
		}
		this.updateUI();
	}

}
