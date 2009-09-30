package tokens;

import java.util.List;

import picasso.CoordinateConverter;

public class ImageWrap extends MultiArgToken {

    public static final String OPERATION = "imageWrap";
    
    public ImageWrap() {
        super(OPERATION);       
    }

    @Override
    double[] multiArgEvaluate(List<EvaluatableToken> operands) {
        double origX = VariableHandler.getValue("x");
        double origY = VariableHandler.getValue("y");
        calculateCoords(operands.get(1).evaluate()[0], operands.get(0).evaluate()[0]);
        double[] ret = operands.get(2).evaluate();
        shiftCoords(origX, origY);
        return ret;
    }
    
    protected void calculateCoords(double x, double y)
    {
        double range = CoordinateConverter.DOMAIN_MAX - CoordinateConverter.DOMAIN_MIN;
        if (x < CoordinateConverter.DOMAIN_MIN) x += range;
        else if (x > CoordinateConverter.DOMAIN_MAX) x -= range;
        if (y < CoordinateConverter.DOMAIN_MIN) y += range;
        else if (y > CoordinateConverter.DOMAIN_MAX) y -= range;
        shiftCoords(x, y);
    }
    
    protected void shiftCoords(double xValue, double yValue)
    {
        VariableHandler.setVariable("x", xValue);
        VariableHandler.setVariable("y", yValue);
    }
    
    

}
