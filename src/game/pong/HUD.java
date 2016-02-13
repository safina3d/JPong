package game.pong;

import java.awt.Color;
import java.awt.Graphics2D;

import game.core.Game;
import game.core.GameObject;

public class HUD extends GameObject {

	public HUD(int x, int y) {
		super(x, y);
		
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(Game.WIDTH/2-10, 0, 20, Game.HEIGHT);

		g.setColor(Color.GRAY);
		g.fillRect(0, 0, Game.WIDTH, 40);
		g.fillRect(0, Game.HEIGHT-20, Game.WIDTH, 40);
		
		
		
	}

}
