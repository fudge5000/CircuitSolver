/**
 * Abstract for any electric component
 * 
 * @author Jacob Oakman
 * @version 2018.09.30
 */
public abstract class ElectricComponent
{
    protected Node[] nodeList;
    
    /**
     * Sets the node at a current index
     */
    public void setNodeAt(int index, Node node)
    {
        this.nodeList[index] = node;
    }
    
    /**
     * Get the next node when traversing a component
     * @param start the node you're coming from
     * @return the other node
     */
    public Node nextNode(Node start)
    {
        if (start.equals(nodeList[0]))
        {
            return nodeList[1];
        }
        else if (start.equals(nodeList[1]))
        {
            return nodeList[0];
        }
        
        throw new IllegalArgumentException();
    }
}
