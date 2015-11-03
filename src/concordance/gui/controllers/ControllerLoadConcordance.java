package concordance.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;

import concordance.datastructure.RightThreadedTree;
import concordance.gui.Model;
import concordance.gui.View;
import concordance.reader.ConcordanceReader;

public class ControllerLoadConcordance implements ActionListener {

	View view;
	Model model;
	
	public ControllerLoadConcordance(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Select a text file to build a concordance");
		
		int returnVal = fc.showOpenDialog(view);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			 File selectedFile = fc.getSelectedFile();
			    try {
					BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
					RightThreadedTree tree;
					if (model.getFilterMap() != null)
						tree = ConcordanceReader.read(reader, model.getFilterMap());
					else
						tree = ConcordanceReader.read(reader, null);
					model.setTree(tree);
					view.setLblFeedback("Loaded concordance.");
					model.initList();
					view.getTable().setModel(model.initTableModel());
			    } catch (FileNotFoundException e1) {
			    	e1.printStackTrace();
			    } catch (IOException e1) {
					e1.printStackTrace();
				}
		}
	}
}
