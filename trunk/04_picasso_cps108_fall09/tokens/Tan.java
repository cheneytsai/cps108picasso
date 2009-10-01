package tokens;

import java.util.List;

/**
 * Tan.java
 * 
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 * 
 */

public class Tan extends UnaryToken
{

    public static final String OPERATION = "tan";

    public Tan()
    {
        super(OPERATION);
    }

    @Override
    double[] UnaryEvaluate(List<EvaluatableToken> operands)
    {
        double[] op = operands.get(0).evaluate();
        double[] ret =
        { Math.tan(op[0]), Math.tan(op[1]), Math.tan(op[2]) };
        return ret;
    }

}
