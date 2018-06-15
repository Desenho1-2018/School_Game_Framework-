package game;

import jplay.Window;

public class Main {

	public static void main(String[] args) {
		//LevelQuestion question = new LevelQuestion();
		Window gameWindow = new Window(800, 600);
		LevelStateMachine levelStateMachine = new LevelStateMachine();
		
		LevelQuestion xablau = new LevelQuestion(gameWindow, "XABLAU");
		
		levelStateMachine.addScenario(xablau);
		levelStateMachine.run("XABLAU");
		
		
		
	}

}
