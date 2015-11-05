package concordance.gui;

import concordance.gui.controllers.ControllerAdvance;
import concordance.gui.controllers.ControllerDisplayAll;
import concordance.gui.controllers.ControllerDisplayBiggest;
import concordance.gui.controllers.ControllerDisplaySmallest;
import concordance.gui.controllers.ControllerFindKeyWord;
import concordance.gui.controllers.ControllerFindWordsBeginWith;
import concordance.gui.controllers.ControllerList;
import concordance.gui.controllers.ControllerLoadConcordance;
import concordance.gui.controllers.ControllerLoadFilter;
import concordance.gui.controllers.ControllerTextSimplify;

public class Control {
	
	Model model;
	View view;

	public Control(View view, Model model) {
		this.model = model;
		this.view = view;
		
		ControllerLoadConcordance ctlLoadCon = new ControllerLoadConcordance(view, model);
		ControllerLoadFilter ctlLoadFilter = new ControllerLoadFilter(view, model);
		ControllerList ctlList = new ControllerList(view, model);
		ControllerDisplayAll ctlDisplayAll = new ControllerDisplayAll(view, model);
		ControllerDisplayBiggest ctlDisplayBiggest = new ControllerDisplayBiggest(view, model);
		ControllerDisplaySmallest ctlDisplaySmallest = new ControllerDisplaySmallest(view, model);
		ControllerFindKeyWord ctrFindKeyWord = new ControllerFindKeyWord(view, model);
		ControllerFindWordsBeginWith ctrFindWordsBeginWith = new ControllerFindWordsBeginWith(view, model);
		ControllerAdvance ctrAdvance = new ControllerAdvance(view, model);
		
		view.getBtnLoadConcordance().addActionListener(ctlLoadCon);
		view.getBtnLoadCommonWords().addActionListener(ctlLoadFilter);
		view.getTable().addMouseListener(ctlList);
		view.getBtnDisplayAll().addActionListener(ctlDisplayAll);
		view.getBtnGetBiggest().addActionListener(ctlDisplayBiggest);
		view.getBtnGetSmallest().addActionListener(ctlDisplaySmallest);
		view.getBtnSearchKeyword().addActionListener(ctrFindKeyWord);
		view.getBtnSearchBeginWord().addActionListener(ctrFindWordsBeginWith);
		view.getBtnAdvanced().addActionListener(ctrAdvance);
	}

}
