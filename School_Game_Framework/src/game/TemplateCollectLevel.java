package game;

public abstract class TemplateCollectLevel extends Level {
	
	public String runScenario() {
		initializeKeyboard();
		updateScenario();
		System.out.println("dentro do run " + nextScenario);
		return nextScenario;
	}

	protected abstract void createBackground(String imagePath);
	
	protected abstract void createObject(GameObject obj);
	
	protected abstract void createTime(int hour, int minute, int second, int x, int y, Boolean crescentTime);
	
	protected abstract void defeatScenario(String nextScenario);
	
	protected abstract void winScenario(String nextScenario);
	
	protected abstract void initializeKeyboard();
	
	public abstract void updateScenario();

	protected abstract void enemySpawn(GameObject enemy);
	
}
