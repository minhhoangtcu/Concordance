package concordance.datastructure;

import java.util.HashMap;
import java.util.Stack;

public class FrequencyMap {
	
	/**
	 * 
	 * @param tree
	 * @return
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

}
