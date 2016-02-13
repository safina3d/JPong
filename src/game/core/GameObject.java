package game.core;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class GameObject implements KeyListener {

	protected int x, y;
	protected int velX, velY;
	protected int width, height;
	protected boolean entrainDeSeDeplacer;
	protected GameObjectType type;
	
	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	public int 	getX() 		{ return x; 	}
	public int 	getY() 		{ return y; 	}
	public int 	getVelX() 	{ return velX; 	}
	public int 	getVelY() 	{ return velY; 	}
	public int 	getWidth() 	{ return width;	}
	public int 	getHeight() { return height;}
	public boolean isEntrainDeSeDeplacer() { return entrainDeSeDeplacer; }   
	public GameObjectType getType() { return type; }   
	
	public void setType(GameObjectType type) { this.type = type; }
	public void setX(int x) { this.x = x; }   
	public void setY(int y) { this.y = y; }   
	public void setVelX(int velX) { this.velX = velX; }   
	public void setVelY(int velY) { this.velY = velY; }   
	public void setWidth(int width) { this.width = width; }   
	public void setHeight(int height) { this.height = height; }   
	public void setEntrainDeSeDeplacer(boolean peutSeDeplacer) { this.entrainDeSeDeplacer = peutSeDeplacer; }


	public abstract void update();
	public abstract void render(Graphics2D g);


	@Override
	public void keyPressed(KeyEvent e) {}


	@Override
	public void keyReleased(KeyEvent e) {}


	@Override
	public void keyTyped(KeyEvent e) {}



	
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, width, height);
	}
	
	
	
	
	
	
}
