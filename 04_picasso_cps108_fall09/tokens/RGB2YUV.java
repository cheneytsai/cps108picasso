package tokens;

import java.util.List;


public class RGB2YUV extends UnaryToken {

    public static final String OPERATION = "rgb2yuv";

    public RGB2YUV() {
        super( OPERATION);
    }

    @Override    
    double[] UnaryEvaluate(List<EvaluatableToken> operands) {
        double[] op = operands.get(0).evaluate();
        double[] ret = {op[0] *  0.2989 + op[1] *  0.5866 + op[2] *  0.1145,
                op[0] * -0.1687 + op[1] * -0.3312 + op[2] *  0.5,
                op[0] *  0.5000 + op[1] * -0.4183 + op[2] * -0.0816};
     

      return ret;
    }

}
