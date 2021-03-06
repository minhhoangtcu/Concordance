package concordance.datastructure;

import java.util.HashMap;
import java.util.Stack;

public class FrequencyMap {
	
	private int max, min;
	private HashMap<Integer, Stack<WordNode>> sortedMap;
	
	/**
	 * Sort the words from a tree and put them into a map.
	 * This support fast getting an insertion and getting.
	 */
	public FrequencyMap(RightThreadedTree tree) {
		sortedMap = new HashMap<>(7);
		for (WordNode word: tree) {
			int freq = word.getCount();
			if (!sortedMap.containsKey(freq)) {
				Stack<WordNode> temp = new Stack<>();
				temp.push(word);
				sortedMap.put(freq, temp);
			}
			else {
				sortedMap.get(freq).push(word);
			}
		}
		initMax(sortedMap);
		initMin(sortedMap);
	}
	
	/**
	 * Sort the words from a tree and put them into a map.
	 * This support fast getting an insertion and getting.
	 * @param tree RightThreadTree
	 * @return a map with key as the frequency that map to a stack contains all words with that frequency
	 */
	public HashMap<Integer, Stack<WordNode>> getMap() {
		return sortedMap;
	}

	public int getMax() {
		return max;
	}
	
	public int getMin() {
		return min;
	}
	
	public void initMax(HashMap<Integer, Stack<WordNode>> freqMap) {
		max = 1; // if the map is not empty, we always have a word with at least 1 occurrence
		for (int j: freqMap.keySet().toArray(new Integer[freqMap.keySet().size()])) {
			if (max < j)
				max = j;
		}
	}
	
	public void initMin(HashMap<Integer, Stack<WordNode>> freqMap) {
		min = max; // work our way back, because min can be 2 or even 3.
		for (int j: freqMap.keySet().toArray(new Integer[freqMap.keySet().size()])) {
			if (min > j)
				min = j;
		}
	}
}
