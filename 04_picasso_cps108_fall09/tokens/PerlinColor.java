package tokens;

import java.util.List;
import tokens.ImprovedNoise;

/**
 * PerlinColor.java
 * 
 * Uses ImprovedNoise class to implement the Perlin Algorithm Function for Color
 * 
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 * 
 */
public class PerlinColor extends MultiArgToken
{

    public static final String OPERATION = "perlinColor";

    public PerlinColor()
    {
        super(OPERATION);
    }

    @Override
    double[] multiArgEvaluate(List<EvaluatableToken> operands)
    {
        double[] left = operands.get(1).evaluate();
        double[] right = operands.get(0).evaluate();
        double[] ret =
        { ImprovedNoise.noise(left[0] + 0.3, right[0] + 0.3, 0),
                ImprovedNoise.noise(left[1] - 0.8, right[1] - 0.8, 0),
                ImprovedNoise.noise(left[2] + 0.1, right[2] + 0.1, 0) };

        return ret;
    }

}
