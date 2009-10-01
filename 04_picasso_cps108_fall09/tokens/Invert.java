package tokens;

import java.util.List;

/**
 * Invert.java
 * 
 * Implements the Invert Function under the "~" Operator
 * 
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 * 
 */

public class Invert extends UnaryToken
{

    public static final String OPERATION = "~";

    public Invert()
    {
        super(OPERATION);
    }

    @Override
    double[] UnaryEvaluate(List<EvaluatableToken> operands)
    {
        double[] op = operands.get(0).evaluate();
        double[] ret =
        { op[0] * -1, op[1] * -1, op[2] * -1 };
        return ret;
    }

}
