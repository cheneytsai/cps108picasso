package Expressions;

/**
 * Represents an open parantheses
 * 
 * @author Michael
 * 
 */
public class OpenGroup extends Token {

    public static final int ORDER_OF_OPERATION = -2;
    public static final String OPERATION = "(";
    public static final int NUM_OF_OPERANDS = 0;

    public OpenGroup() {
        super(NUM_OF_OPERANDS, OPERATION, ORDER_OF_OPERATION);
    }

    /**
     * Does nothing
     */
    @Override
    public int evaluate() {
        return 0;
    }

    @Override
    public boolean isOpenGroup() {
        return true;
    }

    @Override
    public boolean isGroupingToken() {
        return true;
    }

}
