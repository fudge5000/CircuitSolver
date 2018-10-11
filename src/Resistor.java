/**
 * Represents a resistor
 * @author Jacob Oakman
 * @version 2018.09.30
 */
public class Resistor extends ElectricComponent
{
    private double resistance;
    private Node[] nodeList;
    
    /**
     * Construct a resistor
     * @param resistance the resistance in Ohms
     * @param componentList the components the resistor is connected to
     */
    public Resistor(double resistance, Node[] nodeList)
    {
        this.resistance = resistance;
        this.nodeList = nodeList;
    }
    
    /**
     * Get the next node when traversing the resistor
     * @param start the node you're coming from
     * @return the other node
     */
    public Node getNextNode(Node start)
    {
        if (start == nodeList[0])
            return nodeList[1];
        if (start == nodeList[1])
            return nodeList[0];
        throw new IllegalArgumentException();
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
