/**
 * parent value class for voltage and current
 * @author Jacob Oakman
 * @version 2018.09.30
 */
public abstract class Value
{
    private double value;
    
    /**
     * Construct voltage object
     * @param value voltage
     */
    public Value(double value)
    {
        this.value = value;
    }

    /**
     * Getter method for the value field
     * @return the value
     */
    public double getValue()
    {
        return value;
    }
}
