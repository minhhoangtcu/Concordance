package concordance.datastructure;

public class ContextNode implements ContextNodeInterface {
	
	private int pNumber, sNumber;
	private String context;
	private ContextNode next;
	
	public ContextNode() {
	}

	public int getParagraphNum() {
		return pNumber;
	}

	public void setParagraphNum(int i) {
		pNumber = i;
	}

	public int getSentenceNum() {
		return sNumber;
	}

	public void setSentenceNum(int i) {
		sNumber = i;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String s) {
		context = s;
	}

	public ContextNode getNext() {
		return next;
	}

	public void setNext(ContextNode n) {
		next = n;
	}

}
