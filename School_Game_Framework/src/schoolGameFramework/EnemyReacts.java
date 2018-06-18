package schoolGameFramework;

public interface EnemyReacts {

	public String reaction();

}

class SlowDownHero implements EnemyReacts {

	public String reaction() {
		return "Hero velocity decreased";
	}
	
}

class DoesDamageHero implements EnemyReacts {

	public String reaction() {
		return "Hero life decreased";
	}
	
}