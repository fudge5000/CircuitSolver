
public class TraversalObject
{
    private ElectricComponent start;
    private ElectricComponent currentComponent;
    
    public TraversalObject(ElectricComponent start)
    {
        this.start = start;
    }
    
    public Node nextNode(ElectricComponent comp)
    {
//        if (comp instanceof Node)
//        {
//            return comp;
//        }
//        else
//        {
//            return this.findNode();
//        }
        return null;
    }
    
    public boolean isHome()
    {
        return this.start == this.currentComponent; 
    }
    
    public double calcREQ()
    {
        return 0;
    }
}
