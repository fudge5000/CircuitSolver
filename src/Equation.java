import java.util.ArrayList;

/**
 * Object to represent a additive equation
 * @author Jacob Oakman
 * @version 2018.10.22
 */
public class Equation
{
    private ArrayList<Double> equation;

    public Equation()
    {
        equation = new ArrayList<Double>();
    }

    /**
     * Add to a variable coefficient
     * @param index
     * @param amount
     */
    public void add(int index, double amount)
    {
        equation.set(index, equation.get(index).doubleValue() + amount);
    }
    
    /**
     * Add another equation
     * @param other the other equation
     */
    public void add(Equation other)
    {
        for (int i = 0; i < this.equation.size(); i++)
        {
            if (other.get(i) != null)
            {
                this.equation.set(i, new Double(this.get(i).doubleValue() + other.get(i).doubleValue()));
            }
        }
    }
    
    /**
     * Get a coefficient value at index
     * @param index the index of the coefficient
     * @return the value at index
     */
    public Double get(int index)
    {
        return this.equation.get(index);
    }

    /**
     * Gets value at 0
     * @return constant
     */
    public double getConstant()
    {
        return this.equation.get(0).doubleValue();
    }
}
