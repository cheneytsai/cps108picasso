package picasso;

/**
 * Coordinates.java
 * Handles coordinate conversion
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 * 
 */
public abstract class Coordinates
{

    public static final double DOMAIN_MIN = -1;
    public static final double DOMAIN_MAX = 1;

    /**
     * Convert from image space to domain space
     * @param value
     * @param bounds
     * @return
     */
    public static double imageToDomainScale(int value, int bounds)
    {
        double range = DOMAIN_MAX - DOMAIN_MIN;
        return ((double) value / bounds) * range + DOMAIN_MIN;
    }
    
    /**
     * Convert from domain space to image space
     * @param value
     * @param bounds
     * @return
     */
    public static int domainToImageScale(double value, int bounds)
    {
        double range = DOMAIN_MAX - DOMAIN_MIN;
        return (int) ((value - DOMAIN_MIN) / range * bounds);
    }
}
