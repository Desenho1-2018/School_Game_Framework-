package game;

import jplay.Window;

public class Main {

	public static void main(String[] args) {

		Window gameWindow = new Window(800, 600);
		LevelStateMachine levelStateMachine = new LevelStateMachine();
		
		LevelQuestion xablau = new LevelQuestion(gameWindow, "XABLAU");
		
		Question teste = new Question("TESTE");
		
		Alternative testeA = new Alternative(1,"TESTE A",false);
		Alternative testeB = new Alternative(2,"TESTE B",false);
		Alternative testeC = new Alternative(3,"TESTE C",true);
		Alternative testeD = new Alternative(4,"TESTE D",false);


		teste.addAlternative(testeA);
		teste.addAlternative(testeB);
		teste.addAlternative(testeC);
		teste.addAlternative(testeD);

		xablau.addQuestion(teste);
		
		
		ResultScene result = ResultScene.getResultInstance(gameWindow, false);
		MainMenu mainmenu = new MainMenu(gameWindow, "MainMenu");
		
		levelStateMachine.addScenario(xablau);
		levelStateMachine.addScenario(result);
		levelStateMachine.addScenario(mainmenu);
		levelStateMachine.run("MainMenu");
		
	}

}
