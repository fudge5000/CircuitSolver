import Jama.*;
import java.util.ArrayList;

/**
 * Represents an electric circuit
 * @author Jacob Oakman
 * @version 2018.10.01
 */
public class Circuit
{
    private ArrayList<Node> nodeList;
    private ArrayList<Net> netList;
    
    /**
     * Create a Circuit object
     * @param netlist list of electric components as nets
     */
    public Circuit(ArrayList<Net> netList)
    {
        this.netList = netList;
        
        nodeList = new ArrayList<Node>();
        
        this.generateNodeList();
        this.assignGroundNode();
        this.findKnownVoltages();
    }
    
    public void generateNodeList()
    {
        Net curNet;
        ElectricComponent component;
        int nodeIndex;
        int maxNodeIndex = 0;
        
        for (int i = 0; i < this.netList.size(); i++)
        {
            if (maxNodeIndex < this.netList.get(i).getNodeIndexAt(0))
            {
                maxNodeIndex = this.netList.get(i).getNodeIndexAt(0);
            }
            
            if (maxNodeIndex < this.netList.get(i).getNodeIndexAt(1))
            {
                maxNodeIndex = this.netList.get(i).getNodeIndexAt(1);
            }
        }
        
        for (int i = 0; i <= maxNodeIndex; i++)
        {
            this.nodeList.add(new Node(i));
        }
        
        for (int i = 0; i < this.netList.size(); i++)
        {
            curNet = this.netList.get(i);
            
            switch (curNet.getComponentType())
            {
                case VOLTAGE_SOURCE: 
                {
                    component = new Source(SourceType.VOLTAGE, curNet.getValue());
                    break;
                }
                
                case CURRENT_SOURCE: 
                {
                    component = new Source(SourceType.CURRENT, curNet.getValue());
                    break;
                }
                
                case RESISTOR: 
                {
                    component = new Resistor(curNet.getValue());
                }
                
                default : {
                    component = new Resistor(curNet.getValue());
                }
            }
            
            for (int j = 0; j < 2; j++)
            {
                nodeIndex = curNet.getNodeIndexAt(j);
                
                nodeList.get(nodeIndex).addComponent(component);
                component.setNodeAt(j, nodeList.get(nodeIndex));
            }
        }
    }
    
    /**
     * Assigns a node to ground
     * @return the ground
     */
    public Node assignGroundNode()
    {
        Node ground = null;
        int numSources = 0;
        int curNumSources = 0;
        
        for (int i = 0; i < this.nodeList.size(); i++)
        {
            curNumSources = this.nodeList.get(i).getNumSources(SourceType.VOLTAGE);
            if (ground == null || numSources <= curNumSources)
            {
                ground = this.nodeList.get(i);
                numSources = curNumSources;
            }
        }
        
        if (ground != null)
        {
            ground.setVoltage(0);
            
            return ground;
        }
        
        throw new IllegalStateException("You done goofed");
    }
    
    /**
     * Finds the known node voltages
     */
    public void findKnownVoltages()
    {
        boolean found = false;
        
        do
        {
            found = false;
            for (int i = 0; i < this.nodeList.size(); i++)
            {
                if (!this.nodeList.get(i).isVoltageSet()
                        && this.nodeList.get(i).findVoltage())
                {
                    found = true;
                }
            }
        }
        while (found);
    }
    
    /**
     * Solves the circuit using nodes
     */
    public void solveNode()
    {
        Equation[] matrix;
        
        matrix = this.getNodeKCLList();
        
        double[] nodeVoltageList = this.solveEquations(matrix);
        
        for (int i = 0; i < nodeVoltageList.length; i++)
        {
            this.getNode(i+1).setVoltage(nodeVoltageList[i]);
        }
    }
    
    /**
     * Gets the node voltages for each node
     * @return an array with voltages for each node
     */
    public Equation[] getNodeKCLList()
    {
        ArrayList<Equation> matrix = new ArrayList<Equation>();
        
        for (int i = 0; i < nodeList.size(); i++)
        {
            if (!nodeList.get(i).isVoltageSet())
            {
                matrix.add(nodeList.get(i).generateNodeEquation());
            }
        }
        
        return matrix.toArray(new Equation[0]);
    }
    
    /**
     * Add a node to the circuit
     * @param node node to add
     * @return whether the node was added
     */
    public boolean addNode(Node node)
    {
        return this.nodeList.add(node);
    }
    
    /**
     * add node to the circuit at index
     * @param index
     * @param node
     */
    public void addNode(int index, Node node)
    {
        this.nodeList.add(index, node);
    }
    
    /**
     * Get node at position
     * @param index the index to get the node from
     * @return the node at index
     */
    public Node getNode(int index)
    {
        return this.nodeList.get(index);
    }
    
    /**
     * Uses the arrays generated by the node equations
     * @param equasionList
     * @return array with voltages
     */
    public double[] solveEquations(Equation[] equationList)
    {
        double[][] coeficients = new double[equationList.length][equationList.length - 1];
        double[][] constants = new double[equationList.length][1];
        ArrayList<Integer> varMap = new ArrayList<Integer>();
                
        for (int y = 0; y < equationList.length; y++)
        {
            coeficients[y] = equationList[y].getArray(equationList.length);
            constants[y][0] = equationList[y].getConstant();
        }
        
        ArrayList<ArrayList<Double>> cleanedCoefList = new ArrayList<ArrayList<Double>>();
        boolean hasValue;
        for (int i = 0; i < coeficients[0].length; i++)
        {
            
            for (int j = 0; j < coeficients.length; i++)
            {
                
            }
        }
        
        //cleanup coefs
        //cleanup constants
        
        Matrix coefMatrix = new Matrix(coeficients);
        Matrix conMatrix = new Matrix(constants);
        
        return coefMatrix.solve(conMatrix).getColumnPackedCopy();
    }
    
    
}
