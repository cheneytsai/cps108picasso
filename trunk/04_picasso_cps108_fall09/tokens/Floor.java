package tokens;

/**
 * Floor.java
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 *
 */
import java.util.List;

public class Floor extends UnaryToken
{

    public static final String OPERATION = "floor";

    public Floor()
    {
        super(OPERATION);
    }

    @Override
    double[] UnaryEvaluate(List<EvaluatableToken> operands)
    {
        double[] op = operands.get(0).evaluate();
        double[] ret =
        { Math.floor(op[0]), Math.floor(op[1]), Math.floor(op[2]) };
        return ret;
    }

}
