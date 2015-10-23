package concordance.reader;

import java.text.BreakIterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

// Deprecated
//import java.io.Reader;
//import java.io.StringReader;
//import java.util.ArrayList;
//import edu.stanford.nlp.ling.CoreLabel;
//import edu.stanford.nlp.ling.HasWord;
//import edu.stanford.nlp.ling.Sentence;
//import edu.stanford.nlp.process.CoreLabelTokenFactory;
//import edu.stanford.nlp.process.DocumentPreprocessor;
//import edu.stanford.nlp.process.PTBTokenizer;
//import edu.stanford.nlp.process.WordToSentenceProcessor;

public class TextBreaker {
	
	/**
	 * Use the class in default Java library to split a body of text into sentences
	 * This method failed to ignore special characters within quotation marks and also many other cases.
	 * @param text any body a text. Preferably a singly paragraph.
	 * @return a list of sentences from the text
	 */
	public static List<String> getSentences(String text) {
		List<String> list = new LinkedList<>();
		BreakIterator boundary = BreakIterator.getSentenceInstance(Locale.US);
        boundary.setText(text);
        int start = boundary.first();
        for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {
            list.add(text.substring(start, end));
        }
        return list;
	}
	
	/**
	 * Use the class in default Java library to split a sentence into many words
	 * @param text any sentence type String
	 * @return a list of words lower cased within the given text
	 */
	public static List<String> getWords(String text) {
		List<String> list = new LinkedList<>();
		BreakIterator boundary = BreakIterator.getWordInstance(Locale.US);
		boundary.setText(text);
        int start = boundary.first();
        for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {
        	String adding = text.substring(start, end).trim();
        	if (!containsSpecialCharacter(adding) && !adding.isEmpty()) {
        		list.add(text.substring(start, end).toLowerCase());
        	}
        }
        return list;
	}
	
	public static boolean containsSpecialCharacter(String s) {
	    return (s == null) ? false : s.matches("[^A-Za-z0-9]");
	}
	
	/*
	 * Deprecated Methods
	 */
	
//	/*
//	 * Use the Document Preprocessor in Stanford NLP library to split into sentences
//	 * This edit the body of text
//	 */
//	public static List<String> getSetencesDP(String text) {
//		Reader reader = new StringReader(text);
//		DocumentPreprocessor dp = new DocumentPreprocessor(reader);
//		List<String> list = new LinkedList<String>();
//		for (List<HasWord> sentence : dp) {
//		   String sentenceString = Sentence.listToString(sentence);
//		   list.add(sentenceString.toString());
//		}
//		return list;
//	}
//	
//	/*
//	 * Use the Tokenizer in Stanford NLP library to split into sentences
//	 * This perform much better than others
//	 */
//	public static List<String> getSentencesTokenize(String text) {
//		//// Tokenize
//		List<CoreLabel> tokens = new ArrayList<CoreLabel>();
//		PTBTokenizer<CoreLabel> tokenizer = new PTBTokenizer<CoreLabel>(new StringReader(text), new CoreLabelTokenFactory(), "");
//		while (tokenizer.hasNext()) {
//		    tokens.add(tokenizer.next());
//		}
//		//// Split sentences from tokens
//		List<List<CoreLabel>> sentences = new WordToSentenceProcessor<CoreLabel>().process(tokens);
//		//// Join back together
//		int end;
//		int start = 0;
//		List<String> list = new LinkedList<String>();
//		for (List<CoreLabel> sentence: sentences) {
//		    end = sentence.get(sentence.size()-1).endPosition();
//		    list.add(text.substring(start, end).trim());
//		    start = end;
//		}
//		return list;
//	}
}
