package concordance.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import concordance.datastructure.WordNode;
import concordance.gui.Model;
import concordance.gui.View;

public class ControllerFindWordsBeginWith implements ActionListener {

	View view;
	Model model;
	
	public ControllerFindWordsBeginWith(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String begin = view.getTxtBeginWord().trim();
		int length = begin.length();
		boolean isFound = false;
		StringBuilder builder = new StringBuilder();
		builder.append("<h1 style='text-align: center; margin: 0px'> Starting Words</h1>");
		builder.append(String.format("<p style='text-align: center; font-style: italic; margin: 5px; font-style: 30px'> with <b>%s</b> <p>", begin));
		
		for (WordNode word: model.getWordNodes()) {
			int currentWordLength = word.getWord().length();
			if (length <= currentWordLength) {
				String currentStartWith = word.getWord().substring(0, length);
				if (currentStartWith.equals(begin)) {
					builder.append(DisplayHelper.getWordAndContent(word));
					isFound = true;
				}
			}
		}
		
		if (isFound) {
			view.setDisplayField(builder.toString());
			view.setDisplayFieldViewToTop();
			view.clearLblFeedback();
		}
		else {
			view.setLblFeedback("Cannot find words starting with " + begin);
		}
	}
}