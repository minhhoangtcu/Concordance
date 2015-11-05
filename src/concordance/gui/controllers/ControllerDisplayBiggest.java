package concordance.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import concordance.datastructure.FrequencyMap;
import concordance.datastructure.WordNode;
import concordance.gui.Model;
import concordance.gui.View;

public class ControllerDisplayBiggest implements ActionListener {

	View view;
	Model model;
	
	public ControllerDisplayBiggest(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (model.isInitialized()) {
			FrequencyMap map = model.initSortedMap();
			int max = map.getMax();
			Stack<WordNode> biggestStack = map.getMap().get(max);
			StringBuilder builder = new StringBuilder();
			builder.append("<h1 style='text-align: center; margin: 0px'> Most Occurrences </h1>");
			builder.append(String.format("<p style='text-align: center; font-style: italic; margin: 0px'> Frequency: %d <p>", max));
			for (WordNode word: biggestStack) {
				builder.append(DisplayHelper.getWordAndContentHTML(word));
			}
			view.setDisplayFieldHTML(builder.toString());
			view.setDisplayFieldViewToTop();
		}
		else {
			view.setLblFeedback("Please load a concordance first!");
		}
	}
}
