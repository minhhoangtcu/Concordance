package concordance.gui.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import concordance.gui.Model;
import concordance.gui.View;

public class ControllerList implements MouseListener {

	View view;
	Model model;
	
	public ControllerList(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = view.getTable().getSelectedRow();
		String word = (String) view.getTable().getValueAt(row, 0);
		if (model.isSimple()) {
			view.setDisplayFieldSimple(DisplayHelper.getWorkAndContentSimple(model.getWord(word)));
			view.setSimpleDisplayViewToTop();
		}
		else { 
			view.setDisplayFieldHTML(DisplayHelper.getWordAndContentHTML(model.getWord(word)));
			view.setDisplayFieldViewToTop();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
