import java.util.ArrayList;

/**
 * Super node
 * @author Jacob Oakman
 * @version 2018.10.13
 */
public class SuperNode extends Node
{
    ArrayList<Node> nodeList;
    
    /**
     * Construct a SuperNode object
     * @param index the index
     */
    public SuperNode()
    {
        this.nodeList = new ArrayList<Node>();
    }
    
    public SuperNode(Node node)
    {
        this.nodeList = new ArrayList<Node>();
        this.nodeList.add(node);
    }

    public void addNode(Node node)
    {
        this.nodeList.add(node);
    }
    
    /**
     * Gets the equations associated with this supernode
     * @return a list of equations
     */
    public ArrayList<Equation> getEquationList()
    {
        ArrayList<Equation> result = new ArrayList<Equation>();
        result.add(new Equation());
        boolean found = false;
        Node currentNode;
        
        for (int i = 0; i < nodeList.size(); i++)
        {
            currentNode = nodeList.get(i);
            found = false;
            
            result.get(0).add(currentNode.generateNodeEquasion(nodeList));
            
            for (int j = 1; j < result.size(); j++)
            {
                if (result.get(j).get(this.nodeList.get(i).getIndex()) != 0)
                {
                    found = true;
                }
            }
            
            if (found)
            {
                result.add(currentNode.generateCompEq());
            }
        }
        
        return result;
    }
}
