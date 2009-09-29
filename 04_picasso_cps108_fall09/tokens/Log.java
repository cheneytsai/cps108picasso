package tokens;

import java.util.List;


public class Log extends UnaryToken {

    public static final String OPERATION = "log";

    public Log() {
        super( OPERATION);
    }

    @Override    
    double[] UnaryEvaluate(List<EvaluatableToken> operands) {
        double[] op = operands.get(0).evaluate();
        double[] ret = {Math.log(Math.abs(op[0])), Math.log(Math.abs(op[1])), Math.log(Math.abs(op[2]))};
      return ret;
    }

}
