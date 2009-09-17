package Expressions;

import java.util.*;
import arithmetica.ArithmeticaException;

/**
 * Represents comma token
 * 
 * @author Michael
 * 
 */
public class Comma extends Token {
    public static final int ORDER_OF_OPERATION = -1;
    public static final String OPERATION = ",";
    public static final int NUM_OF_OPERANDS = 2;

    public Comma() {
        super(NUM_OF_OPERANDS, OPERATION, ORDER_OF_OPERATION);
    }

    @Override
    public int evaluate() {
        return 0; // never called
    }

    /**
     * Collects the operands near it returns as a list
     * 
     * @return a list of all operands in the block
     */
    public List<Token> chainTokens() {
        List<Token> operands = getOperands();
        if (operands.size() != NUM_OF_OPERANDS) {
            throw new ArithmeticaException(
                    "Incorrect number of operands to perform: " + OPERATION);
        }

        List<Token> ret = new ArrayList<Token>();
        for (int k = 0; k < operands.size(); k++) {
            Token t = operands.get(k);
            if (t instanceof Comma) {
                ret.addAll(((Comma) t).chainTokens());
            }

            else
                ret.add(t);
        }
        return ret;
    }
}
