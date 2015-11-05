package concordance.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import concordance.datastructure.FrequencyMap;
import concordance.datastructure.WordNode;
import concordance.gui.Model;
import concordance.gui.View;

public class ControllerDisplaySmallest implements ActionListener {
	
	View view;
	Model model;

	public ControllerDisplaySmallest(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (model.isInitialized()) {
			FrequencyMap map = model.initSortedMap();
			int min = map.getMin();
			Stack<WordNode> smallestStack = map.getMap().get(min);
			StringBuilder builder = new StringBuilder();
			if (model.isSimple()) {
				builder.append(String.format("Least Occurrences \nFrequency: %d \n\n\n", min));
				for (WordNode word: smallestStack) {
					builder.append(DisplayHelper.getWordAndContentSimple(word));
				}
				view.setDisplayFieldSimple(builder.toString());
				view.setSimpleDisplayViewToTop();
			}
			else {
				builder.append("<h1 style='text-align: center; margin: 0px'> Least Occurrences </h1>");
				builder.append(String.format("<p style='text-align: center; font-style: italic; margin: 0px'> Frequency: %d <p>", min));
				for (WordNode word: smallestStack) {
					builder.append(DisplayHelper.getWordAndContentHTML(word));
				}
				view.setDisplayFieldHTML(builder.toString());
				view.setDisplayFieldViewToTop();
			}
		}
		else {
			view.setLblFeedback("Please load a concordance first!");
		}
	}
}
