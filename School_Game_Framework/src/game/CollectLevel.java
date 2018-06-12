package game;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class CollectLevel extends TemplateCollectLevel {

	private String scenarioName;
	private GameObject object;

	public CollectLevel(Window gameWindow, String name) {
		this.window = gameWindow;
		this.scenarioName = name;
	}

	@Override
	protected void initializeObjects() {
	}

	@Override
	protected void initializeKeyboard() {
		if (window != null) {
			sceneKeyboard = window.getKeyboard();
		} else {
			System.out.println("The keyboard needs a window to run. The window cannot be null");
		}
		sceneKeyboard.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_EVERY_PRESS);
		sceneKeyboard.setBehavior(Keyboard.UP_KEY, Keyboard.DETECT_EVERY_PRESS);
		sceneKeyboard.setBehavior(Keyboard.LEFT_KEY, Keyboard.DETECT_EVERY_PRESS);
		sceneKeyboard.setBehavior(Keyboard.RIGHT_KEY, Keyboard.DETECT_EVERY_PRESS);
	}

	@Override
	protected void drawLevel() {
		while (nextScenario == null) {
			background.draw();
		}
	}

	@Override
	public String runScenario() {
		// TODO Auto-generated method stub
		return nextScenario;
	}



}
