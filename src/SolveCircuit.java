public class SolveCircuit
{

    public static void main(String[] args)
    {
        Node[] nodeList = new Node[4];
        
        ElectricComponent[] nodeOneCompList = new ElectricComponent[4];
        
        nodeList[0] = new Node(1, nodeOneCompList);
        Circuit circuit = new Circuit(nodeList);
    }

}
