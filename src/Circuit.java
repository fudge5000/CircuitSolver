import Jama.*; 

/**
 * Represents an electric circuit
 * @author Jacob Oakman
 * @version 2018.10.01
 */
public class Circuit
{
    private Node[] nodeList;
    private Mesh[] meshList;
    
    /**
     * Create a Circuit object
     * @param nodeList list of populated nodes
     */
    public Circuit(Node[] nodeList)
    {
        this.nodeList = nodeList;
    }
    
    /**
     * Create a Circuit object
     * @param meshList list of meshes
     */
    public Circuit(Mesh[] meshList)
    {
        this.meshList = meshList;
    }
    
    /**
     * Create a Circuit object
     * @param nodeList list of populated nodes
     * @param meshList list of meshes
     */
    public Circuit(Node[] nodeList, Mesh[] meshList)
    {
        this.nodeList = nodeList;
        this.meshList = meshList;
    }
    
    /**
     * Converts to a mesh list object
     */
    public void convertToMeshList()
    {
        
    }
    
    /**
     * Gets the node voltages for each node
     * @return an array with voltages for each node
     */
    public double[] getMeshKVLList()
    {
        double[][] matrix = new double[meshList.length][meshList.length];
        
        for (int i = 0; i < meshList.length; i++)
        {
            matrix[i] = meshList[i].generateMeshEquasion(meshList.length);
        }
        
        double[] solution = this.solveEquasions(matrix);
        double[] result = new double[solution.length + 1];
        
        for (int i = 0; i < solution.length; i++)
        {
            result[i + 1] = solution[i];
        }
        
        return result;
    }
    
    /**
     * Gets the node voltages for each node
     * @return an array with voltages for each node
     */
    public double[] getNodeKCLList()
    {
        double[][] matrix = new double[nodeList.length][nodeList.length];
        
        for (int i = 0; i < nodeList.length; i++)
        {
            matrix[i] = nodeList[i].generateNodeEquasion(nodeList.length);
        }
        
        double[] solution = this.solveEquasions(matrix);
        double[] result = new double[solution.length + 1];
        
        for (int i = 0; i < solution.length; i++)
        {
            result[i + 1] = solution[i];
        }
        
        return result;
    }
    
    /**
     * Uses the arrays generated by the node equations
     * @param equasionList
     * @return array with voltages
     */
    public double[] solveEquasions(double[][] equasionList)
    {
        double[][] coeficients = new double[equasionList.length][equasionList.length - 1];
        double[][] constants = new double[equasionList.length][1];
                
        for (int y = 0; y < equasionList.length; y++)
        {
            for (int x = 1; x < equasionList[y].length; x++)
            {
                coeficients[y][x - 1] = equasionList[y][x];
            }
            constants[y][0] = equasionList[y][0];
        }
        
        Matrix coefMatrix = new Matrix(coeficients);
        Matrix conMatrix = new Matrix(constants);
        
        return coefMatrix.solve(conMatrix).getColumnPackedCopy();
    }
}