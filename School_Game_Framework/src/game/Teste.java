package game;

import jplay.Window;

public class Teste {

	public static void main(String[] args) {
		Window gameWindow = new Window(800, 600);
		String backgroundImage = "src//recursos//tiles//planofundo.png";
		GameObject obj1 = new GameObject(150, 200, "src//recursos//sprite//livro.gif", 1, GameObjectType.REFERENCE_ITEM);
		GameObject obj2 = new GameObject(660, 500, "src//recursos//sprite//canudol.gif", 1, GameObjectType.REFERENCE_ITEM);
		LevelCollect level = new LevelCollect(gameWindow, "Level1");
		level.createBackground(backgroundImage);
		level.createTime(0, 0, 30, 50, 50, false);
		level.createObject(obj1);
		level.createObject(obj2);
		level.runScenario();
	}

}
