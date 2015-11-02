package concordance.datastructure;

public class InOrderThreadedTraversal {
	
	public static void printEverythingAlphabetically(WordNode head) {
		WordNode current = leftMost(head);
		while (current != null) {
			System.out.print("EIO: " + current.getWord());
			for (ContextNode cN: current) {
				System.out.println("\t" + cN.toString());
			}
			current = inOrderSuccessor(current);
		}
	}
	
	/**
	 * <p>Print all words from the given "head" node of a right threaded tree to console.
	 * <ul>
	 * <li>Go to the left most node, <b>u</b>, in the tree. Print out the data from <b>u</b>.
	 * <li>Go to the inorder successor of <b>u</b>.
	 * <li>Print out the result.
	 * </ul>
	 * @param the "head" node. The right link of this node should be threaded and point to itself.
	 */
	public static void printWordsAlphabetically(WordNode head) {
		WordNode current = leftMost(head);
		while (current != null) {
			System.out.println("WIO: " + current.getWord());
			current = inOrderSuccessor(current);
		}
	}
	
	/**
	 * Get the left-most node in the left sub-tree of the given node
	 * If there given node is non-exist, the method returns null
	 * @param node any Node within the tree
	 * @return left-most node in the left sub-tree of the given node
	 */
	public static WordNode leftMost(WordNode node) {
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
	
	/**
	 * Get the inorder successor of a node in a threaded binary tree.
	 * <u>
	 * <li>If the node has a right child, inorder successor is the left most node of the right sub tree
	 * <li>else inorder successor is the closest ancestor, <b>v</b>, of <b>u</b> such that <b>u</b> is descended from the left child of <b>v</b>.
	 * </u>
	 * @param node any valid Node within the tree.
	 * @return the inorder successor of the inputted node
	 */
	public static WordNode inOrderSuccessor(WordNode node) {
		if (!node.rightThread) {
			return leftMost(node.getRightLink());
		}
		else if (node.getRightLink().getWord().equals("")) // If head, then stop
			return null;
		else 
			return node.getRightLink(); 
	}

}
