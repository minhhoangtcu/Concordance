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
		
		FilterWordsReader filterReader = new FilterWordsReader();
		HashMap<String, Boolean> map = filterReader.read(fReader);
		ConcordanceReader concorReader = new ConcordanceReader();
		RightThreadedTree tree = concorReader.read(cReader, map);
		
		HashMap<Integer, Stack<WordNode>> freqMap = FrequencyMap.getMap(tree);
		int i = 1;
		while (freqMap.containsKey(i)) {
			for (WordNode word: freqMap.get(i)) {
				System.out.println(word.getCount() + "\t" +word.toString());
			}
			i++;
		}
		
		try {
			Thread.sleep(600000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
