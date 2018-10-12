import java.util.ArrayList;

/**
 * Represents a junction between multiple components
 * @author Jacob Oakman
 * @version 2018.09.30
 */
public class Node extends ElectricComponent
{
    private ArrayList<ElectricComponent> compList;
    private Double voltage;
    private int index;
    
    //--CONSTRUCTORS------------------------------------
    
    /**
     * Construct a node object
     * @param index index of node
     */
    public Node(int index)
    {
        this.index = index;
    }
    
    /**
     * Construct a node object
     * @param index index of node
     * @param compList list of components connected to the node
     */
    public Node(int index, ArrayList<ElectricComponent> compList)
    {
        this.index = index;
        this.compList = compList;
    }
    
    //--METHODS-----------------------------------------
    
    /**
     * Generates a part of the matrix to solve this circuit
     * @return a node equation with the coefficients for all node voltages
     */
    public double[] generateNodeEquasion(int nodeCount)
    {
        double[] equasion = new double[nodeCount];
        TraversalObject strider = new TraversalObject(this);
        Node other;
        ElectricComponent component;
        
        for (int i = 0; i < this.compList.size(); i++)
        {
            component = this.compList.get(i);
            other = strider.nextNode(this.compList.get(i));
            
            if (component instanceof Resistor)
            {
                component = (Resistor)component;
                
                equasion[this.getIndex()] += 1/strider.calcREQ();
                equasion[other.getIndex()] -= 1/strider.calcREQ();
            }
            else if (this.compList.get(i) instanceof Source)
            {
                component = (Source)component;
                if (((Source)component).getType() == SourceType.CURRENT)
                {
                    //Assume current going out of the node
                    equasion[0] += ((Source)component).getValue(this);
                }
                
                //if is voltage source
                //Check if other node is known
                //If not, convert to super-node
                
            }
        }
        
        return equasion;
    }
    
    /**
     * Checks if voltage has been set
     * @return whether the field voltage has been set
     */
    public boolean isVoltageSet()
    {
        return this.voltage != null;
    }
    
    //--GETTERS, SETTERS AND TOSTRING--------------------
    
    /**
     * Getter method for index field
     * @return index field
     */
    public int getIndex()
    {
        return index;
    }
    
    /**
     * Getter method for voltage
     * @return the constructed voltage set on the node
     * @throws UnknownVoltageException
     */
    public double getVoltage() throws UnknownVoltageException
    {
        if (this.voltage == null) throw new UnknownVoltageException();
        return this.voltage.doubleValue();
    }
    
    /**
     * Setter method for voltage
     * @param voltage the new node voltage
     */
    public void setVoltage(double voltage)
    {
        this.voltage = new Double(voltage);
    }
    
    /**
     * ToString method for Node
     */
    public String toString()
    {
        return "Node #" + this.index + ", Connected to " + this.compList.toString();
    }
}
