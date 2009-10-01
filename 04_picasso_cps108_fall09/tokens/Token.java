package tokens;

import java.util.ResourceBundle;

/**
 * Token.java An Expression represents a mathematical expression as a tree.
 * 
 * In this format, the internal nodes represent mathematical functions and the
 * leaves represent constant values.
 * 
 * @author former student solution
 * @author Robert C. Duvall (added comments, some code)
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 */
public abstract class Token
{

    private int myOrderOfOperation;
    private String myOperation;
    protected static final ResourceBundle myOOPResources = ResourceBundle
            .getBundle("resources.OrderOfOperations");

    /**
     * Create an empty expression
     */
    public Token(String operation, int order)
    {
        myOperation = operation;
        myOrderOfOperation = order;
    }

    /**
     * Returns name of operation
     * 
     * @return
     */
    public String getOperation()
    {
        return myOperation;
    }

    /**
     * Returns the order of operation for the operation
     * 
     * @return
     */
    public int getOrderOfOperation()
    {
        return myOrderOfOperation;
    }
}
