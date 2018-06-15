package game;

import java.awt.Color;
import java.awt.Font;

import jplay.GameImage;
import jplay.Window;

public class ResultScene extends Level{

	private boolean result = true;
	private Font font = new Font("Verdana", Font.BOLD, 25);
	
	public ResultScene(Window gameWindow, String name) {

		window = gameWindow;
		scenarioName = name;
		background = new GameImage("src//recursos//sprite//lousa.jpeg");
		
	}

	protected void updateScenario() {
		
		while(nextScenario == null) {
			
			drawObjects();
			background.draw();
			printResult(result);
			window.update();
			
		}
		
	}
	
	public String runScenario() {
		
		this.initializeKeyboard();
		this.updateScenario();
		return nextScenario;
		
	}
	
	public void initializeKeyboard() {
		//TO DO
	}

	private void printResultFalse() {
		
		window.drawText("ALGO DE ERRADO NÃO ESTÁ CERTO", 130, 230, Color.red, font);
		
	}
	
	private void printResultTrue() {
		
		window.drawText("ALGO DE CERTO NÃO ESTÁ ERRADO", 130, 230, Color.green, font);
		
	}
	
	private void printResult(boolean result) {
		
		if(result) {
			printResultTrue();
		} else {
			printResultFalse();
		}
		
		waitATime();
		
	}
	
	private void waitATime() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	
}
