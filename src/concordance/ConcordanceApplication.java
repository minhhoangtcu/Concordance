package concordance;
import concordance.gui.Control;
import concordance.gui.Model;
import concordance.gui.View;

/**
 * Name: Minh Hoang
 * Program: Concordance Application
 * 
 * Purpose: This program create an alphabetical list of the words
 *  (especially the important ones) present in a text, usually with citations of the passages concerned.
 *  
 */
public class ConcordanceApplication {
	
	public static void main(String[] args) {
		Model model = new Model();
		View view = new View();
		Control control = new Control(view, model);
		view.setVisible(true);
	}

}
