package tokens;

import java.util.List;

import picasso.PicassoException;
/**
 * Color.java
 * Implements the Function to create a color under the syntax of [ cons, cons, cons ]
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu 
 */
public class Color extends MultiArgToken {

    public static final String OPERATION = "[";
    public static final int NUM_OF_OPERAND = 3;
    
    public Color() {
        super(OPERATION);
    }

    @Override
    /**
     * Uses the evaluated values of its three operands to generate RGB values
     * @return the result
     */
    double[] multiArgEvaluate(List<EvaluatableToken> operands) {
        if (operands.size() != 3 )
        {
            throw new PicassoException("Ill-formatted exception");
        }
        double[] ret = {operands.get(2).evaluate()[0], operands.get(1).evaluate()[1], operands.get(0).evaluate()[2]};       
        return ret;
    }

}
