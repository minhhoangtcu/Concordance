package concordance.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import concordance.datastructure.RightThreadedTree;
import concordance.datastructure.WordNode;

public class ReaderTest {
	
	@Test
	public void testReader() throws IOException {
		System.out.println("TEST READER"); System.out.println();
		ConcordanceReader cReader = new ConcordanceReader();
		BufferedReader bReader = new BufferedReader(new FileReader("AChristmasCarol.txt"));
		RightThreadedTree tree = cReader.read(bReader);
		for (WordNode word: tree) {
			System.out.println("**********************");
			System.out.println(word.getWord());
			System.out.println(word.toString());
		}
		System.out.println("**********************************************");
	}

	@Test
	public void testSentenceBreakerDefault() {
		System.out.println("DEFAULT"); System.out.println();
		String text = "Alice was beginning to get very tired of sitting by her sister on the bank,"
				+ " and of having nothing to do:  once or twice she had peeped into the book her sister was reading,"
				+ " but it had no pictures or conversations in it, `and what is the use of a book,' thought Alice `without pictures or conversation?'";
		for (String sentence: TextBreaker.getSentences(text)) System.out.println(sentence);
		System.out.println("**********************************************");
		
		text = "There was nothing so VERY remarkable in that;"
				+ " nor did Alice think it so VERY much out of the way to hear the Rabbit say to itself,"
				+ " `Oh dear!  Oh dear!  I shall be late!'"
				+ "  (when she thought it over afterwards, it occurred to her that she ought to have wondered at this, but at the time it all seemed quite natural);"
				+ " but when the Rabbit actually TOOK A WATCH OUT OF ITS WAISTCOAT- POCKET, and looked at it, and then hurried on,"
				+ " Alice started to her feet, for it flashed across her mind that she had never before seen a rabbit with either a waistcoat-pocket,"
				+ " or a watch to take out of it, and burning with curiosity, she ran across the field after it,"
				+ " and fortunately was just in time to see it pop down a large rabbit-hole under the hedge.";
		for (String sentence: TextBreaker.getSentences(text)) System.out.println(sentence);
		System.out.println("**********************************************");
		
		text = "Marley was dead: to begin with. There is no doubt whatever about that."
				+ " The register of his burial was signed by the clergyman, the clerk, the undertaker, and the chief mourner."
				+ " Scrooge signed it. And Scrooge's name was good upon `Change, for anything he chose to put his hand to.";
		for (String sentence: TextBreaker.getSentences(text)) System.out.println(sentence);
	}
	
	@Test
	public void testWordBreaker() {
		System.out.println(); System.out.println();
		String text = "Mr. Utterson the lawyer was a man of a rugged countenance that was never"
				+ " lighted by a smile; cold, scanty and embarrassed in discourse; backward in sentiment; lean, long, dusty, dreary and yet somehow lovable.";
		for (String word: TextBreaker.getWords(text)) System.out.println(word);
		System.out.println("**********************************************");
		
		text = "At friendly meetings, and when the wine was to his taste, something eminently human beaconed from his eye;"
				+ " something indeed which never found its way into his talk, but which spoke not only in these silent symbols of the after-dinner face,"
				+ " but more often and loudly in the acts of his life.";
		for (String word: TextBreaker.getWords(text)) System.out.println(word);
		System.out.println();
	}
	
	
//	@Test
//	public void testSentenceBreakerDP() {
//		System.out.println(); System.out.println("DP"); System.out.println();
//		String text = "Alice was beginning to get very tired of sitting by her sister on the bank,"
//				+ " and of having nothing to do:  once or twice she had peeped into the book her sister was reading,"
//				+ " but it had no pictures or conversations in it, `and what is the use of a book,' thought Alice `without pictures or conversation?'";
//		for (String sentence: SentenceBreaker.getSetencesDP(text)) System.out.println(sentence);
//		System.out.println("**********************************************");
//		
//		text = "There was nothing so VERY remarkable in that;"
//				+ " nor did Alice think it so VERY much out of the way to hear the Rabbit say to itself,"
//				+ " `Oh dear!  Oh dear!  I shall be late!'"
//				+ "  (when she thought it over afterwards, it occurred to her that she ought to have wondered at this, but at the time it all seemed quite natural);"
//				+ " but when the Rabbit actually TOOK A WATCH OUT OF ITS WAISTCOAT- POCKET, and looked at it, and then hurried on,"
//				+ " Alice started to her feet, for it flashed across her mind that she had never before seen a rabbit with either a waistcoat-pocket,"
//				+ " or a watch to take out of it, and burning with curiosity, she ran across the field after it,"
//				+ " and fortunately was just in time to see it pop down a large rabbit-hole under the hedge.";
//		for (String sentence: SentenceBreaker.getSetencesDP(text)) System.out.println(sentence);
//		System.out.println("**********************************************");
//		
//		text = "Marley was dead: to begin with. There is no doubt whatever about that."
//				+ " The register of his burial was signed by the clergyman, the clerk, the undertaker, and the chief mourner."
//				+ " Scrooge signed it. And Scrooge's name was good upon `Change, for anything he chose to put his hand to.";
//		for (String sentence: SentenceBreaker.getSetencesDP(text)) System.out.println(sentence);
//	}
//	
//	@Test
//	public void testSentenceBreakerTokenize() {
//		System.out.println(); System.out.println("Tokenize"); System.out.println();
//		String text = "Alice was beginning to get very tired of sitting by her sister on the bank,"
//				+ " and of having nothing to do:  once or twice she had peeped into the book her sister was reading,"
//				+ " but it had no pictures or conversations in it, `and what is the use of a book,' thought Alice `without pictures or conversation?'";
//		for (String sentence: SentenceBreaker.getSentencesTokenize(text)) System.out.println(sentence);
//		System.out.println("**********************************************");
//		
//		text = "There was nothing so VERY remarkable in that;"
//				+ " nor did Alice think it so VERY much out of the way to hear the Rabbit say to itself,"
//				+ " `Oh dear!  Oh dear!  I shall be late!'"
//				+ "  (when she thought it over afterwards, it occurred to her that she ought to have wondered at this, but at the time it all seemed quite natural);"
//				+ " but when the Rabbit actually TOOK A WATCH OUT OF ITS WAISTCOAT- POCKET, and looked at it, and then hurried on,"
//				+ " Alice started to her feet, for it flashed across her mind that she had never before seen a rabbit with either a waistcoat-pocket,"
//				+ " or a watch to take out of it, and burning with curiosity, she ran across the field after it,"
//				+ " and fortunately was just in time to see it pop down a large rabbit-hole under the hedge.";
//		for (String sentence: SentenceBreaker.getSentencesTokenize(text)) System.out.println(sentence);
//		System.out.println("**********************************************");
//		
//		text = "Marley was dead: to begin with. There is no doubt whatever about that."
//				+ " The register of his burial was signed by the clergyman, the clerk, the undertaker, and the chief mourner."
//				+ " Scrooge signed it. And Scrooge's name was good upon `Change, for anything he chose to put his hand to.";
//		for (String sentence: SentenceBreaker.getSentencesTokenize(text)) System.out.println(sentence);
//	}
}
