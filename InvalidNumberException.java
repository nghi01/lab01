
public class InvalidNumberException extends Exception{
    public InvalidNumberException() {
	super("Invalid Number. The hex MIPS should be 8-characters long and only contains hex value 0-9, a-f");
    }
    public InvalidNumberException(String message) {
	super(message);
    }
}
