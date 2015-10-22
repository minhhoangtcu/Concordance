package concordance.reader;

import java.text.BreakIterator;
import java.util.Locale;

public class SentenceBreaker {
	
	public static void getSentences(String text) {
		BreakIterator boundary = BreakIterator.getSentenceInstance(Locale.US);
        boundary.setText(text);
        int start = boundary.first();
        for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {
            System.out.println(text.substring(start, end));
        }
	}
	
	public static void getSentences2(String text) {
		
	}

}
