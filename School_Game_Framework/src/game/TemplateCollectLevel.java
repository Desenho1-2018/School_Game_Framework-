package game;

public abstract class TemplateCollectLevel extends Level {
	
	public final void initializeLevel() {
		initializeKeyboard();
		drawLevel();
		runScenario();
	}

	protected abstract void createBackground(String imagePath);
	
	protected abstract void createObject(GameObject obj);
	
	protected abstract void createTime(int hour, int minute, int second, int x, int y, Boolean crescentTime);
	
	protected abstract void defeatScenario(String nextScenario);
	
	protected abstract void winScenario(String nextScenario);
	
	protected abstract void initializeKeyboard();

	protected abstract void drawLevel();

	public abstract String runScenario();

	protected abstract void enemySpawn(GameObject enemy);
	
}
