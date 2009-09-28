package tokens;

import java.util.List;


public abstract class MultiArgToken extends EvaluatableToken {
    
    public static final int NUM_OF_OPERANDS = 1;
    public static final int ORDER_OF_OPERATION = 5;
    
    public MultiArgToken( String operation) {
        super(NUM_OF_OPERANDS, operation, ORDER_OF_OPERATION);
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
