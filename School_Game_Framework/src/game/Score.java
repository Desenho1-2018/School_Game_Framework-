package game;

import java.util.ArrayList;

public class Score {

	private ArrayList<String> scoreType = new ArrayList<String>();
	
	public void addScoreType(String type) {
		if(scoreType.size() <= 2) {
			scoreType.add(type);
		} else {
			System.out.println("The number maximum of the types of score is 3");
		}
	}
	
	public String getScoreType(int id) {
		return scoreType.get(id);
	}

}
