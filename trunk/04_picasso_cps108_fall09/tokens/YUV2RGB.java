package tokens;

import java.util.List;

/**
 * YUV2RGB.java
 * 
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu Converts YUV to RGB
 *         Colorspace
 */

public class YUV2RGB extends UnaryToken
{

    public static final String OPERATION = "yuv2rgb";

    public YUV2RGB()
    {
        super(OPERATION);
    }

    @Override
    double[] UnaryEvaluate(List<EvaluatableToken> operands)
    {
        double[] op = operands.get(0).evaluate();
        double[] ret =
        { op[0] + op[2] * 1.4022, op[0] + op[1] * -0.3456 + op[2] * -0.7145,
                op[0] + op[1] * 1.7710 };

        return ret;
    }

}
