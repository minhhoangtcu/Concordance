package concordance.gui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;

public class ViewAdvanced extends JPanel {

	JPanel panel;
	private JButton btnShowBiggestDecendingly;
	private JButton btnShowSmallestAscendingly;
	private JButton btnSimplifyText;
	
	/**
	 * Create the panel.
	 */
	public ViewAdvanced() {
		
		panel = new JPanel();
		panel.setSize(900, 200);
		add(panel);
		panel.setLayout(new GridLayout(1, 5, 0, 0));
		
		btnShowBiggestDecendingly = new JButton("Show Biggest Decendingly");
		btnShowBiggestDecendingly.setBackground(Color.WHITE);
		panel.add(btnShowBiggestDecendingly);
		
		btnShowSmallestAscendingly = new JButton("Show Smallest Ascendingly");
		btnShowSmallestAscendingly.setBackground(Color.WHITE);
		panel.add(btnShowSmallestAscendingly);
		
		btnSimplifyText = new JButton("Turn On Simple Text");
		btnSimplifyText.setBackground(Color.WHITE);
		panel.add(btnSimplifyText);

	}

	public JButton getBtnShowBiggestDecendingly() {
		return btnShowBiggestDecendingly;
	}
	public JButton getBtnShowSmallestAscendingly() {
		return btnShowSmallestAscendingly;
	}
	public JButton getBtnSimplifyText() {
		return btnSimplifyText;
	}
	public void setBtnSimplifyText(String text) {
		btnSimplifyText.setText(text);
	}
}