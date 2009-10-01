package tokens;

import java.util.ResourceBundle;

/**
 * Addition.java
 * Represents addition function
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu 
 */

public class Addition extends BinaryToken
{

    public static final String OPERATION = "+";
    private static ResourceBundle myResources = ResourceBundle
            .getBundle("resources.OrderOfOperations");

    public Addition()
    {
        super(OPERATION, Integer.parseInt(myResources.getString(OPERATION)));
    }

    @Override
    /**
     * Performs addition operation on the values of the two operands.
     */
    double[] binaryEvaluate(double[] left, double[] right)
    {
        double[] ret =
        { left[0] + right[0], left[1] + right[1], left[2] + right[2] };
        return ret;
    }

}
