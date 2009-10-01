package tokens;

import java.util.List;

import picasso.Coordinates;

/**
 * ImageWrap.java
 * 
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 * 
 */
public class ImageWrap extends MultiArgToken
{

    public static final String OPERATION = "imageWrap";

    public ImageWrap()
    {
        super(OPERATION);
    }

    public ImageWrap(String operation)
    {
        super(operation);
    }

    @Override
    double[] multiArgEvaluate(List<EvaluatableToken> operands)
    {
        double[] origX = VariableHandler.getValue("x");
        double[] origY = VariableHandler.getValue("y");
        calculateCoords(operands.get(1).evaluate()[0], operands.get(0)
                .evaluate()[0]);
        double[] ret = operands.get(2).evaluate();
        shiftCoords(origX[0], origY[0]);
        return ret;
    }

    protected void calculateCoords(double x, double y)
    {
        double range = Coordinates.DOMAIN_MAX - Coordinates.DOMAIN_MIN;
        if (x < Coordinates.DOMAIN_MIN)
            x += range;
        else if (x > Coordinates.DOMAIN_MAX)
            x -= range;
        if (y < Coordinates.DOMAIN_MIN)
            y += range;
        else if (y > Coordinates.DOMAIN_MAX)
            y -= range;
        shiftCoords(x, y);
    }

    protected void shiftCoords(double xValue, double yValue)
    {
        VariableHandler.setVariable("x", xValue);
        VariableHandler.setVariable("y", yValue);
    }

}
