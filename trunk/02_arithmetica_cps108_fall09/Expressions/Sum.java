package Expressions;

import java.util.List;

import arithmetica.ArithmeticaException;

/**
 * Represents summation function
 * 
 * @author Michael
 * 
 */
public class Sum extends Token {

    public static final int NUM_OF_OPERANDS = 1;
    public static final String OPERATION = "sum";
    public static final int ORDER_OF_OPERATION = 5;

    public Sum() {
        super(NUM_OF_OPERANDS, OPERATION, ORDER_OF_OPERATION);
    }

    @Override
    public int evaluate() {
        List<Token> operands = getOperands();
        if (operands.size() != NUM_OF_OPERANDS) {
            throw new ArithmeticaException(
                    "Incorrect number of operands to perform: " + OPERATION);
        }

        Token operand = operands.get(0);
        if (!(operand instanceof Comma)) {
            return operand.evaluate();
        }

        List<Token> newOperands = ((Comma) operand).chainTokens();
        int sum = 0;
        for (int k = 0; k < newOperands.size(); k++) {
            sum += newOperands.get(k).evaluate();
        }
        return sum;
    }

}
