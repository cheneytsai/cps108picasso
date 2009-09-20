package model;



public enum Expression
{
    PLUS
    {
        public RGBColor evaluate (RGBColor left, RGBColor right)
        {
            return new RGBColor(left.getRed() + right.getRed(), 
                                left.getGreen() + right.getGreen(),
                                left.getBlue() + right.getBlue());
        }
    },
    MINUS
    {
        public RGBColor evaluate (RGBColor left, RGBColor right)
        {
            return new RGBColor(left.getRed() - right.getRed(), 
                                left.getGreen() - right.getGreen(),
                                left.getBlue() - right.getBlue());
        }
    },
    TIMES
    {
        public RGBColor evaluate (RGBColor left, RGBColor right)
        {
            return new RGBColor(left.getRed() * right.getRed(), 
                                left.getGreen() * right.getGreen(),
                                left.getBlue() * right.getBlue());
        }
    },
    DIVIDE
    {
        public RGBColor evaluate (RGBColor left, RGBColor right)
        {
            return new RGBColor(left.getRed() / right.getRed(), 
                                left.getGreen() / right.getGreen(),
                                left.getBlue() / right.getBlue());
        }
    },
    PERLINCOLOR
    {
        /**
         * Generate Perlin noise based on the given values.
         * Algorithm described in detail at this site:
         *   http://freespace.virgin.net/hugo.elias/models/m_perlin.htm
         */
        public RGBColor evaluate (RGBColor left, RGBColor right)
        {
            return new RGBColor(
                ImprovedNoise.noise(left.getRed() + 0.3, right.getRed() + 0.3, 0),
                ImprovedNoise.noise(left.getGreen() - 0.8, right.getGreen() - 0.8, 0),
                ImprovedNoise.noise(left.getBlue() + 0.1, right.getBlue() + 0.1, 0));
        }
    },
    PERLINBW
    {
        /**
         * Generate Perlin noise based on the given values.
         * Algorithm described in detail at this site:
         *   http://freespace.virgin.net/hugo.elias/models/m_perlin.htm
         */
        public RGBColor evaluate (RGBColor left, RGBColor right)
        {
            double grey = ImprovedNoise.noise(left.getRed() + right.getRed(),
                                              left.getGreen() + right.getGreen(),
                                              left.getBlue() + right.getBlue());
            return new RGBColor(grey, grey, grey);
        }
    },
    RGB2YCRCR
    {
        /**
         * Convert color from RGB to YUV color space.
         * Details and constants derived from this site:
         *   http://www.answers.com/topic/yuv
         */
        public RGBColor evaluate (RGBColor c, RGBColor unused)
        {
            return new RGBColor(
                c.getRed() *  0.2989 + c.getGreen() *  0.5866 + c.getBlue() *  0.1145,
                c.getRed() * -0.1687 + c.getGreen() * -0.3312 + c.getBlue() *  0.5,
                c.getRed() *  0.5000 + c.getGreen() * -0.4183 + c.getBlue() * -0.0816);
        }
    },
    YCRC2RGBR
    {
        /**
         * Convert color from YUV to RGB color space.
         * Details and constants derived from this site:
         *   http://www.answers.com/topic/yuv
         */
        public RGBColor evaluate (RGBColor c, RGBColor unused)
        {
            return new RGBColor(
                c.getRed() + c.getBlue() *  1.4022,
                c.getRed() + c.getGreen() * -0.3456 + c.getBlue() * -0.7145,
                c.getRed() + c.getGreen() *  1.7710);
        }
    },
    INVERT
    {
        /**
         * Convert color from RGB to YUV color space.
         * Details and constants derived from this site:
         *   http://www.answers.com/topic/yuv
         */
        public RGBColor evaluate (RGBColor c, RGBColor unused)
        {
            return new RGBColor(
                -c.getRed(),
                -c.getGreen(),
                -c.getBlue());
        }
    };

    
    // Do arithmetic op represented by this constant
    abstract public RGBColor evaluate (RGBColor left, RGBColor right);
}
