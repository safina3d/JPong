package game.pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.BitSet;

import game.core.Game;
import game.core.GameObject;
import game.core.GameObjectType;
import game.tools.Utils;

public class Raquette extends GameObject implements KeyListener {
	
	private static final int VITESSE = 5;
	private BitSet keys = new BitSet(2); 
	
	public Raquette(int x, int y) {
		super(x, y);
		this.type = GameObjectType.RAQUETTE;
		this.width = 20;
		this.height = 150;

	}

	@Override
	public void update() {
		y += velY;
		y = Utils.clamp(y, 40, Game.HEIGHT - height - 20);			
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_UP){
			this.setVelY(-VITESSE);
			keys.set(0, true);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			this.setVelY(VITESSE);
			keys.set(1, true);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP ){
			keys.set(0, false);
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN ){
			keys.set(1, false);
		}

		if(!keys.get(0) && !keys.get(1)) setVelY(0);
	}

	
	
	


	
	
	
	
	
	
}
