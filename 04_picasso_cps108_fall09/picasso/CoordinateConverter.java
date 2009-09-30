package picasso;

public abstract class CoordinateConverter {
    
    public static final double DOMAIN_MIN = -1;
    public static final double DOMAIN_MAX = 1;
    /**
     * Convert from image space to domain space.
     */
    public static double imageToDomainScale (int value, int bounds)
    {
        double range = DOMAIN_MAX - DOMAIN_MIN;
        return ((double)value / bounds) * range + DOMAIN_MIN;
    }
    
    public static int domainToImageScale(double value, int bounds)
    {
        double range = DOMAIN_MAX - DOMAIN_MIN;
        return (int)((value - DOMAIN_MIN) / range * bounds);
    }
}
