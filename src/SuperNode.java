import java.util.ArrayList;

/**
 * Super node
 * @author Jacob Oakman
 * @version 2018.10.13
 */
public class SuperNode extends Node
{
    /**
     * Construct a SuperNode object
     * @param index the index
     */
    public SuperNode(int index)
    {
        super(index);
    }

    /**
     * Construct a SuperNode object
     * @param index the index
     * @param compList a list of connected components
     */
    public SuperNode(int index, ArrayList<ElectricComponent> compList)
    {
        super(index, compList);
    }

}
