package tokens;

import java.util.ResourceBundle;



public class Exponentiate extends BinaryToken {

    public static final String OPERATION = "^";
    private static ResourceBundle myResources = ResourceBundle.getBundle("resources.OrderOfOperations");

    public Exponentiate() {
        
        //super(NUM_OF_OPERANDS, OPERATION, ORDER_OF_OPERATION);
        super(OPERATION, Integer.parseInt(myResources.getString(OPERATION)));
    }
    
    @Override
        double[] binaryEvaluate(double[] left, double[] right) {
        double[] ret = {Math.pow(left[0],right[0]), Math.pow(left[1],right[1]), Math.pow(left[2],right[2])};
        return ret;
    }

}
