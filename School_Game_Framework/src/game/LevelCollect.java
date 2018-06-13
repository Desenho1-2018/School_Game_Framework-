package game;

import java.util.ArrayList;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class LevelCollect extends Level {
	private Window window;
	private String nameScenario;
	private GameImage background;
	private ArrayList<GameObject> object = new ArrayList<GameObject>();
	private Keyboard keyboard;

	public LevelCollect(Window gameWindow, String name) {
		this.window = gameWindow;
		this.nameScenario = name;
		addPlayer(100, 100, "src//recursos//sprite//jogador2.png", 20, window);
	}

	public void createBackground(String imagePath) {
		this.background = new GameImage(imagePath);
	}

	public void createObject(GameObject obj) {
		this.object.add(obj);
	}

	public String runScenario() {
		initializeKeyboard();
		drawLevel();
		return nextScenario;

	}

	public void drawLevel() {
		boolean coletaItem = false;

		while (nextScenario == null) {
			background.draw();
			playerInstance.draw();
			playerInstance.setCollisionType(this.playerCollision());
			for (GameObject obj : object) {
				obj.draw();
				if (playerInstance.collided(obj)) {
					obj.hide();
					coletaItem = true;
				}
				if (coletaItem == true) {
					System.out.println("Fui pra outra fase");
				}
			}
			playerInstance.move(window);

			window.update();
		}
	}

	protected void initializeKeyboard() {
		if (window != null) {
			keyboard = window.getKeyboard();
		} else {
			System.out.println("The keyboard needs a window to run. The window cannot be null");
		}
		keyboard.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.setBehavior(Keyboard.UP_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.setBehavior(Keyboard.LEFT_KEY, Keyboard.DETECT_EVERY_PRESS);
		keyboard.setBehavior(Keyboard.RIGHT_KEY, Keyboard.DETECT_EVERY_PRESS);
	}
}
