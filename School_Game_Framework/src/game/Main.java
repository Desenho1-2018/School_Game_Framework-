package game;

import jplay.Window;

public class Main {

	public static void main(String[] args) {

		Window gameWindow = new Window(800, 600);
		LevelStateMachine levelStateMachine = new LevelStateMachine();
		
		LevelQuestion xablau = new LevelQuestion(gameWindow, "XABLAU");
		
		Question teste1 = new Question("TESTE NUMERO 1");
		
		Alternative testeA1 = new Alternative(1,"TESTE A",false);
		Alternative testeB1 = new Alternative(2,"TESTE B",false);
		Alternative testeC1 = new Alternative(3,"TESTE C",true);
		Alternative testeD1 = new Alternative(4,"TESTE D",false);


		teste1.addAlternative(testeA1);
		teste1.addAlternative(testeB1);
		teste1.addAlternative(testeC1);
		teste1.addAlternative(testeD1);

		Question teste2 = new Question("TESTE NUMERO 2");
		
		Alternative testeA2 = new Alternative(1,"TESTE A",false);
		Alternative testeB2 = new Alternative(2,"TESTE B",false);
		Alternative testeC2 = new Alternative(3,"TESTE C",true);
		Alternative testeD2 = new Alternative(4,"TESTE D",false);


		teste2.addAlternative(testeA2);
		teste2.addAlternative(testeB2);
		teste2.addAlternative(testeC2);
		teste2.addAlternative(testeD2);
		
		Question teste3 = new Question("TESTE NUMERO 3");
		
		Alternative testeA3 = new Alternative(1,"TESTE A",false);
		Alternative testeB3 = new Alternative(2,"TESTE B",false);
		Alternative testeC3 = new Alternative(3,"TESTE C",true);
		Alternative testeD3 = new Alternative(4,"TESTE D",false);


		teste3.addAlternative(testeA3);
		teste3.addAlternative(testeB3);
		teste3.addAlternative(testeC3);
		teste3.addAlternative(testeD3);
		
		
		xablau.addQuestion(teste1);
		xablau.addQuestion(teste2);
		xablau.addQuestion(teste3);
		
		
		ResultScene result = ResultScene.getResultInstance(gameWindow, false);
		
		
		levelStateMachine.addScenario(xablau);
		levelStateMachine.addScenario(result);
		levelStateMachine.run("XABLAU");
		
	}

}
