/**
 * Represents one entry in a netlist
 * @author Jacob Oakman
 * @version 2018.10.26
 */
public class Net
{
    private ComponentType componentType;
    private double value;
    private int[] nodeList = new int[2];
    
    public Net(ComponentType componentType, double value, int startIndex, int endIndex)
    {
        this.componentType = componentType;
        this.value = value;
        this.nodeList[0] = startIndex;
        this.nodeList[1] = endIndex;
    }
    
    /**
     * Gets the componentType field
     * @return the componentType
     */
    public ComponentType getComponentType()
    {
        return this.componentType;
    }
    
    /**
     * getter for the value
     * @return value
     */
    public double getValue()
    {
        return this.value;
    }
    
    /**
     * gets the index of the node at a given index
     * @param index 1 or 2
     * @return the index of the node at the given index
     */
    public int getNodeIndexAt(int index)
    {
        if (index < 0 || index > 1)
        {
            throw new IllegalArgumentException();
        }
        
        return this.nodeList[index];
    }
}
