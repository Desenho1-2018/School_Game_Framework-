package game;

import java.util.ArrayList;

import jplay.GameImage;
import jplay.Window;

public class LevelQuestion extends Level{
	
	public LevelQuestion(Window gameWindow, String name){
		
		window = gameWindow;
		scenarioName = name;
		background = new GameImage("src//recursos//sprite//lousa.jpeg");
		
	};
	
	protected void updateScenario() {
		
		//System.out.println("ESTOU AQUIIIIIIIIII!");
		
		while(nextScenario == null) {
			
			drawObjects();
			background.draw();
			//System.out.println("aaaaaaaaaaaaaaaaaaaaaaahhh eu to maluco");
			window.update();
			
			
		}
		
	}
	
	protected void initializeKeyboard() {
		//TO DO
	}

	public String runScenario() {
		
		initializeKeyboard();
		this.updateScenario();
		//this.playerInstance.setPreviousLevel("XABLAU");
		return nextScenario;
		
	}
	
	private void waitATime() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
