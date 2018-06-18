package game;

import jplay.Window;

public class Enemy extends GameObject {
	
	public Enemy(int x, int y, String spritePath, int spriteDivision, GameObjectType objtype) {
		super(x, y, spritePath, spriteDivision, objtype);
		// TODO Auto-generated constructor stub
	}

	public static String enemyType;
	public static int damage;
	private int lifePoints;
	private double speed = 0.2;
	public EnemyReacts reactionType;
		
	public String getEnemyType() {
		return enemyType;
	}

	public void setEnemyType(String enemyType) {
		Enemy.enemyType = enemyType;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		Enemy.damage = damage;
	}

	public int getLifePoints() {
		return lifePoints;
	}

	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public EnemyReacts getReactionType() {
		return reactionType;
	}

	public void setReactionType(EnemyReacts reactionType) {
		this.reactionType = reactionType;
	}
	
	public String verifyReaction() {
		return reactionType.reaction();
	}
	
	//Permite mudar a reacao de um inimigo dinamicamente em tempo de execucao
	public void setReaction(EnemyReacts newReaction) {
		reactionType = newReaction;
	}

	public static Enemy getEnemyInstance(int posX, int posY, String spritePath, int spriteDivision, Window gameWindow) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
