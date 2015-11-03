package concordance.gui;

import concordance.gui.controllers.ControllerDisplayAll;
import concordance.gui.controllers.ControllerList;
import concordance.gui.controllers.ControllerLoadConcordance;
import concordance.gui.controllers.ControllerLoadFilter;

public class Control {
	
	Model model;
	View view;

	public Control(View view, Model model) {
		this.model = model;
		this.view = view;
		
		ControllerLoadConcordance ctlLoadCon = new ControllerLoadConcordance(view, model);
		ControllerLoadFilter ctlLoadFilter = new ControllerLoadFilter(view, model);
		ControllerList ctlList = new ControllerList(view, model);
		ControllerDisplayAll ctlDisplayAll = new ControllerDisplayAll(view, model);
		
		view.getBtnLoadConcordance().addActionListener(ctlLoadCon);
		view.getBtnLoadCommonWords().addActionListener(ctlLoadFilter);
		view.getTable().addMouseListener(ctlList);
		view.getBtnDisplayAll().addActionListener(ctlDisplayAll);
	}

}
