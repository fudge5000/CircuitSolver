/**
 * Stores a complex number for use in future phaser stuff
 * @author Jacob Oakman
 * @version 2018.10.26
 */
public class ComplexValue
{
    private double realValue;
    private double complexValue;
    
    /**
     * instantiates via a string in the form "a + jb"
     * @param complex
     */
    public ComplexValue(String complex)
    {
        String[] split = complex.split(" + j");
        
        this.realValue = Double.parseDouble(split[0]);
        this.complexValue = Double.parseDouble(split[1]);
    }
    
    public ComplexValue(double realValue)
    {
        this.realValue = realValue;
        this.complexValue = 0;
    }
    
    public ComplexValue(double realValue, double complexValue)
    {
        this.realValue = realValue;
        this.complexValue = 0;
    }
}
