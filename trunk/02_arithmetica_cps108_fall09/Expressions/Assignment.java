package Expressions;

import arithmetica.ArithmeticaException;

/**
 * @author Michael Represents assignment operator
 */
public class Assignment extends Token {

    public static final int ORDER_OF_OPERATION = -3;
    public static final String OPERATION = "=";
    public static final int NUM_OF_OPERANDS = 2;

    public Assignment() {
        super(NUM_OF_OPERANDS, OPERATION, ORDER_OF_OPERATION);
    }

    /**
     * Evaluates expression to the right, assigning value to variable on the
     * left, and updating myVariables in TokenHandler
     */
    @Override
    public int evaluate() {
        if (getOperands().size() != NUM_OF_OPERANDS)
            throw new ArithmeticaException(
                    "Incorrect number of operands to perform: " + OPERATION);
        Constant variable = (Constant) getOperands().get(1);
        if (variable.getName() == null)
            throw new ArithmeticaException("Invalid assignment");
        int value = getOperands().get(0).evaluate();
        variable.setValue(value);
        TokenHandler.addVariable(variable.getName(), value);
        return value;
    }
}
