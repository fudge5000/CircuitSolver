/**
 * Represenets and independant source
 * @author Jacob Oakman
 * @version 2018.09.30
 */
public class Source extends ElectricComponent
{
    private double value;
    private String type;
    private SourceStart start;
    private SourceEnd end;
    private boolean zeroed = false;
    
    /**
     * Getter method for the value field
     * @return the value
     */
    public double getValue()
    {
        return value;
    }
    
    /**
     * Getter method for the type field
     * @return the type
     */
    public String getType()
    {
        return type;
    }
    
    /**
     * Getter method for the start field
     * @return the start
     */
    public SourceStart getStart()
    {
        return start;
    }
    
    /**
     * Getter method for the end field
     * @return the end
     */
    public SourceEnd getEnd()
    {
        return end;
    }
    
}
