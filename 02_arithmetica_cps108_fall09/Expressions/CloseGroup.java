package Expressions;

/**
 * @author Michael Represents close parantheses
 */
public class CloseGroup extends Token {

    public static final int NUM_OF_OPERANDS = 0;
    public static final String OPERATION = ")";
    public static final int ORDER_OF_OPERATION = -2;

    /**
     * Does nothing
     */

    public CloseGroup() {
        super(NUM_OF_OPERANDS, OPERATION, ORDER_OF_OPERATION);
    }

    /**
     * Should not be called
     */
    public int evaluate() {
        return 0;
    }

    @Override
    public boolean isCloseGroup() {
        return true;
    }

    @Override
    public boolean isGroupingToken() {
        return true;
    }

}
