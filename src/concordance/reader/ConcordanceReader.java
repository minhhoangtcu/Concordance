package concordance.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class ConcordanceReader {
	
	public ConcordanceReader() {
		// TODO Auto-generated constructor stub
	}
	
	public static void read(BufferedReader reader) throws IOException {
		String line = null;
		StringBuilder builder = new StringBuilder();
		while ((line = reader.readLine()) != null) {
			if (!isEndOfParagraph(line)) {
				builder.append(line);
			} else {
				List<String> sentences = SentenceBreaker.getSentencesDefault(builder.toString());
				
			}
		}
		reader.close();
	}

	/*
	 * Check if the input is the end of a paragraph or not.
	 * Mostly, we indicate the end of a paragraph by an empty line between paragraphs.
	 * @param input String, the line that we want to check
	 * @return a boolean that determines if the input is a paragraph breaker
	 */
	private static boolean isEndOfParagraph(String input) {
		return input.trim().equals("");
	}
}
