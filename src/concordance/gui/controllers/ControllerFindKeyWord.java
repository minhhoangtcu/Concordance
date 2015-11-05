package concordance.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import concordance.datastructure.WordNode;
import concordance.gui.Model;
import concordance.gui.View;

public class ControllerFindKeyWord implements ActionListener {

	View view;
	Model model;
	
	public ControllerFindKeyWord(View view, Model model) {
		this.view = view;
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (model.isInitialized()) {
			String key = view.getTxtKeyword();
			try {
				WordNode word = model.getTree().get(key);
				if (model.isSimple()) {
					view.setDisplayFieldSimple(DisplayHelper.getWordAndContentSimple(word));
					view.setSimpleDisplayViewToTop();
				}
				else {
					view.setDisplayFieldHTML(DisplayHelper.getWordAndContentHTML(word));
					view.setDisplayFieldViewToTop();
				}
			}
			catch (IllegalArgumentException error) {
				view.setLblFeedback(error.getMessage());
			}
		}
		else {
			view.setLblFeedback("Please load a concordance first!");
		}
	}

}
