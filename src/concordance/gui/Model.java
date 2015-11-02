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
	
	public ConcordanceTableModel initTableModel() {
		if (wordNodes == null) {
			return null;
		}
		tableModel = new ConcordanceTableModel(this);
		return tableModel;
	}
	
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
