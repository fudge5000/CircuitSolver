import java.util.LinkedList;

public class MeshLink extends LinkedList<MeshLink>
{
    private static final long serialVersionUID = 3843098317776412293L;
    private ElectricComponent link;
    private MeshLink next;
    private MeshLink prev;
    
    public MeshLink getNext()
    {
        return this.next;
    }
    
    public void setNext(MeshLink next)
    {
        this.next = next;
    }
    
    public MeshLink getPrev()
    {
        return this.prev;
    }
    
    public void setPrev(MeshLink prev)
    {
        this.prev = prev;
    }
    
    public ElectricComponent getLink()
    {
        return this.link;
    }
    
    public void swap()
    {
        MeshLink temp = this.next;
        this.next = this.prev;
        this.prev = temp;
    }
}
