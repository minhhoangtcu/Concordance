package concordance.gui.controllers;

import concordance.datastructure.ContextNode;
import concordance.datastructure.WordNode;

public class DisplayHelper {
	
	public static String getWordAndContentHTML(WordNode word) {
		StringBuilder builder = new StringBuilder();
		builder.append("<h2 style='font-family: Serif; color: navy'>" + word.getWord() + "</h2>");
		for (ContextNode cN : word) {
			builder.append(cN.toStringHTML() + "<br>");
		}
		builder.append("<br>");
		return builder.toString();
	}
	
	public static String getWordAndContentSimple(WordNode word) {
		StringBuilder builder = new StringBuilder();
		builder.append(word.getWord() + "\n");
		for (ContextNode cN : word) {
			builder.append(cN.toStringSimple() + "\n");
		}
		builder.append("\n");
		return builder.toString();
	}

}
