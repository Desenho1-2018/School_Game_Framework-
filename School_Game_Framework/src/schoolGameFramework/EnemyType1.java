package schoolGameFramework;

public class EnemyType1 extends Enemy{
	
	public void roar() {
		System.out.println("GRRRRRRRRR");
	}
	
	public EnemyType1() {
		super(300, 150, "src//recursos//sprite//zumbi2.png", 1, GameObjectType.SIMPLE_ENEMMY);
		reactionType = new SlowDownHero();
	}

}
