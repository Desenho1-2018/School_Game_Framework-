package game;

import java.util.ArrayList;

import jplay.Window;

public class LevelQuestion extends Level{

	private String statement; //Enunciado da questao
	private ArrayList<Alternative> alternatives; //Alternativas da questao
	
	public LevelQuestion(Window gameWindow, String name){
		
		window = gameWindow;
		scenarioName = name;
		
	};
	
	protected void updateScanario() {
		
		while(nextScenario == null) {
			
			drawObjects();
			window.update();
			
		}
		
	}
	
	protected void initializeKeyboard() {
		//TO DO
	}

	public String runScenario() {
		
		initializeKeyboard();
		updateScenario();
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
