import javafx.scene.control.TextField;


public class OneNumberTextField extends TextField {
	
	public OneNumberTextField(){
		super();
		
	}

	@Override
	public void replaceText(int start, int end, String number) {
		if (matches(number)) {
			super.replaceText(start, end, number);
		}
	}
	
	@Override
	public void replaceSelection(String number) {
		if (matches(number)) {
			super.replaceSelection(number);
		}
	}

	private boolean matches(String number) {
		return number.isEmpty() || (getText().length() < 1) && number.matches("[1-9]") ;
	}

}
