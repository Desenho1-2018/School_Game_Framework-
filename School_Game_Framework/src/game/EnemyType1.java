package game;

public class EnemyType1 extends Enemy{
	
	public void roar() {
		System.out.println("GRRRRRRRRR");
	}
	
	public EnemyType1() {
		super();
		reactionType = new SlowDownHero();
	}
}
