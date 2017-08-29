package hadaj;

public class GuessingException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // eclipse si toto pytal, po pravde velmi tomu nerozumiem
	public GuessingException(){
		super(); // vola na konstruktor nadtriedy, videl som na webe robit takto custom exception,celkom ma to zaujalo
	}
	public GuessingException(String sprava){
		super(sprava);
	}
}
