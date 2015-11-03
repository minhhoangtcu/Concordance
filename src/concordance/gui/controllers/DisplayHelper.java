package concordance.gui.controllers;

import concordance.datastructure.ContextNode;
import concordance.datastructure.WordNode;

public class DisplayHelper {
	
	public static String getWordAndContent(WordNode word) {
		StringBuilder builder = new StringBuilder();
		builder.append("<h2 style='font-family: Serif; color: navy'>" + word.getWord() + "</h2>");
		for (ContextNode cN : word) {
			builder.append(cN.toString() + "<br>");
		}
		builder.append("<br>");
		return builder.toString();
	}

}
