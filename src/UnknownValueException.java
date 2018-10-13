/**
 * Exception thrown when a method cannot return a value
 * @author Jacob Oakman
 * @version 2018.10.11
 */
public class UnknownValueException extends Exception
{
    private static final long serialVersionUID = -7396287099048239783L;

    /**
     * Construct an UnknownValueException object
     */
    public UnknownValueException()
    {
        super();
    }
    
    /**
     * Construct an UnknownValueException object with a message
     * @param message the exception message
     */
    public UnknownValueException(String message)
    {
        super(message);
    }
}