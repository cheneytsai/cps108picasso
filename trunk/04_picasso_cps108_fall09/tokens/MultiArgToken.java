package tokens;

import java.util.List;

/**
 * MultiArgToken.java
 * 
 * Abstract for Multivariable Functions
 * 
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 * 
 */

public abstract class MultiArgToken extends EvaluatableToken
{

    public static final int NUM_OF_OPERANDS = 1;

    public MultiArgToken(String operation)
    {
        super(NUM_OF_OPERANDS, operation, Integer.parseInt(myOOPResources
                .getString("Function")));
    }

    @Override
    /*
     * Uses the ChainToken Method in Class Comma to tie together all arguments
     */
    public double[] evaluate()
    {
        checkNumOperands();
        List<EvaluatableToken> operands = getOperands();
        if (!(operands.get(0) instanceof Comma))
            return multiArgEvaluate(operands);
        return multiArgEvaluate(((Comma) operands.get(0)).chainTokens());
    }

    abstract double[] multiArgEvaluate(List<EvaluatableToken> operands);

}
