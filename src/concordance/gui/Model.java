package concordance.gui;

import java.util.HashMap;

import concordance.datastructure.RightThreadedTree;

public class Model {
	
	HashMap<String, Boolean> filterMap;
	RightThreadedTree tree;
	
	public Model() {
		
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

}
