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
			view.getScrollPaneDisplay().getViewport().remove(view.getSimpleTextArea());
			view.getScrollPaneDisplay().getViewport().add(view.getDisplayField());			
			view.getAdvancedPanel().setBtnSimplifyText("Turn On Simple Text");
			view.setLblFeedback("Switched to Simple Display");
			model.flipSimple();
		}
		else {
			view.getScrollPaneDisplay().getViewport().remove(view.getDisplayField());
			view.getScrollPaneDisplay().getViewport().add(view.getSimpleTextArea());			
			view.getAdvancedPanel().setBtnSimplifyText("Turn Off Simple Text");
			view.setLblFeedback("Switched to Styled Display");
			model.flipSimple();
		}
		view.validate();
		view.repaint();
	}

	private void initSimple() {
		JTextArea temp = new JTextArea(20, 50);
		temp.setLineWrap(true);
		view.setSimpleTextArea(temp);
	}
}
