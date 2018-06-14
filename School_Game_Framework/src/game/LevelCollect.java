package game;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Time;
import jplay.Window;

public class LevelCollect extends TemplateCollectLevel {
	private Window window;
	private String nameScenario;
	private GameImage background;
	private ArrayList<GameObject> object = new ArrayList<GameObject>();
	private Keyboard keyboard;
	private Time time;
	private String defeat;
	private String win;
	private String nextScenario = null;

	public LevelCollect(Window gameWindow, String name) {
		this.window = gameWindow;
		this.nameScenario = name;
		addPlayer(100, 100, "src//recursos//sprite//jogador2.png", 20, window);
	}
	@Override
	public void createBackground(String imagePath) {
		this.background = new GameImage(imagePath);
	}
	@Override
	public void createObject(GameObject obj) {
		this.object.add(obj);
	}
	@Override
	public void createTime(int hour, int minute, int second, int x, int y, Boolean crescentTime) {
		this.time = new Time(hour, minute, second, x, y, crescentTime);
	}
	@Override
	protected void defeatScenario(String scenarioDefeat) {
		this.defeat = scenarioDefeat;
	}

	@Override
	protected void winScenario(String scenarioWin) {
		this.win = scenarioWin;
	}
	@Override
	public String runScenario() {
		System.out.println("dentro do run " + nextScenario);
		return nextScenario;

	}
	@Override
	public void drawLevel() {
		boolean coletaItem = false;
		time.setColor(Color.ORANGE);
		time.setFont(new Font("sansserif", Font.TRUETYPE_FONT, 15));
		
		while (nextScenario == null) {
			background.draw();
			time.draw();
			playerInstance.draw();
			playerInstance.setCollisionType(this.playerCollision());
			for (GameObject obj : object) {
				obj.draw();
				if (playerInstance.collided(obj)) {
					obj.hide();
					coletaItem = true;
				}
				if (coletaItem == true) {
					nextScenario = win;
				}
				if(time.getSecond() == 0) {
					nextScenario = defeat;
				}
			}
			playerInstance.move(window);

			window.update();
		}
	}
	@Override
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
