/**
 * Exception thrown when the getVoltage method cannot return a value
 * @author Jacob Oakman
 * @version 2018.10.11
 */
public class UnknownVoltageException extends Exception
{
    private static final long serialVersionUID = 4076117749687301945L;

    /**
     * Construct an UnknownVoltageException object
     */
    public UnknownVoltageException()
    {
        super();
    }
    
    /**
     * Construct an UnknownVoltageException object with a message
     * @param message the exception message
     */
    public UnknownVoltageException(String message)
    {
        super(message);
    }
}
