package tokens;

import java.awt.Dimension;

public class VarY extends Token {

    public static final int ORDER_OF_OPERATION = 0;
    public static final String OPERATION = "y";
    public static final int NUM_OF_OPERANDS = 0;

    public VarY() {
        super(NUM_OF_OPERANDS, OPERATION, ORDER_OF_OPERATION);
    }
    @Override
    public double[] evaluate(int x, int y, Dimension size) {
        double evalY = (y / (double)size.height) * 2 - 1;
        double[] ret = {evalY, evalY, evalY};
        return ret;
    }

}
