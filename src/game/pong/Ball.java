package game.pong;

import java.awt.Color;
import java.awt.Graphics2D;

import game.core.Game;
import game.core.GameObject;
import game.core.GameObjectType;
import game.tools.Utils;

public class Ball extends GameObject {

	public Ball(int x, int y) {
		super(x, y);
		this.type = GameObjectType.BALL;
		this.width = 40;
		this.height = 40;
		
		velX = 3;
		velY = 3;
		
		
	}

	@Override
	public void update() {
		collision();
		x += velX;
		y += velY;
		
		if(x < 0 || x >= Game.WIDTH - width ) velX *= -1;
		if(y < 40 || y >= Game.HEIGHT - height - 20) velY *= -1;
		Game.gameContext.addGameObject(new Trail(x, y, width, height, Color.RED));
		
	}

	@Override
	public void render(Graphics2D g) {
		
		g.setColor(Color.RED);
		g.fillOval(x, y, width, height);
		
		// HitBox
//		g.setColor(Color.GREEN);
//		g.drawRect(x, y, width, height);
		
		

	}
	
	
	private void collision(){
		for(int i=0, l=Game.gameContext.getListeGameObjects().size(); i<l; i++){
			
			final GameObject gameObject = Game.gameContext.getListeGameObjects().get(i);
			
			if( GameObjectType.RAQUETTE == gameObject.getType() && getBounds().intersects(gameObject.getBounds()) ){
				velX *= -1;
				velY *= Utils.memeSigne(velY, gameObject.getVelY()) ? 1 : -1;
			}
		}
	}
	
	

}
