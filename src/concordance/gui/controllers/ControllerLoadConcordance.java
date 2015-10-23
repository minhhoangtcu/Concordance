package concordance.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import concordance.gui.View;
import concordance.reader.ConcordanceReader;

public class ControllerLoadConcordance implements ActionListener {

	View view;
	
	public ControllerLoadConcordance(View view) {
		this.view = view;
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
					ConcordanceReader.read(reader);
			    } catch (FileNotFoundException e1) {
			    	e1.printStackTrace();
			    } catch (IOException e1) {
					e1.printStackTrace();
				}
		}
	}
}
