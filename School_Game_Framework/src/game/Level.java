package game;


import jplay.Window;
import game.Player;

public abstract class Level extends Scenario {
	
	/**
	 * Esta classe � respons�vel por, somente, as fases do jogo.
	 * A sua diferen�a de scenario � que ela possui o m�todo de
	 * colis�o com todas as paredes do jogo.
	 */
	
	
	//Player
	protected Player playerInstance = null;
	
	//Metodos
	protected void addPlayer(int posX, int posY, String spritePath,  int spriteDivision, Window gameWindow){
		this.playerInstance = Player.getPlayerInstance(posX, posY, spritePath, spriteDivision, gameWindow);
	}
	
	protected GameObjectType playerCollision() {
	
		GameObjectType type = null;
		
		for(GameObject obj : sceneObjects) {
			
			if(playerInstance.collided(obj)) {
				
				if(obj.getType() == GameObjectType.WALL) {
					type = GameObjectType.WALL;
				} else if(obj.getType() == GameObjectType.QUESTION_ENNEMY) {
					type = GameObjectType.QUESTION_ENNEMY;
				} else if(obj.getType() == GameObjectType.REFERENCE_ITEM) {
					type = GameObjectType.REFERENCE_ITEM;
				} else if(obj.getType() == GameObjectType.SIMPLE_ENEMMY) {
					type = GameObjectType.SIMPLE_ENEMMY;
				} else if(obj.getType() == GameObjectType.OTHER) {
					type = GameObjectType.OTHER;
				} else if(obj.getType() == GameObjectType.NOTHING) {
					type = GameObjectType.NOTHING;
				} else if(obj.getType() == GameObjectType.TRANSITION) {
					type = GameObjectType.TRANSITION;
				}
				
			}
		
		}
		
		return type;
	}
	
	protected void initializeObjects() {};

}
