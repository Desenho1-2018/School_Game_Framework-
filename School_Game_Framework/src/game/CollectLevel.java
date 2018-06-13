package game;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class CollectLevel extends TemplateCollectLevel {

	private String scenarioName;
	private GameObject object;
	private GameImage background;

	public CollectLevel(Window gameWindow, String name) {
		this.window = gameWindow;
		this.scenarioName = name;
	}

//	@Override
//	protected void initializeObjects(String backgroundImage) {
//		createBackground(backgroundImage);
//	}

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
		while (true) {
			background.draw();
			window.update();
		}
	}

	@Override
	public String runScenario() {
		// TODO Auto-generated method stub
		return nextScenario;
	}

	public void createBackground(String backgroundImage) {
		background = new GameImage(backgroundImage);
	}

	@Override
	protected void initializeObjects() {
		// TODO Auto-generated method stub
		
	}


}
