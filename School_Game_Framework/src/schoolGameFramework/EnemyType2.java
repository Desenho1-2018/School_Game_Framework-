package schoolGameFramework;

public class EnemyType2 extends Enemy{
	
	public void roar() {
		System.out.println("HOOOOOAAARR");
	}
	
	public EnemyType2() {
		super(500, 150, "src//recursos//sprite//zumbi2.png", 1, GameObjectType.SIMPLE_ENEMMY);
		reactionType = new DoesDamageHero();
	}
}
