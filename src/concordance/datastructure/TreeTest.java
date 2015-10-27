package concordance.datastructure;

import static org.junit.Assert.*;

import org.junit.Test;

public class TreeTest {

	@Test
	public void treeAddingTest() {
		System.out.println("*********************************************");
		System.out.println("TEST 1");
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
		System.out.println("*********************************************");
		System.out.println("TEST 2");
		RightThreadedTree tree = new RightThreadedTree();
		WordNode first = new WordNode("a");
		WordNode second = new WordNode("y");
		WordNode thrid = new WordNode("e");
		WordNode forth = new WordNode("b");
		WordNode fifth = new WordNode("z");
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
	public void treeGettingTest() {
		System.out.println("*********************************************");
		System.out.println("TEST 3");
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
		assertSame("e", tree.get("e").getWord());
		assertSame("a", tree.get("a").getWord());
		assertSame("d", tree.get("d").getWord());
		try {
			tree.get("z").getWord();
		}
		catch(IllegalArgumentException e) {
			//Good
			assertEquals(true, true);
		}
		System.out.println("Getting " + tree.get("e").getWord());
	}
}
