package game;

public class EnemyType2 extends Enemy{
	
	public void roar() {
		System.out.println("HOOOOOAAARR");
	}
	
	public EnemyType2() {
		super();
		reactionType = new DoesDamageHero();
	}
}
