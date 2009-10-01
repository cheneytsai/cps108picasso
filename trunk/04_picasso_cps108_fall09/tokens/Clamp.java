package tokens;

import java.util.List;

import picasso.Coordinates;

/**
 * Clamp.java
 * Represents clamp function
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu 
 */

public class Clamp extends UnaryToken
{

    public static final String OPERATION = "clamp";

    public Clamp()
    {
        super(OPERATION);
    }

    @Override
    /**
     * Clamps the value of the operand to be within the min-max domain in Coordinates
     * @returns the result
     */
    double[] UnaryEvaluate(List<EvaluatableToken> operands)
    {
        double[] ret = ClampFunc(operands.get(0).evaluate());
        return ret;
    }

    double[] ClampFunc(double[] op)
    {
        double[] result = new double[3];
        for (int i = 0; i < op.length; i++)
        {
            if (op[i] > Coordinates.DOMAIN_MAX)
                result[i] = Coordinates.DOMAIN_MAX;
            else if (op[i] < Coordinates.DOMAIN_MIN)
                result[i] = Coordinates.DOMAIN_MIN;
            else
                result[i] = op[i];
        }
        return result;
    }
}
