package tokens;

public class Exponentiate extends BinaryToken {

    public static final String OPERATION = "^";

    public Exponentiate() {
        
        super(OPERATION, Integer.parseInt(myOOPResources.getString(OPERATION)));
    }
    
    @Override
        double[] binaryEvaluate(double[] left, double[] right) {
        double[] ret = {Math.pow(left[0],right[0]), Math.pow(left[1],right[1]), Math.pow(left[2],right[2])};
        return ret;
    }

}
