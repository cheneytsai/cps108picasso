package tokens;

/**
 * ImageHandler.java
 * 
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 * 
 */

public class Multiplication extends BinaryToken
{

    public static final String OPERATION = "*";

    public Multiplication()
    {

        // super(NUM_OF_OPERANDS, OPERATION, ORDER_OF_OPERATION);
        super(OPERATION, Integer.parseInt(myOOPResources.getString(OPERATION)));
    }

    @Override
    double[] binaryEvaluate(double[] left, double[] right)
    {
        double[] ret =
        { left[0] * right[0], left[1] * right[1], left[2] * right[2] };
        return ret;
    }

}
