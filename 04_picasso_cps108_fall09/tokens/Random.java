package tokens;

import java.util.ResourceBundle;

/**
 * Random.java
 * 
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 * 
 */

public class Random extends EvaluatableToken
{

    public static final int NUM_OF_OPERANDS = 0;
    public static final String OPERATION = "random";
    private static ResourceBundle myResources = ResourceBundle
            .getBundle("resources.OrderOfOperations");

    public Random()
    {
        super(NUM_OF_OPERANDS, OPERATION, Integer.parseInt(myResources
                .getString("Function")));
    }

    @Override
    public double[] evaluate()
    {
        checkNumOperands();
        double[] ret =
        { (Math.random() * 2) - 1, (Math.random() * 2) - 1,
                (Math.random() * 2) - 1 };
        return ret;
    }

}
