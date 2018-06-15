package game;

public class Alternative {

	private int number = 0;
	private String alternative;
	private boolean validate;
	
	public Alternative(int numb, String alt, boolean val) {
		
		this.number = numb;
		this.alternative = alt;
		this.validate = val;
		
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
