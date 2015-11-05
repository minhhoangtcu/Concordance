package concordance.gui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;

public class ViewAdvanced extends JPanel {

	JPanel panel;
	
	/**
	 * Create the panel.
	 */
	public ViewAdvanced() {
		
		panel = new JPanel();
		panel.setSize(900, 200);
		add(panel);
		panel.setLayout(new GridLayout(1, 5, 0, 0));
		
		JButton btnShowBiggestAscendingly = new JButton("Show Biggest Ascendingly");
		btnShowBiggestAscendingly.setBackground(Color.WHITE);
		panel.add(btnShowBiggestAscendingly);
		
		JButton btnNewButton = new JButton("ShowSmallestAscendingly");
		btnNewButton.setBackground(Color.WHITE);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Turn On/Off Simple Text");
		btnNewButton_1.setBackground(Color.WHITE);
		panel.add(btnNewButton_1);

	}

}
