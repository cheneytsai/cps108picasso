package tokens;

import java.util.List;


public class TanH extends UnaryToken {

    public static final String OPERATION = "tanh";

    public TanH() {
        super( OPERATION);
    }

    @Override    
    double[] UnaryEvaluate(List<EvaluatableToken> operands) {
        double[] op = operands.get(0).evaluate();
        double[] ret = {Math.tanh(op[0]), Math.tanh(op[1]), Math.tanh(op[2])};
      return ret;
    }

}
