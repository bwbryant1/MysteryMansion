package helpers;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GameMap extends JFrame {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private static boolean running;

	private boolean resizable = true;
	private JTextField textField;
	private JPanel panel;
	private JFrame frame;
	private JOptionPane ShowGameOptions;
	private static JOptionPane ShowAbout;
	private static JOptionPane ShowWebsite;
	private static JOptionPane ShowContact;
	

	public static void main(String[] args) {
		ConsoleParser parser = new ConsoleParser();
		GameMap map = new GameMap(parser);
		map.setDefaultCloseOperation(EXIT_ON_CLOSE); // Already there
		map.setVisible(true);
	}

	public GameMap(final ConsoleParser parser) {

		super("GameMap");

		setVisible(false);

		setDefaultCloseOperation(HIDE_ON_CLOSE); // Already there

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(dim.width / 2, dim.height / 2);
		setResizable(resizable);
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height
				/ 2 - this.getSize().height / 2);
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		{
			
			ShowWebsite = new JOptionPane();
			ShowContact = new JOptionPane();
			ShowAbout = new JOptionPane();
			ShowGameOptions = new JOptionPane();
			
			
			
		}
		
		{
			JLabel lblConsole = new JLabel("Console");
			lblConsole.setVerticalAlignment(SwingConstants.BOTTOM);
			panel.add(lblConsole);

			textField = new JTextField();
			panel.add(textField);
			textField.setColumns(50);
			textField.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					//System.out.println(textField.getText());
					parser.receiveCommand(textField.getText());
					
					textField.setText("");

				}
			});
		}
	
		JLabel lblNewLabel_1 = new JLabel("");
		panel.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GameMap.class
				.getResource("/res/maps/game_map2.png")));
		scrollPane.setViewportView(lblNewLabel);

		JMenuBar menuBar = new JMenuBar();
		scrollPane.setColumnHeaderView(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);

		JMenuItem mntmNewMenuItem = new JMenuItem("Close");
		mnFile.add(mntmNewMenuItem);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		JMenuItem mntmChangeGameSettings = new JMenuItem(
				"Change Game Settings...");
		mntmChangeGameSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showOption();
			}
		});
		mnEdit.add(mntmChangeGameSettings);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmWebsite = new JMenuItem("Website");
		mntmWebsite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showWebsite();
			}
		});
		mnHelp.add(mntmWebsite);

		JMenuItem mntmContactUs = new JMenuItem("Contact Us");
		mntmContactUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showContact();
			}
		});
		mnHelp.add(mntmContactUs);

		JMenuItem mntmAbout = new JMenuItem("About Us");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAbout();
			}
		});
		mnHelp.add(mntmAbout);
		

	}

	@SuppressWarnings("static-access")
	private void showAbout() {

		ShowAbout.showMessageDialog(frame,
				"We are a bunch of nerds doing Nerdy Stuff", "About Us",
				JOptionPane.PLAIN_MESSAGE);
	}
	private void showContact(){
		ShowContact.showMessageDialog(frame,
				"bwb016@LaTech.edu", "Contact Us",
				JOptionPane.PLAIN_MESSAGE);
		
	}
	private void showWebsite(){
		ShowWebsite.showMessageDialog(frame,
				"http://bwb016.github.io/MysteryMansion/", "Website",
				JOptionPane.PLAIN_MESSAGE);
		
	}
	private void showOption(){
		JButton button = new JButton();
		ShowGameOptions.add(button);
		
		
		ShowGameOptions.showMessageDialog(frame,
				"Game Settings", "Game Options",
				JOptionPane.DEFAULT_OPTION);
		
	}

}
