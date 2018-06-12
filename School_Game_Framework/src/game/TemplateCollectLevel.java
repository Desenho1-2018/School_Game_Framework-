package game;

public abstract class TemplateCollectLevel {
	public final void runScnario() {
		initializeObjects();
		initializeKeyboard();
		drawLevel();
	}
	
	protected abstract void initializeObjects();
	protected abstract void initializeKeyboard();
	protected abstract void drawLevel();	
	
}
