package tokens;

import java.util.List;


public class RGB2YUV extends MultiArgToken {

    public static final String OPERATION = "rgb2yuv";

    public RGB2YUV() {
        super( OPERATION);
    }

    @Override    
    double[] multiArgEvaluate(List<EvaluatableToken> operands) {
        double[] left = operands.get(1).evaluate();
        double[] right = operands.get(0).evaluate();
        double[] ret = {left[0] *  0.2989 + left[1] *  0.5866 + left[2] *  0.1145,
                left[0] * -0.1687 + left[1] * -0.3312 + left[2] *  0.5,
                left[0] *  0.5000 + left[1] * -0.4183 + left[2] * -0.0816};
     

      return ret;
    }

}
