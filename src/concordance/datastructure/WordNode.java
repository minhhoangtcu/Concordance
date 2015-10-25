package concordance.datastructure;

public class WordNode implements WordNodeInterface {
	
	private String word;
	private ContextNode context;
	private int count;
	private WordNode left, right;
	boolean rightThread;
	
	public WordNode() {
	}
	
	public WordNode(String word) {
		this.word = word;
		context = new ContextNode();
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

}
