package concordance.gui;

import concordance.gui.controllers.ControllerLoadConcordance;

public class Control {
	
	Model model;
	View view;

	public Control(View view, Model model) {
		this.model = model;
		this.view = view;
		
		ControllerLoadConcordance ctlLoadCon = new ControllerLoadConcordance(view);
		
		view.getBtnLoadConcordance().addActionListener(ctlLoadCon);
	}

}
