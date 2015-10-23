package concordance.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JTextArea;

public class View extends JFrame {

	private JPanel mainPane;
	private JTable table;
	private JTextField txtKeyword;
	private JTextField txtBeginWord;
	private JButton btnGetSmallest;
	private JButton btnDisplayAll;
	private JButton btnGetBiggest;
	private JButton btnLoadCommonWords;
	private JButton btnRemoveAllCommon;
	private JButton btnSearchKeyword;
	private JButton btnSearchBeginWord;
	private JLabel lblFeedback;
	private JButton btnLoadConcordance;
	private JPanel displayPanel;
	private JTextArea displayField;

	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(new MigLayout("", "[100%,grow]", "[85%,grow][15%]"));
		setTitle("Concordance Application - Minh Hoang");

		/*
		 * Table (top) section
		 */

		/*
		 * Commands (input, bottom) section
		 */
		
		displayPanel = new JPanel();
		mainPane.add(displayPanel, "cell 0 0,grow");
		displayPanel.setLayout(new MigLayout("", "[20%][80%,grow]", "[100%,grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		displayPanel.add(scrollPane, "cell 0 0,grow");
		
		table = new JTable(getPlaceHolderData(), getPlaceHolderNames());
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		scrollPane.setViewportView(table);
		
		displayField = new JTextArea();
		displayPanel.add(displayField, "cell 1 0,grow");
		
		JPanel commandsPanel = new JPanel();
		mainPane.add(commandsPanel, "cell 0 1,growx");
		commandsPanel.setLayout(new MigLayout("", "[20%][20%,grow][20%][20%][20%,grow]", "[20%][30%][30%][30%,grow]"));

		lblFeedback = new JLabel("Feedback");
		commandsPanel.add(lblFeedback, "cell 1 0 4 1,alignx center,aligny center");

		JLabel lblKeyword = new JLabel("Find Keyword:");
		commandsPanel.add(lblKeyword, "cell 1 1,alignx trailing");

		txtKeyword = new JTextField();
		commandsPanel.add(txtKeyword, "cell 2 1,growx");
		txtKeyword.setColumns(10);

		btnSearchKeyword = new JButton("Search");
		btnSearchKeyword.setBackground(Color.WHITE);
		commandsPanel.add(btnSearchKeyword, "cell 3 1,alignx left,aligny top");

		JPanel panelButtonsCommon = new JPanel();
		commandsPanel.add(panelButtonsCommon, "cell 4 1 1 3,grow");
		panelButtonsCommon.setLayout(new GridLayout(3, 0, 0, 0));

		btnLoadCommonWords = new JButton("Load Common Words");
		btnLoadCommonWords.setBackground(Color.WHITE);
		panelButtonsCommon.add(btnLoadCommonWords);

		btnRemoveAllCommon = new JButton("Remove All Common Words");
		btnRemoveAllCommon.setBackground(Color.WHITE);
		panelButtonsCommon.add(btnRemoveAllCommon);

		JLabel lblBeginWord = new JLabel("Find words begin with:");
		commandsPanel.add(lblBeginWord, "cell 1 2,alignx trailing");

		txtBeginWord = new JTextField();
		commandsPanel.add(txtBeginWord, "cell 2 2,growx");
		txtBeginWord.setColumns(10);

		btnSearchBeginWord = new JButton("Search");
		btnSearchBeginWord.setBackground(Color.WHITE);
		commandsPanel.add(btnSearchBeginWord, "cell 3 2");

		JPanel panelButtonsDisplay = new JPanel();
		commandsPanel.add(panelButtonsDisplay, "cell 0 0 1 4,grow");
		panelButtonsDisplay.setLayout(new GridLayout(4, 0, 0, 0));
		
		btnLoadConcordance = new JButton("Load Concordance");
		btnLoadConcordance.setBackground(Color.WHITE);
		panelButtonsDisplay.add(btnLoadConcordance);

		btnDisplayAll = new JButton("Display All");
		btnDisplayAll.setBackground(Color.WHITE);
		panelButtonsDisplay.add(btnDisplayAll);

		btnGetSmallest = new JButton("Get Smallest");
		btnGetSmallest.setBackground(Color.WHITE);
		panelButtonsDisplay.add(btnGetSmallest);

		btnGetBiggest = new JButton("Get Biggest");
		btnGetBiggest.setBackground(Color.WHITE);
		panelButtonsDisplay.add(btnGetBiggest);
	}

	private String[] getPlaceHolderNames() {
		String[] columnNames = { "Word", "Frequency"};
		return columnNames;
	}

	private Object[][] getPlaceHolderData() {
		Object[][] data = { 
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1},
				{ "Jon Doe", 1}
		};
		return data;
	}

	public JButton getBtnGetSmallest() {
		return btnGetSmallest;
	}

	public JButton getBtnDisplayAll() {
		return btnDisplayAll;
	}

	public JButton getBtnGetBiggest() {
		return btnGetBiggest;
	}

	public JButton getBtnLoadCommonWords() {
		return btnLoadCommonWords;
	}

	public JButton getBtnRemoveAllCommon() {
		return btnRemoveAllCommon;
	}

	public JButton getBtnSearchKeyword() {
		return btnSearchKeyword;
	}

	public JButton getBtnSearchBeginWord() {
		return btnSearchBeginWord;
	}

	public JTextField getTxtKeyword() {
		return txtKeyword;
	}

	public JTextField getTxtBeginWord() {
		return txtBeginWord;
	}

	public void setLblFeedback(String text) {
		lblFeedback.setText(text);
	}
	public JButton getBtnLoadConcordance() {
		return btnLoadConcordance;
	}
}
