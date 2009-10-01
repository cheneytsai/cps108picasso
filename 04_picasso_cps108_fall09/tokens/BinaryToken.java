package tokens;

import java.util.List;

/**
 * BinaryToken.java
 * Abstract superclass for operations taking two opernads
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu Abstract Class for all Binary
 *         Operators
 */
public abstract class BinaryToken extends EvaluatableToken
{

    public static final int NUM_OF_OPERANDS = 2;

    public BinaryToken(String operation, int order)
    {
        super(NUM_OF_OPERANDS, operation, order);
    }

    @Override
    /**
     * Retrieves the results of evaluating the left and right, and passes it to binaryEvaluate
     */
    public double[] evaluate()
    {
        checkNumOperands();

        List<EvaluatableToken> operands = getOperands();

        double[] left = operands.get(1).evaluate();
        double[] right = operands.get(0).evaluate();
        return binaryEvaluate(left, right);
    }

    abstract double[] binaryEvaluate(double[] left, double[] right);
}
