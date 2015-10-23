package concordance.datastructure;

public class WordNode implements WordNodeInterface {
	
	private String word;
	private ContextNode context;
	private int count;
	private WordNode left, right;
	boolean rightThread;
	
	public WordNode(String word) {
		this.word = word;
		context = new ContextNode();
	}

	public void setLeft(WordNode node) {
		left = node;
	}
	
	public WordNode getLeft() {
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

	public int getCount() {
		return count;
	}

	public void setContextLink(ContextNode s) {
		context = s;
	}

	public ContextNode getContextLink() {
		return context;
	}

	public void setRightLink(WordNode node) {
		
	}

	public WordNode getRightLink() {
		return right;
	}

	public void setRightThread(boolean b) {
		rightThread = false;
	}

	public boolean getRightThread() {
		return rightThread;
	}

}
