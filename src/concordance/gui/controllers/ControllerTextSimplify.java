package concordance.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import concordance.gui.Model;
import concordance.gui.View;

public class ControllerTextSimplify implements ActionListener {

	View view;
	Model model;
	
	public ControllerTextSimplify(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		turnSimpleDisplay();
	}

	private void turnSimpleDisplay() {
		if (view.getSimpleTextArea() == null) {
			initSimple();
		}
		if (model.isSimple()) {
			view.getDisplayPanel().add(view.getScrollPaneDisplay(), "cell 1 0,grow");
			view.getDisplayPanel().remove(view.getSimpleTextArea());
			view.getAdvancedPanel().setBtnSimplifyText("Turn On Simple Text");
			model.flipSimple();
		}
		else {
			view.getDisplayPanel().remove(view.getScrollPaneDisplay());
			view.getDisplayPanel().add(view.getSimpleTextArea(), "cell 1 0,grow");
			view.getAdvancedPanel().setBtnSimplifyText("Turn Off Simple Text");
			model.flipSimple();
		}
		view.validate();
		view.repaint();
	}

	private void initSimple() {
		JTextArea temp = new JTextArea(50, 50);
		view.setSimpleTextArea(temp);
	}
}
