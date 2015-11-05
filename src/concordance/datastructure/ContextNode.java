package concordance.datastructure;

public class ContextNode implements ContextNodeInterface {
	
	private int pNumber, sNumber;
	private String context;
	private ContextNode next;
	
	public ContextNode() {
		
	}
	
	public ContextNode(int pNumber, int sNumber, String context) {
		this.pNumber = pNumber;
		this.sNumber = sNumber;
		this.context = context;
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

	public String toStringHTML() {
		StringBuilder builder = new StringBuilder();
		builder.append("<b>Paragraph number:</b> \t" + pNumber + "<br>");
		builder.append("<b>Sentence number:</b> \t" + sNumber + "<br>");
		builder.append("<b>Context:</b> " + context + "<br>");
		return builder.toString();
	}
	
}
