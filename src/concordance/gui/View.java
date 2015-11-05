package concordance.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import concordance.ConcordanceApplication;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;

public class View extends JFrame {

	private ConcordanceApplication main;
	private JPanel mainPane;
	private JTable table;
	private JTextField txtKeyword;
	private JTextField txtBeginWord;
	private JButton btnGetSmallest;
	private JButton btnDisplayAll;
	private JButton btnGetBiggest;
	private JButton btnLoadCommonWords;
	private JButton btnSearchKeyword;
	private JButton btnSearchBeginWord;
	private JLabel lblFeedback;
	private JButton btnLoadConcordance;
	private JPanel displayPanel;
	private JTextPane displayField;
	private JButton btnAdvanced;
	private JLabel lblCommonFile;
	private JPanel commandsPanel;
	private ViewAdvanced advancedPanel;

	/**
	 * Create the frame.
	 */
	public View(ConcordanceApplication main) {
		advancedPanel = null;
		this.main = main;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(new MigLayout("", "[100%,grow]", "[85%,grow][15%]"));
		setTitle("Concordance Application - Minh Hoang");

		/*
		 * Top section (output)
		 */
		displayPanel = new JPanel();
		mainPane.add(displayPanel, "cell 0 0,grow");
		displayPanel.setLayout(new MigLayout("", "[20%][80%,grow]", "[100%,grow]"));
		
		displayField = new JTextPane();
		displayField.setContentType("text/html");
		JScrollPane scrollPaneDisplay = new JScrollPane(displayField);
		displayPanel.add(scrollPaneDisplay, "cell 1 0,grow");
		
		JScrollPane scrollPane = new JScrollPane();
		displayPanel.add(scrollPane, "cell 0 0,grow");
		table = new JTable(50, 2);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		scrollPane.setViewportView(table);
		
		/*
		 * Commands (input, bottom) section
		 */
		commandsPanel = new JPanel();
		mainPane.add(commandsPanel, "cell 0 1,growx");
		commandsPanel.setLayout(new MigLayout("", "[20%][20%][20%][20%][20%]", "[25%][25%][25%][25%][shrink 0]"));

		lblFeedback = new JLabel("Feedback");
		lblFeedback.setVisible(false);
		lblFeedback.setForeground(Color.RED);
		lblFeedback.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		commandsPanel.add(lblFeedback, "cell 1 0 3 1,alignx center,aligny center");

		JLabel lblKeyword = new JLabel("Find Keyword:");
		commandsPanel.add(lblKeyword, "cell 1 1,alignx trailing");

		txtKeyword = new JTextField();
		commandsPanel.add(txtKeyword, "cell 2 1,growx");
		txtKeyword.setColumns(10);

		btnSearchKeyword = new JButton("Search");
		btnSearchKeyword.setBackground(Color.WHITE);
		commandsPanel.add(btnSearchKeyword, "cell 3 1,alignx left,aligny top");

		JPanel panelButtonsCommon = new JPanel();
		commandsPanel.add(panelButtonsCommon, "cell 4 0 1 4,grow");
		panelButtonsCommon.setLayout(new GridLayout(4, 0, 0, 0));
		
		lblCommonFile = new JLabel("common file");
		lblCommonFile.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblCommonFile.setVisible(false);
		lblCommonFile.setHorizontalAlignment(SwingConstants.CENTER);
		panelButtonsCommon.add(lblCommonFile);

		btnLoadCommonWords = new JButton("Load Common Words");
		btnLoadCommonWords.setBackground(Color.WHITE);
		panelButtonsCommon.add(btnLoadCommonWords);
		
		btnAdvanced = new JButton("Show Advanced");
		btnAdvanced.setForeground(Color.RED);
		btnAdvanced.setBackground(Color.WHITE);
		panelButtonsCommon.add(btnAdvanced);

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

	public JButton getBtnSearchKeyword() {
		return btnSearchKeyword;
	}

	public JButton getBtnSearchBeginWord() {
		return btnSearchBeginWord;
	}

	public String getTxtKeyword() {
		return txtKeyword.getText();
	}

	public String getTxtBeginWord() {
		return txtBeginWord.getText();
	}

	public void setLblFeedback(String text) {
		lblFeedback.setVisible(true);
		lblFeedback.setText(text);
	}
	
	public void clearLblFeedback() {
		lblFeedback.setVisible(false);
		lblFeedback.setText("");
	}
	
	public JButton getBtnLoadConcordance() {
		return btnLoadConcordance;
	}

	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(JTable table) {
		this.table = table;
	}
	public JButton getBtnAdvanced() {
		return btnAdvanced;
	}
	
	public void setBtnAdvancedText(String text) {
		btnAdvanced.setText(text);
	}

	/**
	 * @param displayField the displayField to set
	 */
	public void setDisplayField(String text) {
		displayField.setText(text);
	}
	
	public void setDisplayFieldViewToTop() {
		displayField.setCaretPosition(0);
	}
	public void setLblCommonFile(String text) {
		lblCommonFile.setVisible(true);
		lblCommonFile.setText(text);
	}
	
	public void clearLblCommonFIle() {
		lblCommonFile.setVisible(false);
		lblCommonFile.setText("");
	}
	public JPanel getCommandsPanel() {
		return commandsPanel;
	}

	/**
	 * @return the advancedPanel
	 */
	public ViewAdvanced getAdvancedPanel() {
		return advancedPanel;
	}

	/**
	 * @param advancedPanel the advancedPanel to set
	 */
	public void setAdvancedPanel(ViewAdvanced advancedPanel) {
		this.advancedPanel = advancedPanel;
	}
}
