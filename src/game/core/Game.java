package game.core;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import game.pong.Ball;
import game.pong.Fenetre;
import game.pong.HUD;
import game.pong.Raquette;

public class Game implements Runnable {

	public static final int WIDTH  = 1200;
	public static final int HEIGHT = WIDTH * 3 / 4 ;
	public static GameContext gameContext = new GameContext();
	
	private Fenetre 	fenetre;
	private Thread		thread;
	private boolean 	jeuEnCours;
	
	
	// CONSTRUCTORS ///////////////////////////////////////////////////////////
	
	public Game(){
		
		this.fenetre 	 = new Fenetre(WIDTH, HEIGHT);
		initGame();
		
	}
	
	// GET-SET ////////////////////////////////////////////////////////////////
	
	
	// PUBLIC METHODS /////////////////////////////////////////////////////////
	
	
	public void initGame(){
		HUD hud = new HUD(0, 0);
		Raquette raqueteG = new Raquette(10, 40);
		Raquette raqueteD = new Raquette(WIDTH-30, 160);
		Ball ball = new Ball(200, 200);
	
		gameContext.addGameObject(hud);
		gameContext.addGameObject(raqueteG);
		gameContext.addGameObject(raqueteD);
		gameContext.addGameObject(ball);

		this.fenetre.addKeyListener(raqueteG);
		this.fenetre.addKeyListener(raqueteD);
	}
	

	public void lancerJeu(){
		this.jeuEnCours = true;
		this.thread = new Thread(this);
		this.thread.start();
	}
	
	public void arreterLeJeu(){
		try {
			this.thread.join();
		
		} catch (Exception e) { System.out.println(e.getMessage());	}
	}
	
	
	// PRIVATE METHODS /////////////////////////////////////////////////////////////

	private void updateGame() {
		gameContext.updateAllGameObjects();
	}
	
	private void renderGame() {
		final BufferStrategy bs = fenetre.getBufferStrategy();
		if(bs == null){
			fenetre.createBufferStrategy(3);
			return;
		}
		
		final Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		gameContext.renderAllGameObjects(g);
		
		
		g.dispose();
		bs.show();
	}
		
	
	public void run() {
		double nextTime = System.nanoTime()/ 1000_000_000.0;
		double delta 	= 1/240.0;
		
		while(jeuEnCours){
			double now = System.nanoTime()/ 1000_000_000.0;
			if(now >= nextTime){
				nextTime += delta;
				updateGame();
				renderGame();
			}else{
				try {
					Thread.sleep((long) (nextTime-now));
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		arreterLeJeu();
	}
	
	
	
	
	// MAIN ///////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		new Game().lancerJeu();
	}







}
