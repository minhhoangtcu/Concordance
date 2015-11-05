package concordance.datastructure;

import java.util.Iterator;

public class WordNode implements WordNodeInterface, Iterable<ContextNode>{
	
	private String word;
	private ContextNode contextNewest;
	private int count;
	private WordNode left, right;
	boolean rightThread;
	
	public WordNode() {
		count = 1;
	}
	
	public WordNode(String word) {
		this.word = word;
		count = 1;
	}
	
	public WordNode(String word, int pNumber, int sNumber, String context) {
		this.word = word;
		push(pNumber, sNumber, context);
		count = 1;
	}
	
	public void push(int pNumber, int sNumber, String context) {
		ContextNode node = new ContextNode(pNumber, sNumber, context);
		push(node);
	}
	
	public void push(ContextNode node) {
		node.setNext(contextNewest);
		contextNewest = node;
	}
	
	public void setLeftLink(WordNode node) {
		left = node;
	}
	
	public WordNode getLeftLink() {
		return left;
	}

	public void setWord(String s) {
		word = s;
	}

	public String getWord() {
		return word;
	}

	public void setCount(int i) {
		count = i;
	}
	
	public void increaseCount() {
		count++;
	}

	public int getCount() {
		return count;
	}

	public void setContextLink(ContextNode s) {
		contextNewest = s;
	}

	public ContextNode getContextLink() {
		return contextNewest;
	}

	public void setRightLink(WordNode node) {
		right = node;
	}

	public WordNode getRightLink() {
		return right;
	}

	public void setRightThread(boolean b) {
		rightThread = b;
	}

	public boolean getRightThread() {
		return rightThread;
	}
	
	/**
	 * <p>Return an html form of all of the word's context.<br>
	 */
	public String toStringHTML() {
		StringBuilder builder = new StringBuilder();
		builder.append("<html>");
		
		for (ContextNode cN: this) {
			builder.append(cN.toStringHTML() + "<br>");
		}
		
		builder.append("</html>");
		return builder.toString();
	}
	
	public String toStringSimple() {
		StringBuilder builder = new StringBuilder();
		for (ContextNode cN: this) {
			builder.append(cN.toStringSimple() + "\n");
		}
		return builder.toString();
	}

	@Override
	public Iterator<ContextNode> iterator() {
		return new ContextIterator();
	}
	
	private class ContextIterator implements Iterator<ContextNode>{

		private ContextNode current = contextNewest;
		private ContextNode previous = null;
		
		@Override
		public boolean hasNext() {
			return (current != null);
		}

		@Override
		public ContextNode next() {
			previous = current;
			current = current.getNext();
			return previous;
		}
	}
}
