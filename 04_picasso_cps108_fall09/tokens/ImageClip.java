package tokens;

import picasso.CoordinateConverter;

public class ImageClip extends ImageWrap {
    @Override
    protected void calculateCoords(double x, double y)
    {
        if (x < CoordinateConverter.DOMAIN_MIN) x = CoordinateConverter.DOMAIN_MIN;
        else if (x > CoordinateConverter.DOMAIN_MAX) x = CoordinateConverter.DOMAIN_MAX-1;
        if (y < CoordinateConverter.DOMAIN_MIN) y = CoordinateConverter.DOMAIN_MIN;
        else if (y > CoordinateConverter.DOMAIN_MAX) y = CoordinateConverter.DOMAIN_MAX-1;
        shiftCoords(x, y);
    }
}
