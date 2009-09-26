package tokens;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

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
     * Returns name of operation
     * 
     * @return
     */
    public abstract double[] evaluate();
}
