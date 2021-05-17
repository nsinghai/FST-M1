package activities;

@SuppressWarnings("serial")
public class CustomException extends Exception{
	private String message = null;
	
	public CustomException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}
