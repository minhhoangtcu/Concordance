package concordance.datastructure;

public interface WordNodeInterface {
	public void setLeftLink(WordNode node);
	public WordNode getLeftLink();
	public void setWord(String s);
	public String getWord();
	public void setCount(int i);
	public int getCount();
	public void setContextLink(ContextNode s);
	public ContextNode getContextLink();
	public void setRightLink(WordNode node);
	public WordNode getRightLink();
	public void setRightThread(boolean b);
	public boolean getRightThread();
}
