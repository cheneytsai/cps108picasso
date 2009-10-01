package tokens;

import picasso.Coordinates;

/**
 * ImageClip.java
 * Represents ImageClip function
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 * 
 */
public class ImageClip extends ImageWrap
{

    public static final String OPERATION = "imageClip";

    public ImageClip()
    {
        super(OPERATION);
    }

    @Override
    /**
     * Overrides imageWrap's calculate coordinates to calculate them in a different way
     */
    protected void calculateCoords(double x, double y)
    {
        if (x < Coordinates.DOMAIN_MIN)
            x = Coordinates.DOMAIN_MIN;
        else if (x > Coordinates.DOMAIN_MAX)
            x = Coordinates.DOMAIN_MAX - 1;
        if (y < Coordinates.DOMAIN_MIN)
            y = Coordinates.DOMAIN_MIN;
        else if (y > Coordinates.DOMAIN_MAX)
            y = Coordinates.DOMAIN_MAX - 1;
        shiftCoords(x, y);
    }
}
