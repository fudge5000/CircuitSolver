/**
 * Input of the Source
 * @author Jacob Oakman
 * @version 2018.10.01
 */
public class SourceStart
{
    private Source source;

    /**
     * Generates the start of a source
     * @param source the source
     */
    public SourceStart(Source source)
    {
        this.source = source;
    }
    
    /**
     * Getter method for source
     * @return source
     */
    public Source getSource()
    {
        return this.source;
    }
}
