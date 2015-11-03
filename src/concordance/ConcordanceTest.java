package concordance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.junit.Test;

import concordance.datastructure.RightThreadedTree;
import concordance.reader.ConcordanceReader;
import concordance.reader.FilterWordsReader;

public class ConcordanceTest {

	@Test
	public void test() throws IOException {
		ConcordanceApplication app = new ConcordanceApplication();
		BufferedReader fReader = new BufferedReader(new FileReader("MostCommonWords.txt"));
		BufferedReader cReader = new BufferedReader(new FileReader("AChristmasCarol.txt"));
		
		FilterWordsReader filterReader = new FilterWordsReader();
		HashMap<String, Boolean> map = filterReader.read(fReader);
		ConcordanceReader concorReader = new ConcordanceReader();
		RightThreadedTree tree = concorReader.read(cReader, map);
		
		app.getModel().setFilterMap(map);
		app.getModel().setTree(tree);
		app.getView().setLblFeedback("Loaded concordance.");
		app.getModel().initList();
		app.getView().getTable().setModel(app.getModel().initTableModel());
		
		try {
			Thread.sleep(600000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
