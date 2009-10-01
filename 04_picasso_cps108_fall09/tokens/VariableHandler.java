package tokens;

import java.util.HashMap;
import java.util.Map;

/**
 * VariableHandler.java
 * 
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 * 
 */
public abstract class VariableHandler
{
    private static Map<String, EvaluatableToken> myVariables = new HashMap<String, EvaluatableToken>();
    private static final double[] DEFAULT_VALUE =
    { 0, 0, 0 };

    public static final void setVariable(String name, EvaluatableToken value)
    {
        myVariables.put(name, value);
    }

    public static final void setVariable(String name, double value)
    {
        setVariable(name, new Constant(value));
    }

    public static double[] getValue(String name)
    {
        if (myVariables.containsKey(name))
            return myVariables.get(name).evaluate();
        return DEFAULT_VALUE;
    }

    public static void clearVariables()
    {
        myVariables.clear();
    }
}
