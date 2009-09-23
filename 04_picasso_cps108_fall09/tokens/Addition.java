package tokens;

import java.awt.Dimension;
import java.util.List;
import java.util.ResourceBundle;

import picasso.PicassoException;


public class Addition extends Token {

    //public static final int ORDER_OF_OPERATION = 1;
    public static final String OPERATION = "+";
    public static final int NUM_OF_OPERANDS = 2;
    private static ResourceBundle myResources = ResourceBundle.getBundle("resources.OrderOfOperations");

    public Addition() {
        
        //super(NUM_OF_OPERANDS, OPERATION, ORDER_OF_OPERATION);
        super(NUM_OF_OPERANDS, OPERATION, Integer.parseInt(myResources.getString(OPERATION)));
    }
    
    @Override
    public double[] evaluate(int x, int y, Dimension size) {
        List<Token> operands = getOperands();
        
        if (getOperands().size() != NUM_OF_OPERANDS)
            throw new PicassoException(
                    "Incorrect number of operands to perform: " + OPERATION);
        
        double[] left = operands.get(1).evaluate(x, y, size);
        double[] right = operands.get(0).evaluate(x, y, size);
        double[] ret = {left[0] + right[0], left[1] + right[1], left[2] + right[2]};
        return ret;
    }

}
