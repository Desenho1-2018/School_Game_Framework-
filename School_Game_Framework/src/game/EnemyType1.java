package game;

public class EnemyType1 extends Enemy{
	
	public void roar() {
		System.out.println("GRRRRRRRRR");
	}
	
	public EnemyType1() {
		super(damage, damage, enemyType, damage, type);
		reactionType = new SlowDownHero();
	}
}
