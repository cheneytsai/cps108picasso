package tokens;

import java.util.List;

/**
 * Cos.java
 * Represents cosine function
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu 
 */

public class Cos extends UnaryToken
{

    public static final String OPERATION = "cos";

    public Cos()
    {
        super(OPERATION);
    }

    @Override
    /**
     * Performs the cosine operation on the operand
     * @returns the result
     */
    double[] UnaryEvaluate(List<EvaluatableToken> operands)
    {
        double[] op = operands.get(0).evaluate();
        double[] ret =
        { Math.cos(op[0]), Math.cos(op[1]), Math.cos(op[2]) };
        return ret;
    }

}
