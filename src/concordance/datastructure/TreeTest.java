package concordance.datastructure;

import org.junit.Test;

public class TreeTest {

	@Test
	public void treeAddingTest() {
		System.out.println("TREE ADDING TEST 1");
		RightThreadedTree tree = new RightThreadedTree();
		WordNode first = new WordNode("a");
		WordNode second = new WordNode("c");
		WordNode thrid = new WordNode("d");
		WordNode forth = new WordNode("b");
		WordNode fifth = new WordNode("e");
		tree.put(first);
		tree.put(second);
		tree.put(thrid);
		tree.put(forth);
		tree.put(fifth);
		InOrderThreadedTraversal.printWordsAlphabetically(tree.getRoot());
	}

	@Test
	public void treeAddingTest2() {
		System.out.println("TREE ADDING TEST 2");
		RightThreadedTree tree = new RightThreadedTree();
		WordNode first = new WordNode("a");
		WordNode second = new WordNode("y");
		WordNode thrid = new WordNode("e");
		WordNode forth = new WordNode("b");
		WordNode fifth = new WordNode("y");
		WordNode sixth = new WordNode("q");
		WordNode seventh = new WordNode("i");
		WordNode eaith = new WordNode("s");
		tree.put(first);
		tree.put(second);
		tree.put(thrid);
		tree.put(forth);
		tree.put(fifth);
		tree.put(sixth);
		tree.put(seventh);
		tree.put(eaith);
		InOrderThreadedTraversal.printWordsAlphabetically(tree.getRoot());
	}
	
	@Test
	public void treeIteratorTest() {
		System.out.println("TREE ITERATOR TEST");
		RightThreadedTree tree = new RightThreadedTree();
		WordNode first = new WordNode("a");
		WordNode second = new WordNode("y");
		WordNode thrid = new WordNode("e");
		WordNode forth = new WordNode("b");
		WordNode fifth = new WordNode("y");
		WordNode sixth = new WordNode("q");
		WordNode seventh = new WordNode("i");
		WordNode eaith = new WordNode("s");
		tree.put(first);
		tree.put(second);
		tree.put(thrid);
		tree.put(forth);
		tree.put(fifth);
		tree.put(sixth);
		tree.put(seventh);
		tree.put(eaith);
		for (WordNode word: tree) {
			System.out.println(word.getWord());
		}
	}
}