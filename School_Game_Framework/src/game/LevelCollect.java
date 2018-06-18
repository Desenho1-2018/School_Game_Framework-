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
	private GameImage background;
	private ArrayList<GameObject> object = new ArrayList<GameObject>();
	private Keyboard keyboard;
	private Time time;
	private String defeat;
	private String win;
	private boolean hasEnemies = false;
	private ArrayList<GameObject> enemies = new ArrayList<GameObject>();
	private String nextScenario = null;

	public LevelCollect(Window gameWindow, String name) {
		this.window = gameWindow;
		scenarioName = name;
		addPlayer(100, 100, "src//recursos//sprite//jogador2.png", 20, window);
	}
	public void createBackground(String imagePath) {
		this.background = new GameImage(imagePath);
	}
	public void createObject(GameObject obj) {
		this.object.add(obj);
	}
	public void createTime(int hour, int minute, int second, int x, int y, Boolean crescentTime) {
		this.time = new Time(hour, minute, second, x, y, crescentTime);
	}
	public void defeatScenario(String scenarioDefeat) {
		this.defeat = scenarioDefeat;
	}

	public void winScenario(String scenarioWin) {
		this.win = scenarioWin;
	}
	
	public void enemySpawn(GameObject enemy) {
		if(hasEnemies == true) {
			this.object.add(enemy);
		}
		
	}
	public String runScenario() {
		initializeKeyboard();
		updateScenario();
		System.out.println("dentro do run " + nextScenario);
		return nextScenario;
	}
	
	public void updateScenario() {
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
			for (GameObject enemy : enemies) {
				enemy.draw();
				if (playerInstance.collided(enemy)) {
					enemy.hide();		
				}
			}
			playerInstance.move(window);

			window.update();
		}
	}
	@Override
	public void initializeKeyboard() {
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
