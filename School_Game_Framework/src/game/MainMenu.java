package game;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class MainMenu extends Scenario{
	
	private GameObject arrow = null;
	private Font font = new Font("Verdana", Font.BOLD, 25);
	private int option = 0;
	
	public MainMenu(Window gameWindow, String name){
		
		window = gameWindow;
		scenarioName = name;
		background = new GameImage("src//recursos//sprite//main_menu_white.jpg");
		arrow = new GameObject(270, 210, "src//recursos//sprite//arrow_button.png", 1, GameObjectType.OTHER);
		
	};
	
	protected void updateScenario() {
		
		while(nextScenario == null) {
			
			drawObjects();
			background.draw();
			
			arrow.draw();
			moveArrow();
		
			window.drawText("Customize Seu Titulo Aqui", 240, 140, Color.black, font);
			selectOption();
			window.update();
			window.drawText("Start", 80, 420, Color.black, font);
			window.drawText("Exit", 80, 480, Color.black, font);
			
		}
	}

	public String runScenario() {
		
		initializeKeyboard();
		this.updateScenario();
		return nextScenario;
		
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
			arrow.y = 420;
			arrow.x = 70;
			 break;
		  case 1:
			arrow.y = 480;
			arrow.x = 70;
			 break;
		  default:
			//do nothing
			break;
		}
		
	}
	
    private void selectOption() {
    	if(sceneKeyboard.keyDown(Keyboard.ENTER_KEY)){	
    		if(option == 0){
    			nextScenario = "XABLAU";
    		}else if(option == 1){
    			//exit
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
	
}
