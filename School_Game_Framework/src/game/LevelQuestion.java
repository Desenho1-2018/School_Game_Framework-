package game;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import jplay.GameImage;
import jplay.Window;

public class LevelQuestion extends Level{
	
	private Question question = null;
	private Font font = new Font("Verdana", Font.BOLD, 25);
	
	public LevelQuestion(Window gameWindow, String name){
		
		window = gameWindow;
		scenarioName = name;
		background = new GameImage("src//recursos//sprite//lousa.jpeg");
		
	};
	
	protected void updateScenario() {
		
		while(nextScenario == null) {
			
			drawObjects();
			background.draw();
			
			
			//System.out.println(question.getStatement());
			window.drawText(question.getStatement(), 90, 140, Color.white, font);
			window.drawText(question.getAlternative(0).getAlternative(), 120, 200, Color.white, font);
			window.drawText(question.getAlternative(1).getAlternative(), 120, 260, Color.white, font);
			window.drawText(question.getAlternative(2).getAlternative(), 120, 320, Color.white, font);
			window.drawText(question.getAlternative(3).getAlternative(), 120, 380, Color.white, font);

			
			
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
	
	public void addQuestion(Question q) {
		
		this.question = q;
		
	}
	
}
