/**
 * Represents a resistor
 * @author Jacob Oakman
 * @version 2018.09.30
 */
public class Resistor extends ElectricComponent
{
    private double resistance;
    private ElectricComponent[] componentList;
    
    public Resistor(double resistance)
    {
        this.resistance = resistance;
    }
}
