package tokens;

import java.util.List;
import java.util.ResourceBundle;

import model.ImprovedNoise;

public class PerlinColor extends MultiArgToken {

    public static final String OPERATION = "perlinColor";

    public PerlinColor() {
        super( OPERATION);
    }
//
//    @Override
//    public double[] evaluate() {
//        List<EvaluatableToken> operands = getOperands();
//        EvaluatableToken operand = operands.get(0);
//        if (!(operand instanceof Comma)) {
//            System.out.println(operands.size());
//            return operand.evaluate();
//        }
//
//       operands = ((Comma) operand).chainTokens();
//    
//        double[] left = operands.get(1).evaluate();
//        double[] right = operands.get(0).evaluate();
//        double[] ret = {
//                ImprovedNoise.noise(left[0] + 0.3, right[0] + 0.3, 0), 
//                ImprovedNoise.noise(left[1] - 0.8, right[1] - 0.8, 0), 
//                ImprovedNoise.noise(left[2] + 0.1, right[2] + 0.1, 0)};
//       
//
//
//        return ret;
//    }

    @Override
    double[] multiArgEvaluate(List<EvaluatableToken> operands) {
      double[] left = operands.get(1).evaluate();
      double[] right = operands.get(0).evaluate();
      double[] ret = {
              ImprovedNoise.noise(left[0] + 0.3, right[0] + 0.3, 0), 
              ImprovedNoise.noise(left[1] - 0.8, right[1] - 0.8, 0), 
              ImprovedNoise.noise(left[2] + 0.1, right[2] + 0.1, 0)};
     


      return ret;
    }

}
