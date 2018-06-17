package game;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class Password extends Scenario{
   
	private GameObject selector = null;
	private GameObject enterToEnter = null;
	private Boolean flagComplete = false;
	private GameObject[] letter = new GameObject[6];
	private int letter_pos = 1;
	private String password = "";	
	
   public Password(Window gameWindow, String name) {
		window = gameWindow;
		scenarioName = name;
		background = new GameImage("src//recursos//sprite//password//password_background.png");
   }
   
   private void initializePassword() {
		
		this.selector = new GameObject(150, 300, "src//recursos//sprite//password//select.png", 1, GameObjectType.OTHER);
		this.flagComplete = false;
		this.letter_pos = 1;
		this.password = "";
		this.enterToEnter = new GameObject(250, 400, "src//recursos//sprite//password//enter_to_enter.png", 1, GameObjectType.OTHER);
		this.nextScenario = null;
		
		for(int i = 0; i < 6; i++) {
			letter[i] = new GameObject(-100,-100, "src//recursos//sprite//password//z.png", 1, GameObjectType.OTHER);
		}
		
		this.initializeKeyboard();
		this.initializeObjects();
		
	}
   
   protected void updateScenario() {
		
		while(nextScenario == null) {
		
			this.moveSelector();
			drawObjects();	
			this.selector.draw();
			this.drawLettersPassword();
			this.keyboardControll();
			
			if(password.length() == 6){
				this.flagComplete = true;
			}
			
			if(flagComplete) {
				enterToEnter.draw();
			}
			
			window.update();
		}
	}
   
   protected void initializeKeyboard() {
		
		if(window != null) {
			sceneKeyboard = window.getKeyboard();
		} else {
			System.out.println("The keyboard needs a window to run. The window cannot be null");
		}
		sceneKeyboard.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY); 
		sceneKeyboard.setBehavior(Keyboard.UP_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY); 
		sceneKeyboard.setBehavior(Keyboard.LEFT_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY); 
		sceneKeyboard.setBehavior(Keyboard.RIGHT_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY); 
		sceneKeyboard.setBehavior(Keyboard.ESCAPE_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY); 
		sceneKeyboard.setBehavior(Keyboard.ENTER_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
	
	}
   
}
