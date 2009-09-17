package Expressions;

import arithmetica.*;

/**
 * @author Michael Represents addition operation
 */
public class Addition extends Token {

    public static final int ORDER_OF_OPERATION = 1;
    public static final String OPERATION = "+";
    public static final int NUM_OF_OPERANDS = 2;

    public Addition() {
        super(NUM_OF_OPERANDS, OPERATION, ORDER_OF_OPERATION);
    }

    @Override
    public int evaluate() {
        if (getOperands().size() != NUM_OF_OPERANDS)
            throw new ArithmeticaException(
                    "Incorrect number of operands to perform: " + OPERATION);
        return getOperands().get(0).evaluate()
                + getOperands().get(1).evaluate();
    }

}
