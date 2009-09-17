package Expressions;

import arithmetica.ArithmeticaException;

/**
 * Represents absolute value operation
 * 
 * @author Michael
 */
public class AbsoluteValue extends Token {

    public static final int ORDER_OF_OPERATION = 4;
    public static final String OPERATION = "abs";
    public static final int NUM_OF_OPERANDS = 1;

    public AbsoluteValue() {
        super(NUM_OF_OPERANDS, OPERATION, ORDER_OF_OPERATION);
    }

    @Override
    public int evaluate() {
        if (getOperands().size() != NUM_OF_OPERANDS)
            throw new ArithmeticaException(
                    "Incorrect number of operands to perform: " + OPERATION);
        return Math.abs(getOperands().get(0).evaluate());
    }

}
