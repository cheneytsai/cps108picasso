package tokens;

import java.util.List;


public class YUV2RGB extends MultiArgToken {

    public static final String OPERATION = "yuv2rgb";

    public YUV2RGB() {
        super( OPERATION);
    }

    @Override    
    double[] multiArgEvaluate(List<EvaluatableToken> operands) {
        double[] left = operands.get(1).evaluate();
        double[] right = operands.get(0).evaluate();
        double[] ret = {left[0] + left[2] *  1.4022,
                left[0] + left[1] * -0.3456 + left[2] * -0.7145,
                left[0] + left[1] *  1.7710};
    
      return ret;
    }

}
