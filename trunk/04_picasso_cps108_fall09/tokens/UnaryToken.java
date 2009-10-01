package tokens;

import java.util.List;

/**
 * UnaryToken.java
 * 
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 * 
 */

public abstract class UnaryToken extends EvaluatableToken
{

    public static final int NUM_OF_OPERANDS = 1;

    public UnaryToken(String operation)
    {
        super(NUM_OF_OPERANDS, operation, Integer.parseInt(myOOPResources
                .getString("UnaryFunction")));
    }

    @Override
    public double[] evaluate()
    {
        checkNumOperands();
        List<EvaluatableToken> operands = getOperands();
        return UnaryEvaluate(operands);
    }

    abstract double[] UnaryEvaluate(List<EvaluatableToken> operands);

}
