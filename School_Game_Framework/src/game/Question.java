package game;

import java.util.ArrayList;

public class Question {

	private String statement; //Enunciado da questao
	private ArrayList<Alternative> alternatives; //Alternativas da questao
	
	public void setStatement(String stat) {
		statement = stat;
	}
	
	public void addAlternative(Alternative alt) {
		
		if(alternatives.size() <= 4) {
			alternatives.add(alt);
		} else {
			System.out.println("The maximum number of alternatives is 3");
		}
	
	}
	
	public String getStatement() {
		return this.statement;
	}
	
	public Alternative getAlternative(int id) {
		return alternatives.get(id);
	}
	
}
