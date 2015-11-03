package concordance.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JFileChooser;

import concordance.gui.Model;
import concordance.gui.View;
import concordance.reader.FilterWordsReader;

public class ControllerLoadFilter implements ActionListener {

	View view;
	Model model;
	
	public ControllerLoadFilter(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Select a file with common words to build a filter");
		
		int returnVal = fc.showOpenDialog(view);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			 File selectedFile = fc.getSelectedFile();
			    try {
					BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
					HashMap<String, Boolean> map = FilterWordsReader.read(reader);
					model.setFilterMap(map);
					view.setLblFeedback("Loaded filter words.");
					view.setLblCommonFile(selectedFile.getName());
			    } catch (FileNotFoundException e1) {
			    	e1.printStackTrace();
			    } catch (IOException e1) {
					e1.printStackTrace();
				}
		}
	}

}
