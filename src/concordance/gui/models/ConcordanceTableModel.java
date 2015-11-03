package concordance.gui.models;

import javax.swing.table.AbstractTableModel;

import concordance.datastructure.WordNode;
import concordance.gui.Model;

@SuppressWarnings("serial")
public class ConcordanceTableModel extends AbstractTableModel {

	Model model;
	
	public ConcordanceTableModel(Model model) {
		this.model = model;
	}
	
	public int getRowCount() {
		return model.getTree().size();
	}

	public int getColumnCount() {
		return 2;
	}

	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "Word";
		case 1:
			return "Freq";
		default:
			return null;
		}
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		WordNode word = model.getWordNodes()[rowIndex];
		if (columnIndex == 0)
			return word.getWord();
		else
			return word.getCount();
	}
}
