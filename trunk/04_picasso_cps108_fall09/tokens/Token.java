package tokens;


import java.awt.Dimension;
import java.util.*;

/**
 * An Expression represents a mathematical expression as a tree.
 * 
 * In this format, the internal nodes represent mathematical functions and the
 * leaves represent constant values.
 * 
 * @author former student solution
 * @author Robert C. Duvall (added comments, some code)
 * @author Michael Yu
 */
public abstract class Token {
    
    private int myOrderOfOperation;
    private String myOperation;
    /**
     * Create an empty expression
     */
    public Token(String operation, int order) {
        myOperation = operation;
        myOrderOfOperation = order;
    }

    /**
     * Returns name of operation
     * 
     * @return
     */
    public String getOperation() {
        return myOperation;
    }
    
    /**
     * Returns the order of operation for the operation
     * 
     * @return
     */
    public int getOrderOfOperation() {
        return myOrderOfOperation;
    }
}
