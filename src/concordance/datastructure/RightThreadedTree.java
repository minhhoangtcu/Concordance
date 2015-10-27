package concordance.datastructure;

public class RightThreadedTree implements ConcordanceTreeInterface {
	
	private WordNode root;
	private int size;
	
	public RightThreadedTree() {
		root = new WordNode("");
		root.setRightLink(root);
	}
	
	/**
	 * Put the node into the binary tree.
	 * Cannot put in a node that already exist in the tree
	 * @param node the node with provided info about its data
	 */
	public void put(WordNode node) throws IllegalArgumentException{
		if (node == null | node.getWord().equals("")) {
			throw new IllegalArgumentException("The input node is undefined");
		} else if (isEmpty()) {
			root.setLeftLink(node);
			node.setRightLink(root);
			node.setRightThread(true);
			size++;			
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
						addLeftNode(previous, node);
						return;
					}
				}
				else if (compare > 0) {
					if (current.getRightThread()) {
						addRightNode(current, node);
						return;
					}
					current = current.getRightLink();
				}
				else 
					throw new IllegalArgumentException("The node already exist in the list");
			}
		}
	}
	
	/**
	 * Get the node with the provided key in the binary tree
	 * @param the key of the node in the type of String
	 * @return the WordNode with the key similar to input key
	 */
	public WordNode get(String key) throws IllegalArgumentException{
		if (isEmpty())
			throw new NullPointerException("Empty tree.");
		else if (key.equals(""))
			throw new IllegalArgumentException("The input String is undefined");
		else {
			WordNode current = root.getLeftLink();
			while (true) {
				String currentKey = current.getWord();
				int compare = key.compareTo(currentKey);
				// For compare to > 0. The word appear after the argument word in unicode. Inverse holds true.
				if (compare < 0) {
					if (current.getLeftLink() == null)
						//Reached left-most node in the tree.
						throw new IllegalArgumentException("There is no node in the tree with the provided key");
					current = current.getLeftLink();
				}
				else if (compare > 0) {
					if (current.getRightThread())
						//Reached right-most node in the tree
						throw new IllegalArgumentException("There is no node in the tree with the provided key");
					current = current.getRightLink();
				} else
					return current;
			}
		}
	}
	
	/**
	 * Add the second node the left of the first node
	 * The right link of the inserting node is pointed to its predecessor.
	 * Since the right link is not really the right node, thread is set to true
	 * @param node the parent node
	 * @param addingNode the inserting node
	 */
	private void addLeftNode(WordNode node, WordNode addingNode) {
		//System.out.println(String.format("assigned %s and the left node of %s", addingNode.getWord(), node.getWord()));
		addingNode.setRightLink(node);
		addingNode.setRightThread(true);
		node.setLeftLink(addingNode);
		size++;
	}
	
	/**
	 * Add the second node to the right of the first node.
	 * The right link of the inserting node is pointed to its predecessor's successor
	 * If the first node is pointing to a thread on the right, then inserting node must also point to a thread.
	 * @param node the parent node
	 * @param addingNode the inserting node
	 */
	private void addRightNode(WordNode node, WordNode addingNode) {
		//System.out.println(String.format("assigned %s and the right node of %s", addingNode.getWord(), node.getWord()));
		addingNode.setRightLink(node.getRightLink());
		addingNode.setRightThread(node.getRightThread());
		node.setRightLink(addingNode);
		node.setRightThread(false);
		size++;
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
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * @return the root
	 */
	public WordNode getRoot() {
		return root;
	}

	@Override
	public WordNode max() {
		// TODO Auto-generated method stub
		return null;
	}
}
