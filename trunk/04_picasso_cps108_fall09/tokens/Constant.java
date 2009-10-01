package tokens;

/**
 * Constant.java
 * 
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu 
 * Represents constants. Holds a name and a value.
 */

public class Constant extends EvaluatableToken
{

    public static final String OPERATION = null;
    public static final int NUM_OF_OPERANDS = 0;
    private double[] myValue;

    /**
     * Calls superclass constructor then sets myValue and myName to default
     * values
     */
    public Constant()
    {
        super(NUM_OF_OPERANDS, OPERATION, Integer.parseInt(myOOPResources
                .getString("Constant")));
        myValue = new double[3];
    }

    /**
     * Calls default constructor then sets myValue to value passed as parameter
     * 
     * @param value
     */
    public Constant(double value)
    {
        this();
        for (int k = 0; k < myValue.length; k++)
        {
            myValue[k] = value;
        }
    }

    /**
     * Return value of thisvariable
     * 
     * @return
     */
    @Override
    public double[] evaluate()
    {
        return myValue;
    }

}
