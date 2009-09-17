package Expressions;

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
    private List<Token> myOperands;
    private int myNumOperands;
    private String myOperation;
    private int myOrderOfOperation;

    /**
     * Create an empty expression
     */
    public Token(int numOperands, String operation, int order) {
        myNumOperands = numOperands;
        myOperation = operation;
        myOrderOfOperation = order;
        myOperands = new ArrayList<Token>();
    }

    /**
     * Adds an operand to myOperands
     * 
     * @param e
     *            the operand to be added
     */
    public void addOperand(Token e) {
        myOperands.add(e);
    }

    /**
     * Return list of operands
     * 
     * @return myOperands
     */
    public List<Token> getOperands() {
        return myOperands;
    }

    /**
     * true if is parantheses
     * 
     * @return
     */
    public boolean isGroupingToken() {
        return false;
    }

    /**
     * true if is open parantheses
     * 
     * @return
     */
    public boolean isOpenGroup() {
        return false;
    }

    /**
     * true if is close parantheses
     * 
     * @return
     */
    public boolean isCloseGroup() {
        return false;
    }

    /**
     * Returns number of operands an operation takes
     * 
     * @return
     */
    public int getNumOperands() {
        return myNumOperands;
    }

    /**
     * Returns the order of operation for the operation
     * 
     * @return
     */
    public int getOrderOfOperation() {
        return myOrderOfOperation;
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
     * Evaluates the operation
     * 
     * @return
     */
    public abstract int evaluate();
}
