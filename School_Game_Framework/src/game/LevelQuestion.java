package game;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class LevelQuestion extends Level{
	
	private Question question = null;
	private GameObject arrow = null;
	private Font font = new Font("Verdana", Font.BOLD, 25);
	private int option = 0;
	//private ResultScene resultInstance = null;
	
	public LevelQuestion(Window gameWindow, String name){
		
		window = gameWindow;
		scenarioName = name;
		background = new GameImage("src//recursos//sprite//lousa.jpeg");
		arrow = new GameObject(270, 210, "src//recursos//sprite//arrow_button.png", 1, GameObjectType.OTHER);
		//resultInstance = ResultScene.getResultInstance(gameWindow, false);
		
	};
	
	protected void updateScenario() {
		
		while(nextScenario == null) {
			
			drawObjects();
			background.draw();
			
			arrow.draw();
			moveArrow();
			
			//System.out.println(question.getStatement());
			window.drawText(question.getStatement(), 90, 140, Color.white, font);
			window.drawText(question.getAlternative(0).getAlternative(), 120, 200, Color.white, font);
			window.drawText(question.getAlternative(1).getAlternative(), 120, 260, Color.white, font);
			window.drawText(question.getAlternative(2).getAlternative(), 120, 320, Color.white, font);
			window.drawText(question.getAlternative(3).getAlternative(), 120, 380, Color.white, font);
			
			selectOption();
			window.update();
			
		}
		
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
	

    private void moveArrow() {
		
		if(sceneKeyboard.keyDown(Keyboard.DOWN_KEY)) {
				if(option < 3 )
					option = option + 1;
				
		} else if(sceneKeyboard.keyDown(Keyboard.UP_KEY)) {
			 if(option > 0)
				 option = option - 1;
		}

		switch (option) {
		  case 0:
			arrow.y = 170;
			arrow.x = 70;
			 break;
		  case 1:
			arrow.y = 230;
			arrow.x = 70;
			 break;
		  case 2:
			arrow.y = 290;
			arrow.x = 70;
			 break;
		  case 3:
			arrow.y = 350;
			arrow.x = 70;
			  break;
		  default:
			//do nothing
			break;
		}
		
	}
	
    private void selectOption() {
    	
		if(sceneKeyboard.keyDown(Keyboard.ENTER_KEY)) {
			switch(option){
			  case 0:
				waitATime();  
				callResultScene(question.getAlternative(0).getValidate());
				 break;
			  case 1:
				waitATime();
				callResultScene(question.getAlternative(1).getValidate());
				break;	
			  case 2:
				waitATime();
				callResultScene(question.getAlternative(2).getValidate());
				break;
			  case 3:
				waitATime();
				callResultScene(question.getAlternative(3).getValidate());
				break;	
		  }	
		}
	} 
	
    public void initializeKeyboard() {
		
		if(window != null) {
			sceneKeyboard = window.getKeyboard();
		} else {
			System.out.println("The keyboard needs a window to run. The window cannot be null");
		}
		sceneKeyboard.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY); 
		sceneKeyboard.setBehavior(Keyboard.UP_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY); 
		sceneKeyboard.setBehavior(Keyboard.ENTER_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
	
	}
	
	public void addQuestion(Question question) {
		
		this.question = question;
		
	}
	
	private void callResultScene(boolean result) {
		if(result == true) {
			ResultScene.setResult(true);
			this.nextScenario = "ResultScene";
		} else {
			ResultScene.setResult(false);
			this.nextScenario = "ResultScene";
		}
	}
	
}
