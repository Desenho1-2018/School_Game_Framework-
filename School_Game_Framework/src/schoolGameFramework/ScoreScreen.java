package schoolGameFramework;

import java.awt.Color;
import java.awt.Font;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class ScoreScreen extends Level {

	@SuppressWarnings("unused")
	private static boolean result = true;
	private Font font = new Font("Verdana", Font.BOLD, 25);
	private Font fontResult = new Font("Verdana", Font.BOLD, 40);
	private static ScoreScreen instanceScoreScreen = null;
	@SuppressWarnings("unused")
	private static String previousScenario = null;
	private static String nextScenario = null;
	private static String nextScreen = null;
	private static Score score = null;
	private static int scoreIndex = 0;

	@SuppressWarnings("unused")
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
			window.drawText("RESULTADO", 300, 200, Color.white, font);
			//if(scoreIndex == 0) {
				//window.drawText(score.getScoreType(0), 315, 300, Color.white, fontResult);
			//} else {
				window.drawText(score.getScoreType(scoreIndex), 315, 300, Color.white, fontResult);
			//}
			window.drawText("Press Enter", 100, 550, Color.white, font);
			pressEnter();
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

	
	
	@SuppressWarnings("unused")
	private static void waitATime(int time) {
		try {
			Thread.sleep(time);
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
			 nextScenario = nextScreen;
		  }
	}
	
	public static void setNextScreen(String screen) {
		nextScreen = screen;
	}
	
	public static void addScore(Score sc) {
		score = sc;
	}
	
	public static void plusScore() {
		if(scoreIndex < 3) {
			scoreIndex++;
			System.out.println(scoreIndex);
		} else {
			System.out.println("The maximum number of score is 3");
		}
	}
	
	public static void resetScore() {
		scoreIndex = 0;
	}
	
}
