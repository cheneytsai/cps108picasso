package tokens;

import java.awt.Dimension;

public class VarX extends Token {
    
    public static final int ORDER_OF_OPERATION = 0;
    public static final String OPERATION = "x";
    public static final int NUM_OF_OPERANDS = 0;

    public VarX() {
        super(NUM_OF_OPERANDS, OPERATION, ORDER_OF_OPERATION);
    }

    @Override
    public double[] evaluate(int x, int y, Dimension size) {
        double evalX = (x / (double)size.width) * 2 - 1;
        double[] ret = {evalX, evalX, evalX};
        return ret;
    }
  

}
