package concordance.gui;

import java.util.HashMap;
import concordance.datastructure.FrequencyMap;
import concordance.datastructure.RightThreadedTree;
import concordance.datastructure.WordNode;
import concordance.gui.models.ConcordanceTableModel;

public class Model {
	
	private HashMap<String, Boolean> filterMap;
	private RightThreadedTree tree;
	private WordNode[] wordNodes;
	private ConcordanceTableModel tableModel;
	private FrequencyMap sortedMap;
	private boolean isInitialized;
	
	public Model() {
		isInitialized = false;
	}
	
	/**
	 * Finding a word is best used with the get method in tree datastructure
	 * This ensure O(nlogn) searching time.
	 * @param word the word that we want to display
	 * @return the contexture information of input word 
	 */
	public WordNode getWord(String word) {
		return tree.get(word);
	}
	
	/**
	 * Create a map with key corresponding to the frequency
	 * @return a frequency map
	 */
	public FrequencyMap initSortedMap() {
		if (isInitialized) {
			sortedMap = new FrequencyMap(tree);
			return sortedMap;
		}
		else
			return null;
	}
	
	/**
	 * The model that the table use. See more in the class <b>ConcordanceTableModel
	 * @return the model used by the table
	 */
	public ConcordanceTableModel initTableModel() {
		if (isInitialized) {
			initList();
			tableModel = new ConcordanceTableModel(this);
			return tableModel;
		}
		else
			return null;
	}
	
	/**
	 * Because the program use a list for human-interaction. Thus, selection for word is random.
	 * Storing all words in an array is most optimal.
	 * This ensure O(1) time and O(n) space
	 * @return an array of words extracted from the tree
	 */
	public WordNode[] initList() {
		if (isInitialized) {
			wordNodes = new WordNode[tree.size()];
			int i = 0;
			for (WordNode word: tree) {
				wordNodes[i] = word;
				i++;
			}
			return wordNodes;
		}
		else
			return null;
	}
	
	
	/**
	 * @return the filterMap
	 */
	public HashMap<String, Boolean> getFilterMap() {
		return filterMap;
	}

	/**
	 * @param filterMap the filterMap to set
	 */
	public void setFilterMap(HashMap<String, Boolean> filterMap) {
		this.filterMap = filterMap;
	}

	/**
	 * @return the tree
	 */
	public RightThreadedTree getTree() {
		return tree;
	}

	/**
	 * @param tree the tree to set
	 */
	public void setTree(RightThreadedTree tree) {
		this.tree = tree;
		isInitialized = true;
	}

	/**
	 * @return the wordNodes
	 */
	public WordNode[] getWordNodes() {
		return wordNodes;
	}

	/**
	 * @return the tableModel
	 */
	public ConcordanceTableModel getTableModel() {
		return tableModel;
	}
	
	/**
	 * @return the sortedMap
	 */
	public FrequencyMap getSortedMap() {
		return sortedMap;
	}



	public boolean isInitialized() {
		return isInitialized;
	}
}
