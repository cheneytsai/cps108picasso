package tokens;

import java.util.List;

import picasso.Coordinates;


public class Clamp extends UnaryToken {

    public static final String OPERATION = "clamp";

    public Clamp() {
        super( OPERATION);
    }

    @Override    
    double[] UnaryEvaluate(List<EvaluatableToken> operands) {
        double[] ret = ClampFunc(operands.get(0).evaluate());
      return ret;
    }
    
    @SuppressWarnings("null")
    double[] ClampFunc(double[] op)
    {
        double[] result = new double[3] ;
        for(int i = 0; i < op.length; i++)
        {
            if (op[i] > Coordinates.DOMAIN_MAX)
            result[i] = Coordinates.DOMAIN_MAX;
            else if (op[i] < Coordinates.DOMAIN_MIN)
            result[i] = Coordinates.DOMAIN_MIN;
            else
            result[i]=op[i];
        }
        return result;
    }
}
