import java.util.ArrayList;
import junit.framework.TestCase;

/**
 * Test the application
 * @author Jacob Oakman
 * @version 2018.10.26
 */
public class CircuitSolverTest extends TestCase
{
    public Circuit circuit;
    
    /**
     * Generate test object
     */
    public CircuitSolverTest()
    {
        // Do Nothing
    }
    
    /**
     * Set up the test class
     */
    public void setUp()
    {
        
        ArrayList<Net> netList = new ArrayList<Net>();
        
        netList.add(new Net(ComponentType.VOLTAGE_SOURCE, 12, 0, 1));
        netList.add(new Net(ComponentType.RESISTOR, 2, 0, 1));
        netList.add(new Net(ComponentType.RESISTOR, 5, 1, 2));
        netList.add(new Net(ComponentType.CURRENT_SOURCE, 1, 0, 2));

        circuit = new Circuit(netList);
    }

    /**
     * TestGenerateKVL
     */
    public void test()
    {
        Equation[] eqlist = circuit.getNodeKCLList();
        
        for (int i = 0; i < eqlist.length; i++)
        {
            System.out.println(eqlist[i]);
        }
        
        double[] nodeValues = circuit.solveEquations(eqlist);
        
        for (int i = 0; i < eqlist.length; i++)
        {
            System.out.print("Node " + i + " : " + nodeValues[i] + ", ");
        }
    }
}
