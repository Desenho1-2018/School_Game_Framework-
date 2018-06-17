package game;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class Password extends Scenario{
	
	private Font font = new Font("Verdana", Font.BOLD, 25);
	private GameObject selector = null;
	private GameObject enterToEnter = null;
	private Boolean flagComplete = false;
	private GameObject[] letter = new GameObject[6];
	private int letter_pos = 1;
	private String password = "";
	private ArrayList<String> letter_password = new ArrayList<String>();
	
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
   
   public String runScenario() {
		
		this.initializePassword();
		updateScenario();
		return nextScenario;
		
	}
   
   private void initializeObjects(){
		
		GameObject letter_a = new GameObject(150, 298, "src//recursos//sprite//password//a.png", 1, GameObjectType.OTHER);
		GameObject letter_b = new GameObject(186, 298, "src//recursos//sprite//password//b.png", 1, GameObjectType.OTHER);
		GameObject letter_c = new GameObject(222, 298, "src//recursos//sprite//password//c.png", 1, GameObjectType.OTHER);
		GameObject letter_d = new GameObject(258, 298, "src//recursos//sprite//password//d.png", 1, GameObjectType.OTHER);
		GameObject letter_e = new GameObject(294, 298, "src//recursos//sprite//password//e.png", 1, GameObjectType.OTHER);
		GameObject letter_f = new GameObject(330, 298, "src//recursos//sprite//password//f.png", 1, GameObjectType.OTHER);
		GameObject letter_g = new GameObject(366, 298, "src//recursos//sprite//password//g.png", 1, GameObjectType.OTHER);
		GameObject letter_h = new GameObject(402, 298, "src//recursos//sprite//password//h.png", 1, GameObjectType.OTHER);
		GameObject letter_i = new GameObject(438, 298, "src//recursos//sprite//password//i.png", 1, GameObjectType.OTHER);
		GameObject letter_j = new GameObject(474, 298, "src//recursos//sprite//password//j.png", 1, GameObjectType.OTHER);
		GameObject letter_k = new GameObject(510, 298, "src//recursos//sprite//password//k.png", 1, GameObjectType.OTHER);
		GameObject letter_l = new GameObject(546, 298, "src//recursos//sprite//password//l.png", 1, GameObjectType.OTHER);
		GameObject letter_m = new GameObject(582, 298, "src//recursos//sprite//password//m.png", 1, GameObjectType.OTHER);
		GameObject letter_n = new GameObject(150, 335, "src//recursos//sprite//password//n.png", 1, GameObjectType.OTHER);
		GameObject letter_o = new GameObject(186, 335, "src//recursos//sprite//password//o.png", 1, GameObjectType.OTHER);
		GameObject letter_p = new GameObject(222, 335, "src//recursos//sprite//password//p.png", 1, GameObjectType.OTHER);
		GameObject letter_q = new GameObject(258, 335, "src//recursos//sprite//password//q.png", 1, GameObjectType.OTHER);
		GameObject letter_r = new GameObject(294, 335, "src//recursos//sprite//password//r.png", 1, GameObjectType.OTHER);
		GameObject letter_s = new GameObject(330, 335, "src//recursos//sprite//password//s.png", 1, GameObjectType.OTHER);
		GameObject letter_t = new GameObject(366, 335, "src//recursos//sprite//password//t.png", 1, GameObjectType.OTHER);
		GameObject letter_u = new GameObject(402, 335, "src//recursos//sprite//password//u.png", 1, GameObjectType.OTHER);
		GameObject letter_v = new GameObject(438, 335, "src//recursos//sprite//password//v.png", 1, GameObjectType.OTHER);
		GameObject letter_w = new GameObject(474, 335, "src//recursos//sprite//password//w.png", 1, GameObjectType.OTHER);
		GameObject letter_x = new GameObject(510, 335, "src//recursos//sprite//password//x.png", 1, GameObjectType.OTHER);
		GameObject letter_y = new GameObject(546, 335, "src//recursos//sprite//password//y.png", 1, GameObjectType.OTHER);
		GameObject letter_z = new GameObject(582, 335, "src//recursos//sprite//password//z.png", 1, GameObjectType.OTHER);
		
		this.addSceneObjects(letter_a);
		this.addSceneObjects(letter_b);
		this.addSceneObjects(letter_c);
		this.addSceneObjects(letter_d);
		this.addSceneObjects(letter_e);
		this.addSceneObjects(letter_f);
		this.addSceneObjects(letter_g);
		this.addSceneObjects(letter_h);
		this.addSceneObjects(letter_i);
		this.addSceneObjects(letter_j);
		this.addSceneObjects(letter_k);
		this.addSceneObjects(letter_l);
		this.addSceneObjects(letter_m);
		this.addSceneObjects(letter_n);
		this.addSceneObjects(letter_o);
		this.addSceneObjects(letter_p);
		this.addSceneObjects(letter_q);
		this.addSceneObjects(letter_r);
		this.addSceneObjects(letter_s);
		this.addSceneObjects(letter_t);
		this.addSceneObjects(letter_u);
		this.addSceneObjects(letter_v);
		this.addSceneObjects(letter_w);
		this.addSceneObjects(letter_x);
		this.addSceneObjects(letter_y);
		this.addSceneObjects(letter_z);
		
	}
   
   private void moveSelector() {
		
		if(sceneKeyboard.keyDown(Keyboard.RIGHT_KEY) && selector.x < 582) {
			selector.x = selector.x + 36;
		}
		
		if(sceneKeyboard.keyDown(Keyboard.LEFT_KEY) && selector.x > 150) {
			selector.x = selector.x - 36;
		}
		
		if(sceneKeyboard.keyDown(Keyboard.DOWN_KEY) && selector.y < 304) {
			selector.y = selector.y + 36;
		}
		
		if(sceneKeyboard.keyDown(Keyboard.UP_KEY) && selector.y > 300) {
			selector.y = selector.y - 36;
		}
		
	}
   
   private void keyboardControll() {
		
		if(sceneKeyboard.keyDown(Keyboard.ENTER_KEY)) {
			this.selectLetter();
			if(this.flagComplete) {
				this.goPassword();
			}
		}
		
		if(sceneKeyboard.keyDown(Keyboard.ESCAPE_KEY)) {
			this.nextScenario = "StartMenu";
		}
	}
   
   private void goPassword() {
		
	 //Aqui colocar a senha recebida ao final de uma determinada fase que o leverá ao próximo estágio.
	 //Chamar a variável do ArrayList letter_password que contem a senha selecionada pelo usuário
	}
   
   private void selectLetter() {
		
		if(selector.x == 150 && selector.y == 300 ) {
			//System.out.println("a");
			this.addLetterPassword("a", "src//recursos//sprite//password//a.png");
			this.letter_password.add("a");
		}

		if(selector.x == 186 && selector.y == 300) {
			//System.out.println("b");
			this.addLetterPassword("b", "src//recursos//sprite//password//b.png");
			this.letter_password.add("b");
		}
		
		if(selector.x == 222 && selector.y == 300) {
			//System.out.println("c");
			this.addLetterPassword("c", "src//recursos//sprite//password//c.png");
			this.letter_password.add("c");
		}
		
		if(selector.x == 258 && selector.y == 300) {
			//System.out.println("d");
			this.addLetterPassword("d", "src//recursos//sprite//password//d.png");
			this.letter_password.add("d");
		}
		
		if(selector.x == 294 && selector.y == 300) {
			//System.out.println("e");
			this.addLetterPassword("e", "src//recursos//sprite//password//e.png");
			this.letter_password.add("e");
		}
		
		if(selector.x == 330 && selector.y == 300) {
			//System.out.println("f");	
			this.addLetterPassword("f", "src//recursos//sprite//password//f.png");
			this.letter_password.add("f");
		}
		
		if(selector.x == 366 && selector.y == 300) {
			//System.out.println("g");
			this.addLetterPassword("g", "src//recursos//sprite//password//g.png");
			this.letter_password.add("g");
		}
		
		if(selector.x == 402 && selector.y == 300) {
			//System.out.println("h");
			this.addLetterPassword("h", "src//recursos//sprite//password//h.png");
			this.letter_password.add("h");
			
		}
		
		if(selector.x == 438 && selector.y == 300) {
			//System.out.println("i");
			this.addLetterPassword("i", "src//recursos//sprite//password//i.png");
			this.letter_password.add("i");
		}
		
		if(selector.x == 474 && selector.y == 300) {
			//System.out.println("j");
			this.addLetterPassword("j", "src//recursos//sprite//password//j.png");
			this.letter_password.add("j");
		}
		
		if(selector.x == 510 && selector.y == 300) {
			//System.out.println("k");
			this.addLetterPassword("k", "src//recursos//sprite//password//k.png");
			this.letter_password.add("k");
		}
		
		if(selector.x == 546 && selector.y == 300) {
			//System.out.println("l");
			this.addLetterPassword("l", "src//recursos//sprite//password//l.png");
			this.letter_password.add("l");
		}
		
		if(selector.x == 582 && selector.y == 300) {
			//System.out.println("m");
			this.addLetterPassword("m", "src//recursos//sprite//password//m.png");
			this.letter_password.add("m");
		}
		
		if(selector.x == 150 && selector.y == 336) {
			//System.out.println("n");
			this.addLetterPassword("n", "src//recursos//sprite//password//n.png");
			this.letter_password.add("n");
		}
		
		if(selector.x == 186 && selector.y == 336) {
			//System.out.println("o");
			this.addLetterPassword("o", "src//recursos//sprite//password//o.png");
			this.letter_password.add("o");
		}
		
		if(selector.x == 222 && selector.y == 336) {
			//System.out.println("p");
			this.addLetterPassword("p", "src//recursos//sprite//password//p.png");
			this.letter_password.add("p");
		}
		
		if(selector.x == 258 && selector.y == 336) {
			//System.out.println("q");
			this.addLetterPassword("q", "src//recursos//sprite//password//q.png");
			this.letter_password.add("q");
		}
		
		if(selector.x == 294 && selector.y == 336) {
			//System.out.println("r");
			this.addLetterPassword("r", "src//recursos//sprite//password//r.png");
			this.letter_password.add("r");
		}
		
		if(selector.x == 330 && selector.y == 336) {
			//System.out.println("s");
			this.addLetterPassword("s", "src//recursos//sprite//password//s.png");
			this.letter_password.add("s");
		}
		
		if(selector.x == 366 && selector.y == 336) {
			//System.out.println("t");
			this.addLetterPassword("t", "src//recursos//sprite//password//t.png");
			this.letter_password.add("t");
		}
		
		if(selector.x == 402 && selector.y == 336) {
			//System.out.println("u");
			this.addLetterPassword("u", "src//recursos//sprite//password//u.png");
			this.letter_password.add("u");
		}
		
		if(selector.x == 438 && selector.y == 336) {
			//System.out.println("v");
			this.addLetterPassword("v", "src//recursos//sprite//password//v.png");
			this.letter_password.add("v");
		}
		
		
		if(selector.x == 474 && selector.y == 336) {
			//System.out.println("w");
			this.addLetterPassword("w", "src//recursos//sprite//password//w.png");
			this.letter_password.add("w");
		}
		
		if(selector.x == 510 && selector.y == 336) {
			//System.out.println("x");
			this.addLetterPassword("x", "src//recursos//sprite//password//x.png");
			this.letter_password.add("x");
		}
		
		if(selector.x == 546 && selector.y == 336) {
			//System.out.println("y");
			this.addLetterPassword("y", "src//recursos//sprite//password//y.png");
			this.letter_password.add("y");
		}
		
		if(selector.x == 582 && selector.y == 336) {
			//System.out.println("z");
			this.addLetterPassword("z", "src//recursos//sprite//password//z.png");
			this.letter_password.add("z");
		}
		
	}
	
	private void addLetterPassword(String sel_letter, String path) {
		if(password.length() < 6) {
			password = password + sel_letter;
			letter[letter_pos - 1] = null;
			letter[letter_pos - 1] = new GameObject(247 + (letter_pos * 36), 223, path, 1, GameObjectType.OTHER);
			letter_pos = letter_pos + 1;
			//System.out.println(password);
		} 
	}
	
	private void drawLettersPassword() {
		for(int i = 0; i < 6; i++) {
			letter[i].draw();
		}
	}
	
    public void printPassword(String password) {
    	
		window.drawText(password, 130, 230, Color.red, font);
	}

   
}
