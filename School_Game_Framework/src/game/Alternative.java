package game;

public class Alternative {

	private int number = 0;
	private String alternative;
	private boolean validate;
	
	public Alternative(int number_of_alternative, String alternative_text, boolean validation_of_alternative) {
		
		this.number = number_of_alternative;
		this.alternative = alternative_text;
		this.validate = validation_of_alternative;
		
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getAlternative() {
		return alternative;
	}
	
	public boolean getValidate() {
		return validate;
	}
	
	
}
