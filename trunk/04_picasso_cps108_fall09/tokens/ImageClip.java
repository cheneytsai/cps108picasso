package tokens;

import picasso.Coordinates;

public class ImageClip extends ImageWrap {
    
    public static final String OPERATION = "imageClip";
    
    public ImageClip()
    {
        super(OPERATION);
    }
    
    @Override
    protected void calculateCoords(double x, double y)
    {
        if (x < Coordinates.DOMAIN_MIN) x = Coordinates.DOMAIN_MIN;
        else if (x > Coordinates.DOMAIN_MAX) x = Coordinates.DOMAIN_MAX-1;
        if (y < Coordinates.DOMAIN_MIN) y = Coordinates.DOMAIN_MIN;
        else if (y > Coordinates.DOMAIN_MAX) y = Coordinates.DOMAIN_MAX-1;
        shiftCoords(x, y);
    }
}
