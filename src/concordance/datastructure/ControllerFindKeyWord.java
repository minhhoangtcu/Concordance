package concordance.datastructure;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import concordance.gui.Model;
import concordance.gui.View;
import concordance.gui.controllers.DisplayHelper;

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
				view.setDisplayField(DisplayHelper.getWordAndContent(word));
				view.setDisplayFieldViewToTop();
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
