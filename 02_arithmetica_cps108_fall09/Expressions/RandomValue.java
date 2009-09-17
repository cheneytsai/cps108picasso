package Expressions;

import arithmetica.ArithmeticaException;

/**
 * Represents random value operation (produces a random number)
 * 
 * @author Michael
 * 
 */
public class RandomValue extends Token {

    public static final int ORDER_OF_OPERATION = 4;
    public static final String OPERATION = "rand";
    public static final int NUM_OF_OPERANDS = 1;

    public RandomValue() {
        super(NUM_OF_OPERANDS, OPERATION, ORDER_OF_OPERATION);
    }

    @Override
    public int evaluate() {
        if (getOperands().size() != NUM_OF_OPERANDS)
            throw new ArithmeticaException(
                    "Incorrect number of operands to perform: " + OPERATION);
        return (int) (Math.random() * getOperands().get(0).evaluate());
    }

}
