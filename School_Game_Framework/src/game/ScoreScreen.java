package game;

import java.awt.Color;
import java.awt.Font;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class ScoreScreen extends Level {

	private static boolean result = true;
	private Font font = new Font("Verdana", Font.BOLD, 25);
	private static ScoreScreen instanceScoreScreen = null;
	private static String previousScenario = null;
	private static String nextScenario = null;

	private int resultPosition = 0;
	
	private ScoreScreen(Window gameWindow) {

		window = gameWindow;
		scenarioName = "ScoreScreen";
		background = new GameImage("src//recursos//sprite//lousa.jpeg");
		
	}

	public static ScoreScreen getScoreScreenInstance(Window gameWindow){
		
		if(instanceScoreScreen == null) {
			
			instanceScoreScreen = new ScoreScreen(gameWindow);
			return instanceScoreScreen;
		} else {
			return instanceScoreScreen;
		}
		
	}
	
	
	protected void updateScenario() {
		
		while(nextScenario == null) {
			
			drawObjects();
			background.draw();
			window.update();			
		
		}
	}
	
	public String runScenario() {
		nextScenario = null;
		this.initializeKeyboard();
		this.updateScenario();
		return nextScenario;
		
	}
	
	public void initializeKeyboard() {
		if(window != null) {
			sceneKeyboard = window.getKeyboard();
		} else {
			System.out.println("The keyboard needs a window to run. The window cannot be null");
		}
		sceneKeyboard.setBehavior(Keyboard.ENTER_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
	}

	
	
	private void waitATime() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	


	public static void setNextLevel(String level) {
		nextScenario = level;
	}
	
	public static void setPreviousLevel(String level) {
		previousScenario = level;
	}
	
	private void pressEnter() {
		if(sceneKeyboard.keyDown(Keyboard.ENTER_KEY)) {
			//Do something
		  }
	}
}
