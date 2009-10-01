package tokens;

/**
 * Variable.java
 * 
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 * 
 */
public class Variable extends EvaluatableToken
{
    public static final String OPERATION = null;
    public static final int NUM_OF_OPERANDS = 0;
    private String myName;

    /**
     * Calls default constructor and sets myName to given value
     * 
     * @param name
     * @param value
     */
    public Variable(String name)
    {
        super(NUM_OF_OPERANDS, OPERATION, Integer.parseInt(myOOPResources
                .getString("Constant")));
        myName = name;
    }

    public String getName()
    {
        return myName;
    }

    /**
     * Return value of thisvariable
     * 
     * @return
     */
    @Override
    public double[] evaluate()
    {
        return VariableHandler.getValue(myName);
    }
}
