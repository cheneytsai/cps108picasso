package tokens;

import java.util.List;

/**
 * Sin.java
 * 
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 * 
 */

public class Sin extends UnaryToken
{

    public static final String OPERATION = "sin";

    public Sin()
    {
        super(OPERATION);
    }

    @Override
    double[] UnaryEvaluate(List<EvaluatableToken> operands)
    {
        double[] op = operands.get(0).evaluate();
        double[] ret =
        { Math.sin(op[0]), Math.sin(op[1]), Math.sin(op[2]) };
        return ret;
    }

}
