package game.pong;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;

import game.core.Game;
import game.core.GameObject;
import game.core.GameObjectType;

public class Trail extends GameObject {
	
	private float alpha = 0.3f;
	private Color color;
	
	public Trail(int x, int y, int w, int h, Color color) {
		super(x, y);
		this.type = GameObjectType.TRAIL;
		this.width = w;
		this.height = h;
		this.color = color;
	}

	@Override
	public void update() {
		if(alpha > 0){
			alpha -= 0.01;
			//this.width *= 0.98;
			//this.height *= 0.98;
		}else{
			Game.gameContext.removeGameObject(this);
		}
		
		
	}

	@Override
	public void render(Graphics2D g) {
		g.setComposite(makeTansparent(alpha));
		g.setColor(this.color);
		g.fillOval(x, y, width, height);
	}

	
	private AlphaComposite makeTansparent(float alpha){
		if(alpha<0) alpha = 0;
		return AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
	}
	
	
}
