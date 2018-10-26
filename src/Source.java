/**
 * Represents and independent source
 * @author Jacob Oakman
 * @version 2018.09.30
 */
public class Source extends ElectricComponent
{
    private SourceType type = SourceType.VOLTAGE;
    private Double value;
    
    // nodeList stores two node objects
    // for voltage sources 0 (+ -) 1
    // for current sources 0 (-->) 1
    private Node[] nodeList = new Node[2];
    
    //--CONSTRUCTORS------------------------------------
    
    /**
     * Construct a source object
     * @param value the value either in volts or amps of the circuit
     * @param type the type of source either voltage or current
     */
    public Source(SourceType type, double value)
    {
        this.value = value;
        this.type = type;
    }
    
    //--GETTERS, SETTERS AND TOSTRING--------------------
    
    /**
     * Getter method for the value field
     * @return the value
     */
    public Double getValue()
    {
        return value;
    }
    
    /**
     * Returns negative or positive value based on direction
     * @param node the direction the request is coming from
     * @return positive or negative value
     * @throws IllegalArgumentException if the node isn't connected
     */
    public double getValue(Node node) throws IllegalArgumentException
    {
        if (this.nodeList[0].equals(node))
        {
            return value;
        }
        else if (this.nodeList[1].equals(node))
        {
            return -value;
        }

        throw new IllegalArgumentException(
                "This source isn't connected to " + node.toString());
    }
    
    /**
     * Getter method for the type field
     * @return the type
     */
    public SourceType getType()
    {
        return type;
    }
    
    public Node getNode(int index)
    {
        return this.nodeList[index];
    }
}
