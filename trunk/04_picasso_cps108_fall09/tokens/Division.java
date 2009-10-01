package tokens;

import java.util.ResourceBundle;

/**
 * Division.java
 * Represents division operation
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu Implements the Division
 *         Function under the / operator
 */

public class Division extends BinaryToken
{

    public static final String OPERATION = "/";
    private static ResourceBundle myResources = ResourceBundle
            .getBundle("resources.OrderOfOperations");

    public Division()
    {
        super(OPERATION, Integer.parseInt(myResources.getString(OPERATION)));
    }

    @Override
    /**
     * Performs division on its two operands
     * @returns the result
     */
    public double[] binaryEvaluate(double[] left, double[] right)
    {
        double[] ret =
        { left[0] / right[0], left[1] / right[1], left[2] / right[2] };
        return ret;
    }

}
