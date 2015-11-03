package concordance.datastructure;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;
import org.junit.Test;
import concordance.reader.ConcordanceReader;
import concordance.reader.FilterWordsReader;

public class FrequencyTest {

	@Test
	public void test() throws IOException {
		BufferedReader fReader = new BufferedReader(new FileReader("MostCommonWords.txt"));
		BufferedReader cReader = new BufferedReader(new FileReader("AChristmasCarol.txt"));
		
		HashMap<String, Boolean> map = FilterWordsReader.read(fReader);
		RightThreadedTree tree = ConcordanceReader.read(cReader, map);
		
		HashMap<Integer, Stack<WordNode>> freqMap = FrequencyMap.getMap(tree);
		for (int i = 0; i <= FrequencyMap.getMaxFreq(freqMap); i++) {
			if (freqMap.containsKey(i)) {
				for (WordNode word: freqMap.get(i)) {
					System.out.println(word.getCount() + "\t" + word.getWord());
//					System.out.println(word.getCount() + "\t" + word.getWord() + "\t" +word.toString());
				}
			}
		}
		
		try {
			Thread.sleep(600000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
