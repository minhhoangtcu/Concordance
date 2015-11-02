package concordance.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class FilterWordsReader {
	
	public FilterWordsReader() {
	}

	/**
	 * Take a buffered reader, read the text and construct a map of frequently used words
	 * @param reader a specific text file in the right form.
	 * @return a map of frequently used words.
	 * @throws IOException
	 */
	public HashMap<String, Boolean> read(BufferedReader reader) throws IOException {
		String line = reader.readLine(); //Read the first line (Rank and Word)
		HashMap<String, Boolean> map = new HashMap<>();
		while ((line = reader.readLine()) != null) {
			String word = line.split("\t")[1].toLowerCase();
			if (!map.containsKey(word)) {
				map.put(word, true);
			}
		}
		return map;
	}
	
}
