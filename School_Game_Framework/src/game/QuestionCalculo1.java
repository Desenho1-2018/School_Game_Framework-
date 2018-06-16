package game;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class QuestionCalculo1 extends Level {

	private GameObject arrow = null;
	private int option = 0;
	private String nextScenario =  null; 
	private int numberQuestion;
	 QuestionColletion aquestion;
	    QuestionColletion aquestion3;
	    QuestionColletion aquestion2;
	//Constroi a cena e
	//adiciona objetos na cena
	public QuestionCalculo1(Window gameWindow, String name, int numberQuestion ) {
	   
		window = gameWindow;
		scenarioName = name;
		background = new GameImage("src//recursos//sprite//lousa.jpeg");
		arrow = new GameObject(50, 300, "src//recursos//sprite//arrow_transparente.png", 1, GameObjectType.OTHER);
		this.numberQuestion = numberQuestion;
		this.addPlayer(700,50,"src//recursos//sprite//jogador2.png", 20, window);
		int i;
		
	public void printquestiontela(QuestionColletion aquestion3 ) {
	    	int i;
			for(i=0;i<aquestion3.sizeQuestions();i++) {
				this.addSceneObjects(aquestion3.getquestion(i));	
			}
	    	
	    }
	public QuestionColletion add(int x, int y, String s, QuestionColletion aquestion3) {
		Question2 question1=new Question2(x,y,s);
		aquestion3.setquestion(question1);
		return  aquestion3;
		
	}
		
		
	

	//Atualiza os quadros da cena
	protected void updateScenario() {
		
		while(nextScenario == null) {
		
			drawObjects();
			System.out.println("Score player " + this.playerInstance.getScore());
			//Arrow n�o esta na lista de objetos por ser um objeto especifico com movimento.
			//fica como TO DO o que fazer para generalizar objetos desse tipo tamb�m.
			arrow.draw();
			moveArrow();
			selectOption(numberQuestion);
			
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
		sceneKeyboard.setBehavior(Keyboard.ENTER_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
	
	}
	
	public String runScenario() {
	
		initializeKeyboard();
		updateScenario();
		System.out.println(nextScenario);
		this.playerInstance.setPreviousLevel("LevelC1");
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
			arrow.y = 300;
			 break;
		  case 1:
			arrow.y = 350;
			 break;
		  case 2:
			arrow.y = 400;
			 break;
		  case 3:
			arrow.y = 450;
			  break;
		  default:
			//do nothing
			break;
		}
		
	}
	private void SelectOption2(QuestionColletion aquestion4) {
		if(option==aquestion4.getcerta()) {
			waitAtime();
			nextScenario = "BattleScene";
		}else {
			this.playerInstance.setScore(1);
			waitAtime();
			nextScenario = "BattleScene";
			}
		}
	private void selectOption(int numberQuestion) {
	
		if(sceneKeyboard.keyDown(Keyboard.ENTER_KEY)) {
		  if(numberQuestion == 1){
			  SelectOption2(this.aquestion);
			}else if(numberQuestion==2) {
			  SelectOption2(this.aquestion2);
		    }else if(numberQuestion==3){
		      SelectOption2(this.aquestion3);
		    }
		
			  }
		}
	
	private void waitAtime() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
