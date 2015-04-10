package helpers;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import org.lwjgl.input.Keyboard;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class GameMap extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static boolean running;



	private boolean resizable= true;
	
	
	public GameMap(){
		
		super("GameMap");
		setVisible(false);
		
		


	    setDefaultCloseOperation(HIDE_ON_CLOSE); // Already there
	    


		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(dim.width/2,dim.height/2);
		setResizable(resizable);
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GameMap.class.getResource("/res/maps/game_map2.png")));
		scrollPane.setViewportView(lblNewLabel);
		
	}
	
}
