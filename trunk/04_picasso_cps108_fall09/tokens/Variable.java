package tokens;

public class Variable extends EvaluatableToken {
    public static final String OPERATION = null;
    public static final int NUM_OF_OPERANDS = 0;
    private String myName;
    
    /**
     * Calls default constructor and sets myName to given value
     * 
     * @param name
     * @param value
     */
    public Variable(String name) {
        super(NUM_OF_OPERANDS, OPERATION, Integer.parseInt(myOOPResources.getString("Constant")));
        myName = name;
    }
    
    /**
     * Return value of thisvariable
     * 
     * @return
     */
    @Override
    public double[] evaluate() {
        double value = VariableHandler.getValue(myName);
        double[] ret = {value, value, value};
        return ret;
    }
}
