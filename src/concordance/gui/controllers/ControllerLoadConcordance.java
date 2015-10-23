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

public class ControllerLoadConcordance implements ActionListener {

	View view;
	
	public ControllerLoadConcordance(View view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Select a text file to build a concordance");
		
		int returnVal = fc.showOpenDialog(view);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			 File selectedFile = fc.getSelectedFile();
			    try {
					BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
					String line = null;
					while ((line = reader.readLine()) != null) {
						if (line.trim().equals("")) {
							System.out.println("-> following is a paragraph break");
						}
						System.out.println(line);
					}
					reader.close();
			    } catch (FileNotFoundException e1) {
				} catch (IOException e1) {
				}
		}
	}

}
