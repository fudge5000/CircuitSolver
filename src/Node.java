import java.util.ArrayList;

/**
 * Represents a junction between multiple components
 * @author Jacob Oakman
 * @version 2018.09.30
 */
public class Node
{
    private ArrayList<ElectricComponent> compList;
    private Double voltage;
    private int index;
    
    //--CONSTRUCTORS------------------------------------
    
    /**
     * Construct a node object without index
     */
    public Node()
    {
        // Do nothing
    }
    
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
    public Equation generateNodeEquasion()
    {
        return this.generateNodeEquasion(new ArrayList<Node>());
    }
    
    /**
     * Generates a part of the matrix to solve this circuit
     * @param ignoreList a list of nodes to ignore
     * @return a node equation with the coefficients for all node voltages
     */
    public Equation generateNodeEquasion(ArrayList<Node> ignoreList)
    {
        Equation equation = new Equation();
        Node other;
        ElectricComponent component;
        
        for (int i = 0; i < this.compList.size(); i++)
        {
            component = this.compList.get(i);
            other = component.nextNode(this);
            
            if (ignoreList.contains(other))
            {
                continue;
            }
            
            if (component instanceof Resistor)
            {                
                equation.add(this.getIndex(), 1/((Resistor)component).getResistance());
                equation.add(other.getIndex(), -1/((Resistor)component).getResistance());
            }
            else if (this.compList.get(i) instanceof Source)
            {
                if (((Source)component).getType() == SourceType.CURRENT)
                {
                    //Assume current going out of the node
                    equation.add(0, ((Source)component).getValue(this));
                }
                else if (((Source)component).getType() == SourceType.VOLTAGE)
                {
                    throw new IllegalStateException("Convert to supernode or try findVoltage");
                }
            }
        }
        
        return equation;
    }
    
    public Equation generateCompEq()
    {
        Equation equation = new Equation();
        Node other;
        ElectricComponent component;
        
        for (int i = 0; i < this.compList.size(); i++)
        {
            component = this.compList.get(i);
            other = component.nextNode(this);
            
            if (this.compList.get(i) instanceof Source && ((Source)component).getType() == SourceType.VOLTAGE)
            {
                equation.add(this.index, 1);
                equation.add(other.index, 1);
                equation.add(0, ((Source)component).getValue());
            }
        }
        
        return null;
    }
    
    /**
     * Finds the voltage of the node if linked to a known node via voltage
     * source
     * @return whether the voltage was found
     */
    public boolean findVoltage()
    {
        Node other;
        ElectricComponent component;
        
        for (int i = 0; i < this.compList.size(); i++)
        {
            component = this.compList.get(i);
            other = component.nextNode(this);
            
            if (this.compList.get(i) instanceof Source)
            {
                if (((Source)component).getType() == SourceType.VOLTAGE)
                {
                    if (other.isVoltageSet())
                    {
                        try
                        {
                            this.voltage = new Double(other.getVoltage() + ((Source)component).getValue(this));
                        }
                        catch (Exception e)
                        {
                            break;
                        }
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    /**
     * convert to super node
     * @return super node containing all unknown nodes linked to this
     */
    public SuperNode convertSuper()
    {
        //TODO implement method
        throw new UnsupportedOperationException("convertSuper not implemented yet");
    }
    
    /**
     * Checks if voltage has been set
     * @return whether the field voltage has been set
     */
    public boolean isVoltageSet()
    {
        return this.voltage != null;
    }
    
    /**
     * Adds an electric component to the node
     * @param comp
     */
    public void addComponent(ElectricComponent comp)
    {
        this.compList.add(comp);
    }
    
    /**
     * Checks if the Node needs to be converted to a supernode
     * @return
     */
    public boolean needSuperNode()
    {
        Node other;
        ElectricComponent component;
        
        for (int i = 0; i < this.compList.size(); i++)
        {
            component = this.compList.get(i);
            other = component.nextNode(this);
            
            if (this.compList.get(i) instanceof Source
                    && ((Source) component).getType() == SourceType.VOLTAGE)
            {
                return true;
            }
        }
        
        return false;
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
     * @throws UnknownValueException
     */
    public double getVoltage() throws UnknownValueException
    {
        if (this.voltage == null) throw new UnknownValueException();
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
