package concordance.datastructure;

import java.util.HashMap;
import java.util.Stack;

public class FrequencyMap {
	
	/**
	 * Sort the words from a tree and put them into a map.
	 * This support fast getting an insertion and getting.
	 * @param tree RightThreadTree
	 * @return a map with key as the frequency that map to a stack contains all words with that frequency
	 */
	public static HashMap<Integer, Stack<WordNode>> getMap(RightThreadedTree tree) {
		HashMap<Integer, Stack<WordNode>> map = new HashMap<>(7);
		for (WordNode word: tree) {
			int freq = word.getCount();
			if (!map.containsKey(freq)) {
				Stack<WordNode> temp = new Stack<>();
				temp.push(word);
				map.put(freq, temp);
			}
			else {
				map.get(freq).push(word);
			}
		}
		return map;
	}

	public static int getMaxFreq(HashMap<Integer, Stack<WordNode>> freqMap) {
		int max = 0;
		for (int j: freqMap.keySet().toArray(new Integer[freqMap.keySet().size()])) {
			if (max < j)
				max = j;
		}
		return max;
	}
	
}
