package game;

public abstract class TemplateCollectLevel extends Level {
	
	public String runScenario() {
		initializeKeyboard();
		updateScenario();
		System.out.println("dentro do run " + nextScenario);
		return nextScenario;
	}

	public abstract void createBackground(String imagePath);
	
	public abstract void createObject(GameObject obj);
	
	public abstract void createTime(int hour, int minute, int second, int x, int y, Boolean crescentTime);
	
	public abstract void defeatScenario(String nextScenario);
	
	public abstract void winScenario(String nextScenario);
	
	public abstract void initializeKeyboard();
	
	public abstract void updateScenario();

	public abstract void enemySpawn(GameObject enemy);
	
}
