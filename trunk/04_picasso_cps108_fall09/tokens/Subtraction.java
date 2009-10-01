package tokens;

import java.util.ResourceBundle;

/**
 * Subtraction.java
 * 
 * Implements the Subtraction Function under the "-" operator
 * 
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 * 
 */

public class Subtraction extends BinaryToken
{

    public static final String OPERATION = "-";
    private static ResourceBundle myResources = ResourceBundle
            .getBundle("resources.OrderOfOperations");

    public Subtraction()
    {

        // super(NUM_OF_OPERANDS, OPERATION, ORDER_OF_OPERATION);
        super(OPERATION, Integer.parseInt(myResources.getString(OPERATION)));
    }

    @Override
    double[] binaryEvaluate(double[] left, double[] right)
    {
        double[] ret =
        { left[0] - right[0], left[1] - right[1], left[2] - right[2] };
        return ret;
    }

}
