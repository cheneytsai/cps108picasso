package tokens;

import picasso.PicassoException;

public class Assignment extends EvaluatableToken {
    
    public static final String OPERATION = "=";
    public static final int NUM_OF_OPERANDS = 2;
    
    public Assignment() {
        super(NUM_OF_OPERANDS, OPERATION, Integer.parseInt(myOOPResources.getString(OPERATION)));
    }

    @Override
    public double[] evaluate() {
        if (getOperands().size() != NUM_OF_OPERANDS)
            throw new PicassoException(
                    "Incorrect number of operands to perform: " + OPERATION);
        if (!(getOperands().get(1) instanceof Variable))
        {
            throw new PicassoException("Invalid Assignment");
        }
        Variable var = (Variable) getOperands().get(1);
        EvaluatableToken value = getOperands().get(0);
        VariableHandler.setVariable(var.getName(), value);
        return value.evaluate();
    }
    

}