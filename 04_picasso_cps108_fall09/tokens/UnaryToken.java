package tokens;

import java.util.List;


public abstract class UnaryToken extends EvaluatableToken {
    
    public static final int NUM_OF_OPERANDS = 1;
    
    public UnaryToken( String operation) {
        super(NUM_OF_OPERANDS, operation, Integer.parseInt(myOOPResources.getString("Function")));
    }

    @Override
    public double[] evaluate() {
        checkNumOperands();
        List<EvaluatableToken> operands = getOperands();
        return UnaryEvaluate(operands);
    }
    
    abstract double[] UnaryEvaluate(List<EvaluatableToken> operands);

}
