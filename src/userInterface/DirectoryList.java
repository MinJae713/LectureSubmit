package userInterface;

import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

import control.CDirectory;
import entity.EDirectory;

public class DirectoryList extends JList<String> {
		// attributes
		private static final long serialVersionUID = 1L;
		// service
		private CDirectory cDirectory;
		private Vector<EDirectory> eDirectories;
		// model
		private Vector<String> listData;
		
		public DirectoryList(ListSelectionListener listSelectionListener) {
			// attributes : 자신이 갖는 고유값
			this.setPreferredSize(new Dimension(100, 200)); 
			// service 
			this.cDirectory = new CDirectory();
			// model : JList가 보여주는 데이터를 보유하고 관리함.
			this.listData = new Vector<String>();
			this.setListData(this.listData);
			// event handler
			this.addListSelectionListener(listSelectionListener);
			this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			} 
		
		public String getSelectedFileName() {
			int selectedIndex = this.getSelectedIndex();
			return this.eDirectories.get(selectedIndex).getHyperLink();
		}
		
		public String refresh(String fileName) throws FileNotFoundException {
			this.eDirectories = this.cDirectory.getItems("data/" + fileName);
			
			this.listData.clear();
			for(EDirectory eDirectory : eDirectories) {
				this.listData.add(eDirectory.getName());
			}
			this.setSelectedIndex(0);
			this.updateUI();
			
			return this.eDirectories.get(0).getHyperLink();
		}
		
}
