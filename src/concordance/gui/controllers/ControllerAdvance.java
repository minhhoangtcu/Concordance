package concordance.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import concordance.gui.Model;
import concordance.gui.View;
import concordance.gui.ViewAdvanced;

public class ControllerAdvance implements ActionListener {
	
	View view;
	Model model;

	public ControllerAdvance(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		turnAdvanced();
	}
	
	private void turnAdvanced() {
		if (view.getAdvancedPanel() == null) {
			expandGUI();
		}
		else {
			if (view.getAdvancedPanel().isVisible()) {
				view.getAdvancedPanel().setVisible(false);
				view.setSize(900, 700);
				view.setBtnAdvancedText("Show Advanced");
			}
			else { 
				view.getAdvancedPanel().setVisible(true);
				view.setSize(900, 736);
				view.setBtnAdvancedText("Hide Advanced");
			}
		}
	}
	
	private void expandGUI() {
		ViewAdvanced advancedPanel = new ViewAdvanced();
		view.getCommandsPanel().add(advancedPanel, "cell 0 5 5 1,alignx center,aligny center,hidemode 1");
		view.setAdvancedPanel(advancedPanel);
		view.setSize(900, 736);
		view.setBtnAdvancedText("Hide Advanced");
	}
}
