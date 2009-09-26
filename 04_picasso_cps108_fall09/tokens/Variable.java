package tokens;

public class Variable extends EvaluatableToken {
    public static final int ORDER_OF_OPERATION = 0;
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
        super(NUM_OF_OPERANDS, OPERATION, ORDER_OF_OPERATION);
        myName = name;
    }
    
    /**
     * Sets the name to the new name
     * 
     * @param name
     */
    public void setName(String name) {
        myName = name;
    }

    /**
     * Returns the name of this variable
     * 
     * @return
     */
    public String getName() {
        return myName;
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
