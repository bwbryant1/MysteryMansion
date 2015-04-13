package helpers;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import org.lwjgl.input.Keyboard;

import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameMap extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static boolean running;



	private boolean resizable= true;
	private JTextField textField;
	private JPanel panel;
	 private JFrame frame;
	
	
	public GameMap(){
		
		super("GameMap");

		setVisible(false);
		
		


	    setDefaultCloseOperation(HIDE_ON_CLOSE); // Already there
	    


		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(dim.width/2,dim.height/2);
		setResizable(resizable);
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		 panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JLabel lblConsole = new JLabel("Console");
		lblConsole.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblConsole);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(50);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GameMap.class.getResource("/res/maps/game_map2.png")));
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
		
		JMenuItem mntmChangeGameSettings = new JMenuItem("Change Game Settings...");
		mnEdit.add(mntmChangeGameSettings);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmWebsite = new JMenuItem("Website");
		mnHelp.add(mntmWebsite);
		
		JMenuItem mntmContactUs = new JMenuItem("Contact Us");
		mnHelp.add(mntmContactUs);
		
		JMenuItem mntmAbout = new JMenuItem("About ImageViewer...");
		mntmAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { showAbout(); }
        });
		mnHelp.add(mntmAbout);
		
	}
    private void showAbout()
    {
        JOptionPane.showMessageDialog(frame, 
                "ImageViewer\n" ,
                "About ImageViewer", 
                JOptionPane.INFORMATION_MESSAGE);
    }
	
}
