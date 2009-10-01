package tokens;

import java.util.List;

/**
 * Wrap.java
 * 
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 * 
 */

public class Wrap extends UnaryToken
{

    public static final String OPERATION = "wrap";

    public Wrap()
    {
        super(OPERATION);
    }

    @Override
    double[] UnaryEvaluate(List<EvaluatableToken> operands)
    {
        double[] ops = operands.get(0).evaluate();
        double[] ret =
        { WrapFunc(ops[0]), WrapFunc(ops[1]), WrapFunc(ops[2]) };
        return ret;
    }

    double WrapFunc(double op)
    {
        double result = 0;
        if (op > 1)
            result = op - 2;
        else if (op < -1)
            result = op + 2;
        else
            result = op;

        if (op > 1 || op < -1)
            return WrapFunc(result);
        else
            return result;
    }
}
