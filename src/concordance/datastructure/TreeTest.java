package concordance.datastructure;

import static org.junit.Assert.*;

import org.junit.Test;

public class TreeTest {

	@Test
	public void treeAddingTest() {
		System.out.println("*********************************************");
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
		System.out.println("*********************************************");
		System.out.println("TREE ADDING TEST 2");
		RightThreadedTree tree = new RightThreadedTree();
		WordNode first = new WordNode("a", 1, 3, "a apple");
		WordNode second = new WordNode("y", 5, 3, "y u no");
		WordNode thrid = new WordNode("e", 25, 32, "e = mc2");
		WordNode forth = new WordNode("b", 12, 43, "big botty b");
		WordNode fifth = new WordNode("y", 17, 33, "yes yes yes y sir");
		WordNode sixth = new WordNode("q", 11, 63, "q stands for queue");
		WordNode seventh = new WordNode("i", 12, 33, "i means Minh");
		WordNode eaith = new WordNode("s", 71, 53, "s s s");
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
	public void treeAddingTest3() {
		System.out.println("TREE ADDING TEST 3");
		RightThreadedTree tree = new RightThreadedTree();
		WordNode first = new WordNode("a", 1, 3, "a apple");
		WordNode second = new WordNode("a", 1, 3, "a apple2");
		WordNode thrid = new WordNode("a", 1, 3, "a apple3");
		WordNode forth = new WordNode("b", 12, 43, "big botty b");
		WordNode fifth = new WordNode("y", 17, 33, "yes yes yes y sir");
		WordNode sixth = new WordNode("b", 12, 43, "big botty b2");
		WordNode seventh = new WordNode("y", 17, 33, "yes yes yes y sir2");
		WordNode eaith = new WordNode("y", 17, 33, "yes yes yes y sir3");
		tree.put(first);
		tree.put(second);
		tree.put(thrid);
		tree.put(forth);
		tree.put(fifth);
		tree.put(sixth);
		tree.put(seventh);
		tree.put(eaith);
		InOrderThreadedTraversal.printEverythingAlphabetically(tree.getRoot());
	}
	
	@Test
	public void treeIteratorTest() {
		System.out.println("TREE ITERATOR TEST");
		RightThreadedTree tree = new RightThreadedTree();
		WordNode first = new WordNode("a", 1, 3, "a apple");
		WordNode second = new WordNode("y", 5, 3, "y u no");
		WordNode thrid = new WordNode("e", 25, 32, "e = mc2");
		WordNode forth = new WordNode("b", 12, 43, "big botty b");
		WordNode fifth = new WordNode("y", 17, 33, "yes yes yes y sir");
		WordNode sixth = new WordNode("q", 11, 63, "q stands for queue");
		WordNode seventh = new WordNode("i", 12, 33, "i means Minh");
		WordNode eaith = new WordNode("s", 71, 53, "s s s");
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
