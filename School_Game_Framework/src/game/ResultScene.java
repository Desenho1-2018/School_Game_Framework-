package game;

import java.awt.Color;
import java.awt.Font;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class ResultScene extends Level{

	private static boolean result = true;
	private Font font = new Font("Verdana", Font.BOLD, 25);
	private static ResultScene instanceResult = null;
	private static String previousScenario = null;
	private static String nextScenario = null;
	private static String scoreScenario = null;
	private static String questionScenario = null;
	private static String correctAnswer = "RESPOSTA CERTA!!!";
	private static String wrongAnswer = "RESPOSTA ERRADA!!!";
	private int resultPosition = 0;
	
	private ResultScene(Window gameWindow, boolean result) {

		window = gameWindow;
		scenarioName = "ResultScene";
		//this.result = result;
		background = new GameImage("src//recursos//sprite//lousa.jpeg");
		
	}

	public static ResultScene getResultInstance(Window gameWindow, boolean result){
		
		if(instanceResult == null) {
			
			instanceResult = new ResultScene(gameWindow, result);
			return instanceResult;
		} else {
			//instanceResult.setResult(result);
			return instanceResult;
		}
		
	}
	
	
	protected void updateScenario() {
		
		while(nextScenario == null) {
			
			drawObjects();
			background.draw();
			printResult(result);
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

	private void printResultFalse() {
		
		window.drawText(wrongAnswer, 130, 230, Color.red, font);
		window.drawText("enter", 130, 450, Color.WHITE, font);
		
	}
	
	private void printResultTrue() {

		window.drawText(correctAnswer, 130, 230, Color.green, font);
		window.drawText("enter", 130, 450, Color.WHITE, font);
		
	}
	
	private void printResult(boolean result) {
		
		if(result) {
			printResultTrue();	
		} else {
			printResultFalse();
		}
		
		
		waitATime(1000);
		
	}
	
	private void waitATime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public static void setResult(boolean result_of_question) {
		result = result_of_question;
	}
	
	public static void setQuestionScenario(String level) {
		questionScenario = level;
	}
	
	public static void setScoreScenario(String level) {
		scoreScenario = level;
	}

	public static void setNextLevel(String level) {
		nextScenario = level;
	}
	
	private void pressEnter() {
		if(sceneKeyboard.keyDown(Keyboard.ENTER_KEY)) {
			if(resultPosition < 2) {
				System.out.println(resultPosition);
				resultPosition++;
				nextScenario = questionScenario;
			} else {
				resultPosition = 0;
				nextScenario = scoreScenario;
				}
		  }
	}
	
	public static void setCorrectAnswerMessage(String correctMessage) {
		correctAnswer = correctMessage;
	}
	
	public static void setWrongMessage(String wrongMessage) {
		wrongAnswer = wrongMessage;
	}
	
}
