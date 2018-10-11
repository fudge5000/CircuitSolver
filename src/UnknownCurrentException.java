/**
 * Exception thrown when the getCurrent method cannot return a value
 * @author Jacob Oakman
 * @version 2018.10.11
 */
public class UnknownCurrentException extends Exception
{
    private static final long serialVersionUID = 3838501183161505761L;

    /**
     * Construct an UnknownCurrentException object
     */
    public UnknownCurrentException()
    {
        super();
    }
    
    /**
     * Construct an UnknownCurrentException object with a message
     * @param message the exception message
     */
    public UnknownCurrentException(String message)
    {
        super(message);
    }
}
