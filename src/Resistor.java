/**
 * Represents a resistor
 * @author Jacob Oakman
 * @version 2018.09.30
 */
public class Resistor extends ElectricComponent
{
    private double resistance;
    
    // positive voltage means the voltage is dropping from [0] to [1]
    private Double voltage;
    
    // positive current means the current is flowing from [0] to [1]
    private Double current;
    
    // Direction is arbitrarily assigned [0] --> [1]
    private Node[] nodeList = new Node[2];
    
    /**
     * Construct a resistor
     * @param resistance the resistance in Ohms
     */
    public Resistor(double resistance)
    {
        this.resistance = resistance;
    }
    
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
    
    public void addNode(Node node)
    {
        if (this.nodeList[0] == null)
        {
            this.nodeList[0] = node;
        }
        else if (this.nodeList[1] == null)
        {
            this.nodeList[1] = node;
        }
        else
        {
            throw new ArrayIndexOutOfBoundsException("Cannot add more than two nodes to a resistor");
        }
    }
    
    /**
     * gets the voltage
     * @return the voltage drop over the resistor
     * @throws UnknownVoltageException
     */
    public double getVoltage() throws UnknownVoltageException
    {
        if (this.voltage != null)
        {
            return this.voltage.doubleValue();
        }
        else if (this.current != null)
        {
            this.voltage = new Double(getVoltageFromCurrent(this.current.doubleValue()));
            return this.voltage.doubleValue();
        }
        
        throw new UnknownVoltageException();
    }
    
    /**
     * gets the current
     * @return the current through the resistor
     * @throws UnknownCurrentException
     */
    public double getCurrent() throws UnknownCurrentException
    {
        if (this.current != null)
        {
            return this.current.doubleValue();
        }
        else if (this.voltage != null)
        {
            this.current = new Double(getCurrentFromVoltage(this.voltage.doubleValue()));
            return this.current.doubleValue();
        }
        
        throw new UnknownCurrentException();
    }
    
    /**
     * Calculate power dissipated by the resistor
     * @return the power dissipated through the resistor
     * @throws UnknownCurrentException
     * @throws UnknownVoltageException
     */
    public double getPower() throws UnknownCurrentException, UnknownVoltageException
    {
        return this.getCurrent() * this.getVoltage();
    }
    
    /**
     * Uses Ohm's Law to calculate voltage given a current
     * @param current the current going through the resistor
     * @return the voltage drop over the resistor
     */
    private double getVoltageFromCurrent(double current)
    {
        return current * this.resistance;
    }
    
    /**
     * Uses Ohm's Law to calculate current given a voltage
     * @param voltage the voltage drop over the resistor
     * @return the current going through the resistor
     */
    private double getCurrentFromVoltage(double voltage)
    {
        return voltage / this.resistance;
    }
}
