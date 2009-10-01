package tokens;

import picasso.PicassoException;

/**
 * Assignment.java
 * Represents the assignment operation
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu Handles the Assignment
 *         Function under the "=" symbol
 */
public class Assignment extends EvaluatableToken
{

    public static final String OPERATION = "=";
    public static final int NUM_OF_OPERANDS = 2;

    public Assignment()
    {
        super(NUM_OF_OPERANDS, OPERATION, Integer.parseInt(myOOPResources
                .getString(OPERATION)));
    }

    @Override
    /**
     * Evaluates the right operand, assigning its value to the variable on the left in VariableHandler
     * @return the value on the left
     */
    public double[] evaluate()
    {
        if (getOperands().size() != NUM_OF_OPERANDS)
            throw new PicassoException(
                    "Incorrect number of operands to perform: " + OPERATION);
        if (!(getOperands().get(1) instanceof Variable))
        {
            throw new PicassoException("Invalid Assignment");
        }
        Variable var = (Variable) getOperands().get(1);
        EvaluatableToken value = getOperands().get(0);
        VariableHandler.setVariable(var.getName(), value);
        return value.evaluate();
    }

}
