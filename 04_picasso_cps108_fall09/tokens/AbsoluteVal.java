package tokens;

import java.util.List;


public class AbsoluteVal extends UnaryToken {

    public static final String OPERATION = "abs";

    public AbsoluteVal() {
        super( OPERATION);
    }

    @Override    
    double[] UnaryEvaluate(List<EvaluatableToken> operands) {
        double[] op = operands.get(0).evaluate();
        double[] ret = {Math.abs(op[0]), Math.abs(op[1]), Math.abs(op[2])};

      return ret;
    }

}
