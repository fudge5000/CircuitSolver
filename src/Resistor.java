/**
 * Represents a resistor
 * @author Jacob Oakman
 * @version 2018.09.30
 */
public class Resistor extends ElectricComponent
{
    private double resistance;
    private ElectricComponent[] componentList;
    
    /**
     * Construct a resistor
     * @param resistance the resistance in Ohms
     * @param componentList the components the resistor is connected to
     */
    public Resistor(double resistance, ElectricComponent[] componentList)
    {
        this.resistance = resistance;
        this.componentList = componentList;
    }
    
    /**
     * Uses Ohm's Law to calculate voltage given a current
     * @param current the current going through the resistor
     * @return the voltage drop over the resistor
     */
    public double getVoltageFromCurrent(double current)
    {
        return current * this.resistance;
    }
    
    /**
     * Uses Ohm's Law to calculate current given a voltage
     * @param voltage the voltage drop over the resistor
     * @return the current going through the resistor
     */
    public double getCurrentFromVoltage(double voltage)
    {
        return voltage / this.resistance;
    }
    
    /**
     * Calculates the power dissipated by the resistor
     * @param current the current going through the resistor
     * @return the power dissipated by the resistor
     */
    public double getPowerFromCurrent(double current)
    {
        return current * current * this.resistance;
    }
    
    /**
     * Calculates the power dissipated by the resistor
     * @param voltage the voltage drop over the resistor
     * @return the power dissipated by the resistor
     */
    public double getPowerFromVoltage(double voltage)
    {
        return voltage * voltage / this.resistance;
    }
}
