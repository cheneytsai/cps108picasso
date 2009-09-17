package Expressions;

import arithmetica.ArithmeticaException;

/**
 * Represents subtraction operator
 * 
 * @author Michael
 */
public class Subtraction extends Token {

    public static final int ORDER_OF_OPERATION = 1;
    public static final String OPERATION = "-";
    public static final int NUM_OF_OPERANDS = 2;

    public Subtraction() {
        super(NUM_OF_OPERANDS, OPERATION, ORDER_OF_OPERATION);
    }

    @Override
    public int evaluate() {
        if (getOperands().size() != NUM_OF_OPERANDS)
            throw new ArithmeticaException(
                    "Incorrect number of operands to perform: " + OPERATION);
        return getOperands().get(1).evaluate()
                - getOperands().get(0).evaluate();
    }
}
