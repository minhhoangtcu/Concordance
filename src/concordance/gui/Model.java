package concordance.gui;

import java.util.HashMap;
import concordance.datastructure.RightThreadedTree;
import concordance.datastructure.WordNode;
import concordance.gui.models.ConcordanceTableModel;

public class Model {
	
	HashMap<String, Boolean> filterMap;
	RightThreadedTree tree;
	WordNode[] wordNodes;
	ConcordanceTableModel tableModel;
	
	public Model() {
		
	}
	
	public String displayWord(String word) {
		WordNode node = tree.get(word);
		return node.toString();
	}
	
	/**
	 * The model that the table use. See more in the class <b>ConcordanceTableModel
	 * @return the model used by the table
	 */
	public ConcordanceTableModel initTableModel() {
		if (wordNodes == null) {
			return null;
		}
		tableModel = new ConcordanceTableModel(this);
		return tableModel;
	}
	
	/**
	 * Because the program use a list for human-interaction. Thus, selection for word is random.
	 * Storing all words in an array is most optimal.
	 * @return an array of words extracted from the tree
	 */
	public WordNode[] initList() {
		if (tree == null) {
			return null;
		}
		wordNodes = new WordNode[tree.size()];
		int i = 0;
		for (WordNode word: tree) {
			wordNodes[i] = word;
			i++;
		}
		return wordNodes;
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
	}

	/**
	 * @return the wordNodes
	 */
	public WordNode[] getWordNodes() {
		return wordNodes;
	}

	/**
	 * @param wordNodes the wordNodes to set
	 */
	public void setWordNodes(WordNode[] wordNodes) {
		this.wordNodes = wordNodes;
	}



	/**
	 * @return the tableModel
	 */
	public ConcordanceTableModel getTableModel() {
		return tableModel;
	}

	/**
	 * @param tableModel the tableModel to set
	 */
	public void setTableModel(ConcordanceTableModel tableModel) {
		this.tableModel = tableModel;
	}

}
