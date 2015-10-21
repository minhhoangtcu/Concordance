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
		mainPane.setLayout(new MigLayout("", "[grow]", "[85%,grow][15%]"));
		
		JScrollPane scrollPane = new JScrollPane();
		mainPane.add(scrollPane, "cell 0 0,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel commandsPanel = new JPanel();
		mainPane.add(commandsPanel, "cell 0 1,alignx center");
		commandsPanel.setLayout(new MigLayout("", "[20%][40%,grow][40%,grow][20%]", "[20%,grow][40%][40%,grow]"));
		
		JLabel lblKeyword = new JLabel("Find Keyword:");
		commandsPanel.add(lblKeyword, "cell 1 0,alignx trailing");
		
		txtKeyword = new JTextField();
		commandsPanel.add(txtKeyword, "cell 2 0,growx");
		txtKeyword.setColumns(10);
		
		JButton btnSearchKeyword = new JButton("Search");
		commandsPanel.add(btnSearchKeyword, "cell 3 0,alignx left,aligny top");
		
		JLabel lblBeginWord = new JLabel("Find words begin with:");
		commandsPanel.add(lblBeginWord, "cell 1 1,alignx trailing");
		
		txtBeginWord = new JTextField();
		commandsPanel.add(txtBeginWord, "cell 2 1,growx");
		txtBeginWord.setColumns(10);
		
		JButton buttonSearchBeginWord = new JButton("Search");
		commandsPanel.add(buttonSearchBeginWord, "cell 3 1");
		
		JPanel panelButtons = new JPanel();
		commandsPanel.add(panelButtons, "cell 0 0 1 3,grow");
		panelButtons.setLayout(new GridLayout(3, 0, 0, 0));
		
		JButton btnDisplayAll = new JButton("Display All");
		panelButtons.add(btnDisplayAll);
		
		JButton btnGetSmallest = new JButton("Get Smallest");
		panelButtons.add(btnGetSmallest);
		
		JButton btnGetBiggest = new JButton("Get Biggest");
		panelButtons.add(btnGetBiggest);
	}

}
