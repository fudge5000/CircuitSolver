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
    // FROM PARENT: protected Node[] nodeList = new Node[2];
    
    //--CONSTRUCTORS------------------------------------
    
    /**
     * Construct a resistor
     * @param resistance the resistance in Ohms
     */
    public Resistor(double resistance)
    {
        this.resistance = resistance;
        this.nodeList = new Node[2];
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
    
    //--METHODS-----------------------------------------
    
    /**
     * Add a node to the resistor
     * @param node a node to add
     */
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
     * Check if current has been set
     * @return whether current has been set
     */
    public boolean isCurrentSet()
    {
        return this.current != null;
    }
    
    /**
     * Check if voltage has been set
     * @return whether voltage has been set
     */
    public boolean isVoltageSet()
    {
        return this.voltage != null;
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
    
    //--GETTERS, SETTERS AND TOSTRING--------------------
    
    /**
     * gets the voltage
     * @return the voltage drop over the resistor
     * @throws UnknownValueException
     */
    public double getVoltage() throws UnknownValueException
    {
        if (this.voltage != null)
        {
            return this.voltage.doubleValue();
        }
        
        throw new UnknownValueException();
    }
    
    /**
     * gets the current
     * @return the current through the resistor
     * @throws UnknownValueException
     */
    public double getCurrent() throws UnknownValueException
    {
        if (this.current != null)
        {
            return this.current.doubleValue();
        }
        
        throw new UnknownValueException();
    }
    
    /**
     * Sets the voltage and current using an input voltage
     * @param voltage the voltage drop over the resistor
     */
    public void setVoltage(double voltage)
    {
        this.voltage = new Double(voltage);
        this.current = new Double(getCurrentFromVoltage(this.voltage.doubleValue()));
    }
    
    /**
     * Sets the voltage and current using an input current
     * @param current the current through the resistor
     */
    public void setCurrent(double current)
    {
        this.current = new Double(current);
        this.voltage = new Double(getVoltageFromCurrent(this.current.doubleValue()));
    }
    
    /**
     * Calculate power dissipated by the resistor
     * @return the power dissipated through the resistor
     * @throws UnknownValueException
     */
    public double getPower() throws UnknownValueException 
    {
        return this.getCurrent() * this.getVoltage();
    }
    
    /**
     * Getter for the resistance field
     * @return resistance
     */
    public double getResistance()
    {
        return this.resistance;
    }
}
