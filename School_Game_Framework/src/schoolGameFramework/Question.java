package schoolGameFramework;

import java.util.ArrayList;

public class Question {

	private String statement; //Enunciado da questao
	private ArrayList<Alternative> alternatives = new ArrayList<Alternative>(); //Alternativas da questao
	
	public Question(String stat) {
		this.statement = stat;
	}
	
	public void setStatement(String stat) {
		statement = stat;
	}
	
	public void addAlternative(Alternative alt) {
		
		if(alternatives.size() <= 3) {
			alternatives.add(alt);
		} else {
			System.out.println("The maximum number of alternatives is 4");
		}
	
	}
	
	public String getStatement() {
		return this.statement;
	}
	
	public Alternative getAlternative(int id) {
		return alternatives.get(id);
	}
	
}
