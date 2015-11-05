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
 * Refer to the user manual for more information
 */
public class ConcordanceApplication {
	
	private Model model;
	private View view;
	private Control control;
	
	public static void main(String[] args) {
		ConcordanceApplication app = new ConcordanceApplication();
	}
	
	public ConcordanceApplication() {
		model = new Model();
		view = new View(this);
		control = new Control(view, model);
		view.setVisible(true);
	}

	/**
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	/**
	 * @return the view
	 */
	public View getView() {
		return view;
	}

	/**
	 * @param view the view to set
	 */
	public void setView(View view) {
		this.view = view;
	}

	/**
	 * @return the control
	 */
	public Control getControl() {
		return control;
	}

	/**
	 * @param control the control to set
	 */
	public void setControl(Control control) {
		this.control = control;
	}

}
