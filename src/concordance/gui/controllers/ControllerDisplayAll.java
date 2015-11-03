package concordance.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;

import concordance.datastructure.InOrderThreadedTraversal;
import concordance.datastructure.WordNode;
import concordance.gui.Model;
import concordance.gui.View;

public class ControllerDisplayAll implements ActionListener {
	
	View view;
	Model model;

	public ControllerDisplayAll(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		WordNode head = model.getTree().getRoot();
		String text = InOrderThreadedTraversal.printEverythingAlphabeticallyTo(head);
		view.setDisplayField(text);
		view.setDisplayFieldViewToTop();
	}
	
}
