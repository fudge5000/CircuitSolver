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
        circuit = new Circuit();
        
        ArrayList<ElectricComponent[]> netList = new ArrayList<ElectricComponent[]>();
    }

    /**
     * TestGenerateKVL
     */
    public void test()
    {
        assertEquals(1,2);
    }
}
