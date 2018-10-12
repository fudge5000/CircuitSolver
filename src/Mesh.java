/**
 * Represents one mesh of a circuit
 * @author Jacob Oakman
 * @version 2018.10.01
 */
public class Mesh
{
    private MeshLink link;
    private int index;
    
    public Mesh(int index, MeshLink link)
    {
        this.index = index;
        this.link = link;
    }
    
    /**
     * Generates a part of the matrix to solve this circuit
     * @return a mesh equation with the coefficients for all mesh currents
     */
    public double[] generateMeshEquasion(int length)
    {
        return null;
    }
    
    /**
     * Checks if this mesh is the same as other
     * @param other an other mesh to compare with
     * @return whether they are the same
     */
    public boolean equals(Mesh other)
    {
        if (this == other)
        {
            return true;
        }

        MeshLink otherLink = other.getLink();
        MeshLink currentLink = this.findLink(otherLink);
        
        if (currentLink != null)
        {
            do
            {
                if (!currentLink.equals(otherLink))
                {
                    break;
                }
                
                currentLink = currentLink.getNext();
                otherLink = otherLink.getNext();
            }
            while (currentLink != link);
        }
        
        
        
        return true;
    }
    
    public MeshLink findLink(MeshLink target)
    {
        MeshLink currentLink = this.link;
        do
        {
            if (currentLink.equals(target))
            {
                return currentLink;
            }
            currentLink = currentLink.getNext();
        }
        while (!currentLink.equals(this.link));
        
        return null;
    }
    
    public void reverse()
    {
        MeshLink currentLink = this.link;
        while (currentLink.getPrev() != this.link)
        {
            currentLink.swap();
            currentLink = currentLink.getNext();
        }
    }
    
    public MeshLink getLink()
    {
        return this.link;
    }
}
