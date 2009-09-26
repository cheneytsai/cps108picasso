package tokens;

import java.util.List;

public class Division extends BinaryToken {
    
    public static final int ORDER_OF_OPERATION = 2;
    public static final String OPERATION = "/";

    public Division() {
        super(OPERATION, ORDER_OF_OPERATION);
    }

    @Override
    double[] binaryEvaluate(double[] left, double[] right) {
        double[] ret = {left[0] / right[0], left[1] / right[1], left[2] / right[2]};
        return ret;
    }
    
    

}
