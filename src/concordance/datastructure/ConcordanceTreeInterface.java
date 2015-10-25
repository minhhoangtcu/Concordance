package concordance.datastructure;

public interface ConcordanceTreeInterface {
	
	public int size();
	public WordNode get(String key);
	public void put(WordNode node);
	public WordNode min();
	public WordNode leftMost(WordNode node);

}
