package concordance.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import concordance.datastructure.FrequencyMap;
import concordance.datastructure.WordNode;
import concordance.gui.Model;
import concordance.gui.View;

public class ControllerFreqDescending implements ActionListener {

	View view;
	Model model;
	
	public ControllerFreqDescending(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (model.isInitialized()) {
			FrequencyMap map = model.getSortedMap();
			int max = map.getMax();
			StringBuilder builder = new StringBuilder();
			
			/*
			 * The Header part of the program
			 */
			if (model.isSimple()) {
				builder.append("Frequency Descendingly");
			}
			else {
				builder.append("<h1 style='text-align: center; margin: 0px'> Frequency Descendingly </h1>");
			}
			
			/*
			 * The body with all words
			 */
			for (int i = max; i > 0; i--) {
				if (map.getMap().containsKey(i)) {
					Stack<WordNode> currentStack = map.getMap().get(i);
					if (model.isSimple()) {
						builder.append(String.format("\nFrequency: %d \n\n", i));
						for (WordNode word: currentStack) {
							builder.append(DisplayHelper.getWordAndContentSimple(word));
						}
					}
					else {
						builder.append(String.format("<p style='text-align: center; font-style: italic; margin: 0px'> Frequency: %d <p>", i));
						for (WordNode word: currentStack) {
							builder.append(DisplayHelper.getWordAndContentHTML(word));
						}
						view.setDisplayFieldHTML(builder.toString());
						view.setDisplayFieldViewToTop();
					}
				}
			}
			
			/*
			 * Print out according to made chosen
			 */
			if (model.isSimple()) {
				view.setDisplayFieldSimple(builder.toString());
				view.setSimpleDisplayViewToTop();
			}
			else {
				view.setDisplayFieldHTML(builder.toString());
				view.setDisplayFieldViewToTop();
			}
			view.clearLblFeedback();
		}
		else {
			view.setLblFeedback("Please load a concordance first!");
		}
	}

}
