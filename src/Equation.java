import java.util.ArrayList;

/**
 * Object to represent a additive equation
 * @author Jacob Oakman
 * @version 2018.10.22
 */
public class Equation
{
    private ArrayList<Double> equation;
    private double constant;

    /**
     * Create new equation object
     */
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
        Double newValue;
        if (this.get(index) != null)
        {
            newValue = new Double(this.get(index).doubleValue() + amount);
        }
        else
        {
            newValue = new Double(amount);
        }
        
        this.set(index, newValue);
    }
    
    /**
     * Get a coefficient value at index
     * @param index the index of the coefficient
     * @return the value at index
     */
    public Double get(int index)
    {
        if (index >= this.equation.size())
        {
            return new Double(0);
        }
        
        return equation.get(index);
    }
    
    /**
     * Set the value of a variable in the equation
     * @param index the index at which to set
     * @param element element to set
     */
    public Double set(int index, Double element)
    {
        if (this.equation.size() < index)
        {
            for (int i = this.equation.size(); i < index; i++)
            {
                this.equation.add(new Double(0));
            }
        }
        
        if (this.equation.size() == index)
        {
            this.equation.add(element);
            return null;
        }
        else
        {
            return this.equation.set(index, element);
        }
    }
    
    /**
     * Add another equation
     * @param other the other equation
     */
    public void addEq(Equation other)
    {
        for (int i = 0; i < this.equation.size(); i++)
        {
            if (other.get(i) != null)
            {
                this.set(i, new Double(this.get(i).doubleValue() + other.get(i).doubleValue()));
            }
        }
    }

    /**
     * Gets the constant value
     * @return constant
     */
    public double getConstant()
    {
        return this.constant;
    }
    
    /**
     * Sets the constant value
     * @param constant new constant
     */
    public void setConstant(double constant)
    {
        this.constant = constant;
    }
    
    /**
     * Adds to the constant value
     * @param constant new constant
     */
    public void addConstant(double constant)
    {
        this.constant += constant;
    }
    
    /**
     * Gets the equation as an array
     * @return 
     */
    public double[] getArray(int size)
    {
        double[] result = new double[size];
        
        for (int i = 0; i < size; i++)
        {
            if (this.get(i) != null)
            {
                result[i] = this.get(i).doubleValue();
            }
        }
        
        return result;
    }
    
    /**
     * get number of variables in equation
     * @return size
     */
    public int size()
    {
        return this.equation.size();
    }
    
    /**
     * Convert Equation to string
     */
    public String toString()
    {
        return this.equation.toString() + " = " + this.constant;
    }
}
