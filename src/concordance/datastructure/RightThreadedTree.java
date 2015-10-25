package concordance.datastructure;

public class RightThreadedTree implements ConcordanceTreeInterface {
	
	private WordNode root;
	private int size;
	
	public RightThreadedTree() {
		root = new WordNode("head");
		root.setRightLink(root);
	}
	
	/**
	 * 
	 */
	public void put(WordNode node) {
		if (isEmpty()) {
			root.setLeftLink(node);
			size++;
			System.out.println(String.format("assigned %s as the first node", node.getWord()));
		} else {
			WordNode current = root.getLeftLink();
			WordNode previous = null;
			while (true) {
				String key = node.getWord();
				String currentKey = current.getWord();
				int compare = key.compareTo(currentKey);
				// For compare to > 0. The word appear after the argument word in unicode. Inverse holds true.
				if (compare < 0) {
					previous = current;
					current = current.getLeftLink();
					if (current == null) {
						System.out.println(String.format("assigned %s and the left node of %s", node.getWord(), previous.getWord()));
						previous.setLeftLink(node);
						size++;
						return;
					}
				}
				else if (compare > 0) {
					previous = current;
					current = current.getRightLink();
					if (current == null) {
						System.out.println(String.format("assigned %s and the right node of %s", node.getWord(), previous.getWord()));
						previous.setRightLink(node);
						size++;
						return;
					}
				}
				else 
					return;
			}
		}
	}
	
	/**
	 * Give the left-most node in the tree (the lowest in value)
	 * @param the left-most node in the tree
	 */
	public WordNode min() {
		if (size == 0) 
			return null;
		else {
			WordNode current = root.getLeftLink();
			while (current.getLeftLink() != null) {
				current = current.getLeftLink();
			}
			return current;
		}
	}
	
	/**
	 * Give the left-most node in the left sub-tree of the given node
	 * If there given node is non-exist, the method returns null
	 * @param node any Node within the tree
	 * @return left-most node in the left sub-tree of the given node
	 */
	public WordNode leftMost(WordNode node) {
		if (node == null)
			return null;
		else {
			WordNode current = node;
			while (current.getLeftLink() != null) {
				current = current.getLeftLink();
			}
			return current;
		}
	}
	
	public WordNode get(String key) {
		return null;
	}

	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
}
