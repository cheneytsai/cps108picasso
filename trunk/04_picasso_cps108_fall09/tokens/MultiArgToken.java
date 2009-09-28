package tokens;

import java.util.List;


public abstract class MultiArgToken extends EvaluatableToken {
    
    public static final int NUM_OF_OPERANDS = 1;
    
    public MultiArgToken( String operation) {
        super(NUM_OF_OPERANDS, operation, Integer.parseInt(myOOPResources.getString("Function")));
    }

    @Override
    public double[] evaluate() {
        checkNumOperands();
        List<EvaluatableToken> operands = getOperands();
        if (!(operands.get(0) instanceof Comma))
            return multiArgEvaluate(operands);
        return multiArgEvaluate(((Comma)operands.get(0)).chainTokens());
    }
    
    abstract double[] multiArgEvaluate(List<EvaluatableToken> operands);

}
