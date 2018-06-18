package game;

public class Enemy extends GameObject {
	
	public Enemy(int x, int y, String spritePath, int spriteDivision, GameObjectType objtype) {
		super(x, y, spritePath, spriteDivision, objtype);
		this.x = x;
		this.y = y;
		this.setTotalDuration(2000);
		this.speed = 0.2;
	}

	public static String enemyType;
	public static int damage;
	private int lifePoints;
	private double speed = 0.2;
	private int direction = 3;
	private boolean isMoving = false;
	private static Player instancePlayer = null;
	private GameObjectType collisionType = null;
		
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
