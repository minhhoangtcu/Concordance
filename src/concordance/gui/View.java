package concordance.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;

public class View extends JFrame {

	private JPanel mainPane;
	private JTable table;
	private JTextField txtKeyword;
	private JTextField txtBeginWord;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		
		JScrollPane scrollPane = new JScrollPane();
		mainPane.add(scrollPane, "cell 0 0,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel commandsPanel = new JPanel();
		mainPane.add(commandsPanel, "cell 0 1,growx");
		commandsPanel.setLayout(new MigLayout("", "[20%][20%,grow][20%][20%][20%,grow]", "[20%][30%][30%][30%,grow]"));
		
		JLabel lblFeedback = new JLabel("Feedback");
		commandsPanel.add(lblFeedback, "cell 0 0 5 1,alignx center,aligny center");
		
		JLabel lblKeyword = new JLabel("Find Keyword:");
		commandsPanel.add(lblKeyword, "cell 1 1,alignx trailing");
		
		txtKeyword = new JTextField();
		commandsPanel.add(txtKeyword, "cell 2 1,growx");
		txtKeyword.setColumns(10);
		
		JButton btnSearchKeyword = new JButton("Search");
		commandsPanel.add(btnSearchKeyword, "cell 3 1,alignx left,aligny top");
		
		JPanel panelButtonsCommon = new JPanel();
		commandsPanel.add(panelButtonsCommon, "cell 4 1 1 3,grow");
		panelButtonsCommon.setLayout(new GridLayout(3, 0, 0, 0));
		
		JButton btnLoadCommonWords = new JButton("Load Common Words");
		panelButtonsCommon.add(btnLoadCommonWords);
		
		JButton btnRemoveAllCommon = new JButton("Remove All Common Words");
		panelButtonsCommon.add(btnRemoveAllCommon);
		
		JLabel lblBeginWord = new JLabel("Find words begin with:");
		commandsPanel.add(lblBeginWord, "cell 1 2,alignx trailing");
		
		txtBeginWord = new JTextField();
		commandsPanel.add(txtBeginWord, "cell 2 2,growx");
		txtBeginWord.setColumns(10);
		
		JButton buttonSearchBeginWord = new JButton("Search");
		commandsPanel.add(buttonSearchBeginWord, "cell 3 2");
		
		JPanel panelButtonsDisplay = new JPanel();
		commandsPanel.add(panelButtonsDisplay, "cell 0 1 1 3,grow");
		panelButtonsDisplay.setLayout(new GridLayout(3, 0, 0, 0));
		
		JButton btnDisplayAll = new JButton("Display All");
		panelButtonsDisplay.add(btnDisplayAll);
		
		JButton btnGetSmallest = new JButton("Get Smallest");
		panelButtonsDisplay.add(btnGetSmallest);
		
		JButton btnGetBiggest = new JButton("Get Biggest");
		panelButtonsDisplay.add(btnGetBiggest);
	}

}
