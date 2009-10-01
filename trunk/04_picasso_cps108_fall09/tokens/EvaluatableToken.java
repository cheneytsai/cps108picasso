package tokens;
import java.util.List;

import java.util.ArrayList;

import picasso.PicassoException;
/**
 * EvaluatableToken.java
 * Abstract Token for Operators that perform a function
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 */
public abstract class EvaluatableToken extends Token{
    
    private List<EvaluatableToken> myOperands;
    private int myNumOperands;
    
    public EvaluatableToken(int numOperands, String operation, int order)
    {
        super(operation, order);
        myNumOperands = numOperands;
        myOperands = new ArrayList<EvaluatableToken>();
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
     * Return list of operands
     * 
     * @return myOperands
     */
    public List<EvaluatableToken> getOperands() {
        return myOperands;
    }
    
    /**
     * Adds an operand to myOperands
     * 
     * @param e
     *            the operand to be added
     */
    public void addOperand(EvaluatableToken e) {
        myOperands.add(e);
    }
    
    /**
     * Checks to make sure the number of operands matches the operands in the myOperands. Throws exception if it does not
     */
    public void checkNumOperands()
    {
        if (getOperands().size() != getNumOperands())
            throw new PicassoException(
                    "Incorrect number of operands to perform: " + getOperation());
    }

    /**
     * Returns name of operation
     * Only really used for debugging
     * @return
     */
    public abstract double[] evaluate();
}
