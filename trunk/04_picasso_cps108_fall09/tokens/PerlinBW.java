package tokens;

import java.util.List;

import tokens.ImprovedNoise;

/**
 * PerlinBW.java
 * 
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 * 
 */
public class PerlinBW extends MultiArgToken
{

    public static final String OPERATION = "perlinBW";

    public PerlinBW()
    {
        super(OPERATION);
    }

    @Override
    double[] multiArgEvaluate(List<EvaluatableToken> operands)
    {
        double[] left = operands.get(1).evaluate();
        double[] right = operands.get(0).evaluate();
        double grey = ImprovedNoise.noise(left[0] + right[1], left[0]
                + right[1], left[2] + right[2]);
        double[] ret =
        { grey, grey, grey };

        return ret;
    }

}
