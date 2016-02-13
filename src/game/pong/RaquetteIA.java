package game.pong;

import game.core.Game;
import game.core.GameObject;
import game.tools.Utils;

public class RaquetteIA extends Raquette {

	private GameObject ball;
	
	public RaquetteIA(int x, int y, GameObject ball) {
		super(x, y);
		this.ball = ball;
	}

	
	public GameObject getBall() { return ball; }  
	
	public void setBall(GameObject ball) { this.ball = ball; } 
	
    public void moveAi(){
        if(ball.getX() >= Game.WIDTH/2){    
            if(ball.getY() < y && y>=2)
            	this.setVelY(-VITESSE);
            if(ball.getY() >y && y+height <=Game.HEIGHT+10)
            	this.setVelY(VITESSE);
        }else{
        	if (y < Game.HEIGHT/2.0){
        		this.setVelY(-VITESSE);
        	}else{
        		this.setVelY(VITESSE);
        	}
        }
    }


	@Override
	public void update() {
		moveAi();
		y += velY;
		y = Utils.clamp(y, 40, Game.HEIGHT - height - 20);	
	}
	
	
    
	

}
