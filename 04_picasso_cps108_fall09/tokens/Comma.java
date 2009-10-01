package tokens;

import java.util.*;

import picasso.PicassoException;

/**
 * Comma.java
 * 
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu Implements the Comma Variable
 */

public class Comma extends EvaluatableToken
{

    public static final String OPERATION = ",";
    public static final int NUM_OF_OPERANDS = 2;
    private static ResourceBundle myResources = ResourceBundle
            .getBundle("resources.OrderOfOperations");

    public Comma()
    {
        super(NUM_OF_OPERANDS, OPERATION, Integer.parseInt(myResources
                .getString(OPERATION)));

    }

    @Override
    public double[] evaluate()
    {
        return null; // never called
    }

    /**
     * Collects the operands near it returns as a list
     * 
     * @return a list of all operands in the block
     */
    public List<EvaluatableToken> chainTokens()
    {
        List<EvaluatableToken> operands = getOperands();
        if (operands.size() != NUM_OF_OPERANDS)
        {
            throw new PicassoException(
                    "Incorrect number of operands to perform: " + OPERATION);
        }

        List<EvaluatableToken> ret = new ArrayList<EvaluatableToken>();
        for (int k = 0; k < operands.size(); k++)
        {
            EvaluatableToken t = operands.get(k);
            if (t instanceof Comma)
            {
                ret.addAll(((Comma) t).chainTokens());
            }

            else
                ret.add(t);
        }
        return ret;
    }
}
