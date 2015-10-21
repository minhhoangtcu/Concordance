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

	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(new MigLayout("", "[100%]", "[85%][15%]"));
		setTitle("Concordance Application - Minh Hoang");

		/*
		 * Table (top) section
		 */
		JScrollPane scrollPane = new JScrollPane();
		mainPane.add(scrollPane, "cell 0 0,grow");

		table = new JTable(getPlaceHolderData(), getPlaceHolderNames()); // FAKE
																			// DATA/USED
																			// AS
																			// PLACEHOLDER
																			// FOR
																			// THE
																			// FUTURE
																			// IMPLEMENT
																			// DATA
		scrollPane.setViewportView(table);

		/*
		 * Commands (input, bottom) section
		 */
		JPanel commandsPanel = new JPanel();
		mainPane.add(commandsPanel, "cell 0 1,growx");
		commandsPanel.setLayout(new MigLayout("", "[20%][20%,grow][20%][20%][20%,grow]", "[20%][30%][30%][30%,grow]"));

		lblFeedback = new JLabel("Feedback");
		commandsPanel.add(lblFeedback, "cell 0 0 5 1,alignx center,aligny center");

		JLabel lblKeyword = new JLabel("Find Keyword:");
		commandsPanel.add(lblKeyword, "cell 1 1,alignx trailing");

		txtKeyword = new JTextField();
		commandsPanel.add(txtKeyword, "cell 2 1,growx");
		txtKeyword.setColumns(10);

		btnSearchKeyword = new JButton("Search");
		commandsPanel.add(btnSearchKeyword, "cell 3 1,alignx left,aligny top");

		JPanel panelButtonsCommon = new JPanel();
		commandsPanel.add(panelButtonsCommon, "cell 4 1 1 3,grow");
		panelButtonsCommon.setLayout(new GridLayout(3, 0, 0, 0));

		btnLoadCommonWords = new JButton("Load Common Words");
		panelButtonsCommon.add(btnLoadCommonWords);

		btnRemoveAllCommon = new JButton("Remove All Common Words");
		panelButtonsCommon.add(btnRemoveAllCommon);

		JLabel lblBeginWord = new JLabel("Find words begin with:");
		commandsPanel.add(lblBeginWord, "cell 1 2,alignx trailing");

		txtBeginWord = new JTextField();
		commandsPanel.add(txtBeginWord, "cell 2 2,growx");
		txtBeginWord.setColumns(10);

		btnSearchBeginWord = new JButton("Search");
		commandsPanel.add(btnSearchBeginWord, "cell 3 2");

		JPanel panelButtonsDisplay = new JPanel();
		commandsPanel.add(panelButtonsDisplay, "cell 0 1 1 3,grow");
		panelButtonsDisplay.setLayout(new GridLayout(3, 0, 0, 0));

		btnDisplayAll = new JButton("Display All");
		panelButtonsDisplay.add(btnDisplayAll);

		btnGetSmallest = new JButton("Get Smallest");
		panelButtonsDisplay.add(btnGetSmallest);

		btnGetBiggest = new JButton("Get Biggest");
		panelButtonsDisplay.add(btnGetBiggest);
	}

	private String[] getPlaceHolderNames() {
		String[] columnNames = { "First Name", "Last Name", "Sport", "# of Years", "Vegetarian" };
		return columnNames;
	}

	private Object[][] getPlaceHolderData() {
		Object[][] data = { 
				{ "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) },
				{ "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) },
				{ "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) },
				{ "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) },
				{ "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) },
				{ "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) },
				{ "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) },
				{ "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) },
				{ "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) },
				{ "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) },
				{ "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) },
				{ "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) },
				{ "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) },
				{ "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) },
				{ "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) },
				{ "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) },
				{ "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) },
				{ "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) },
				{ "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) },
				{ "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) },
				{ "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) }

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
}
