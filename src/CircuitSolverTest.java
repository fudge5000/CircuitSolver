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
        
        netList.add(new Net(ComponentType.VOLTAGE_SOURCE, 50, 1, 0));
        netList.add(new Net(ComponentType.RESISTOR, 80, 1, 2));
        netList.add(new Net(ComponentType.RESISTOR, 40, 2, 3));
        netList.add(new Net(ComponentType.RESISTOR, 800, 1, 3));
        netList.add(new Net(ComponentType.RESISTOR, 50, 2, 0));
        netList.add(new Net(ComponentType.CURRENT_SOURCE, 0.75, 0, 3));
        netList.add(new Net(ComponentType.RESISTOR, 200, 3, 0));

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
        
        circuit.solveNodeEquationSystem(eqlist);
        double[] voltageList = circuit.getNodeVoltageList();
        
        for (int i = 0; i < voltageList.length; i++)
        {
            System.out.println("Node #" + i + ": " + voltageList[i] + "V");
        }
    }
}
