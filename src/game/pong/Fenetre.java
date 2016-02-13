package game.pong;

import javax.swing.JFrame;

public class Fenetre extends JFrame {

	private static final long serialVersionUID = -4066088828317554992L;

	public Fenetre(int width, int height) {
		super();
		this.setTitle("PONG");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.requestFocus();
		
		
	}

}
