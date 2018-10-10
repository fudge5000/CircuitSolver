/**
 * Represents a junction between multiple components
 * @author Jacob Oakman
 * @version 2018.09.30
 */
public class Node extends ElectricComponent
{
    private ElectricComponent[] compList;
    private int index;
    
    /**
     * Construct a node object
     * @param index index of node
     * @param compList list of components connected to the node
     */
    public Node(int index, ElectricComponent[] compList)
    {
        this.index = index;
        this.compList = compList;
    }
    
    /**
     * Generates a part of the matrix to solve this circuit
     * @return a node equation with the coefficients for all node voltages
     */
    public double[] generateNodeEquasion(int nodeCount)
    {
        double[] equasion = new double[nodeCount];
        TraversalObject strider = new TraversalObject(this);
        Node other;
        
        for (int i = 0; i < this.compList.length; i++)
        {
            other = strider.nextNode(this.compList[i]);
            
            if (this.compList[i] instanceof Resistor)
            {
                equasion[this.getIndex()] += 1/strider.calcREQ();
                equasion[other.getIndex()] -= 1/strider.calcREQ();
            }
            else if (this.compList[i] instanceof Source)
            {
                //if is current source
                
                //if is voltage source
                
            }
        }
        
        return equasion;
    }
    
    /**
     * Getter method for index field
     * @return index field
     */
    public int getIndex()
    {
        return index;
    }
}
