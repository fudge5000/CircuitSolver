/**
 * Represents a dependant source
 * @author Jacob Oakman
 * @version 2018.09.30
 */
public class DependantSource extends ElectricComponent
{
    private Resistor target;
    private double multiplier;
    
    public double getValue()
    {
        return this.multiplier * Math.abs(0);
    }
}
