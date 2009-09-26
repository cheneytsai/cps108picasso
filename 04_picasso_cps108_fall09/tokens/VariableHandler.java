package tokens;

import java.util.HashMap;
import java.util.Map;

public abstract class VariableHandler {
    private static Map<String, Double> myVariables = new HashMap<String, Double>();
    private static final double DEFAULT_VALUE = 0;
    
    public static final void setVariable(String name, double value) {
        myVariables.put(name, value);
    }
    
    public static double getValue(String name)
    {
        if (myVariables.containsKey(name))
            return myVariables.get(name);
        return DEFAULT_VALUE;
    }
}
