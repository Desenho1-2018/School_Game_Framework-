package game;

public class Enemy {

	private String enemyType;
	private int damage;
	private int lifePoints;
	private double speed;
	
	public EnemyReacts reactionType;

	public String getEnemyType() {
		return enemyType;
	}

	public void setEnemyType(String enemyType) {
		this.enemyType = enemyType;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
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
	
}
