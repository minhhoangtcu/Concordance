package concordance.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import concordance.datastructure.RightThreadedTree;
import concordance.datastructure.WordNode;

public class ConcordanceReader {
	
	/**
	 * Take a buffered reader, analyze the text and construct Words Node and add to the data structure
	 * This method will execute with an assumption that error from the reader will not occur.
	 * @param cReader a buffered reader reading from any text file 
	 * @throws IOException something happened with the file
	 */
	public static RightThreadedTree read(BufferedReader cReader, HashMap<String, Boolean> map) throws IOException {
		String line = null;
		StringBuilder builder = new StringBuilder();
		RightThreadedTree tree = new RightThreadedTree();
		boolean isDone = false;
		
		int atParagraph = 1;
		// As long as there is still line to read or the builder still has words inside (isDone == false).
		while ((line = cReader.readLine()) != null | !isDone) {
			if (!isEndOfParagraph(line)) {
				builder.append(line + " "); //We need to include a space at the end of every line
				isDone = false;
			} else {
				List<String> sentences = TextBreaker.getSentences(builder.toString());
				builder.setLength(0); isDone = true;
				int atSentence = 1;
				for (String sen: sentences) {
					List<String> words = TextBreaker.getWords(sen);
					for (String w: words) {
						if (map != null) {
							if (!map.containsKey(w)) {
//								System.out.println(String.format("Added word %s \ts#: %d \tp#: %d\tcontext: %s", w, atSentence, atParagraph, sen));
								WordNode node = new WordNode(w);
								node.push(atParagraph, atSentence, sen);
								tree.put(node);
							}
						}
						else {
//							System.out.println(String.format("Added word %s \ts#: %d \tp#: %d\tcontext: %s", w, atSentence, atParagraph, sen));
							WordNode node = new WordNode(w);
							node.push(atParagraph, atSentence, sen);
							tree.put(node);
						}
					}
					atSentence++;
				}
				atParagraph++;
			}
		}
		cReader.close();
		return tree;
	}

	/**
	 * Check if the input is the end of a paragraph or not.
	 * Mostly, we indicate the end of a paragraph by an empty line between paragraphs.
	 * @param input String, the line that we want to check
	 * @return a boolean that determines if the input is a paragraph breaker
	 */
	private static boolean isEndOfParagraph(String input) {
		if (input == null) return true;
		else return input.trim().equals("");
	}
}
