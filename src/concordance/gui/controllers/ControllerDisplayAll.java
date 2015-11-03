package concordance.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import concordance.datastructure.ContextNode;
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
		if (model.isInitialized()) {
			StringBuilder builder = new StringBuilder();
			for (WordNode word: model.getTree()) {
				builder.append(DisplayHelper.getWordAndContent(word));
			}
			view.setDisplayField(builder.toString());
			view.setDisplayFieldViewToTop();
		}
		else {
			view.setLblFeedback("Please load a concordance first!");
		}
	}
}
