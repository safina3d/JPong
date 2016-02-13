package game.core;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;


public class GameContext {

	private List<GameObject> listeGameObjects = new ArrayList<GameObject>();

	// GET-SET ////////////////////////////////////////////////////////////////
	
	public List<GameObject> getListeGameObjects() { return listeGameObjects; }
	
	public void setListeGameObjects(List<GameObject> listeGameObjects) { this.listeGameObjects = listeGameObjects; } 

	
	// PUBLIC METHODS /////////////////////////////////////////////////////////
	
	public void addGameObject(GameObject gameObject){
		listeGameObjects.add(gameObject);
	}

	public void removeGameObject(GameObject gameObject){
		listeGameObjects.remove(gameObject);
	}
	
	
	

	public void updateAllGameObjects() {
		for(int i=0; i<listeGameObjects.size(); i++){
			final GameObject gameObject = listeGameObjects.get(i);
			gameObject.update();
		}
	}

	public void renderAllGameObjects(Graphics2D g) {
		for(int i=0; i<listeGameObjects.size(); i++){
			final GameObject gameObject = listeGameObjects.get(i);
			gameObject.render(g);;
		}

	}

}
