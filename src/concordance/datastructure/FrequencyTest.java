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
		
		FrequencyMap freqMap = new FrequencyMap(tree);
		HashMap<Integer, Stack<WordNode>> fMap = freqMap.getMap();
		for (int i = 0; i <= freqMap.getMax(); i++) {
			if (fMap.containsKey(i)) {
				for (WordNode word: fMap.get(i)) {
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
