package game;

import jplay.GameImage;

public abstract class TemplateCollectLevel extends Scenario {
	public final void initializeLevel() {
		initializeObjects();
		initializeKeyboard();
		drawLevel();
		runScenario();
	}

	protected abstract void initializeObjects();

	protected abstract void initializeKeyboard();

	protected abstract void drawLevel();

	public abstract String runScenario();
}
