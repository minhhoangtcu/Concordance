package concordance.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
			long startTime = System.currentTimeMillis();
			StringBuilder builder = new StringBuilder();
			builder.append("<h1 style='text-align: center; margin: 0px'> All Words </h1>");
			builder.append(String.format("<p style='text-align: center; font-style: italic; margin: 0px'> Aphabetically <p>"));
			for (WordNode word: model.getTree()) {
				builder.append(DisplayHelper.getWordAndContent(word));
			}
			view.setDisplayField(builder.toString());
			view.setDisplayFieldViewToTop();
			view.setLblFeedback("Displaying all words takes: " + (System.currentTimeMillis()-startTime) + " (ms)");
//			System.out.println("Displaying all words takes: " + (System.currentTimeMillis()-startTime) + " (ms)");
		}
		else {
			view.setLblFeedback("Please load a concordance first!");
		}
	}
}
