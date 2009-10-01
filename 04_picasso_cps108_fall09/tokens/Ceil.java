package tokens;

import java.util.List;

/**
 * Ceil.java
 * Represents ceiling function
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu Implements the Ceiling
 *         Rounding Function
 */
public class Ceil extends UnaryToken
{

    public static final String OPERATION = "ceil";

    public Ceil()
    {
        super(OPERATION);
    }

    @Override
    /**
     * Performs ceiling operation on the operand.
     * @return the value of the operation
     */
    double[] UnaryEvaluate(List<EvaluatableToken> operands)
    {
        double[] op = operands.get(0).evaluate();
        double[] ret =
        { Math.ceil(op[0]), Math.ceil(op[1]), Math.ceil(op[2]) };
        return ret;
    }

}
