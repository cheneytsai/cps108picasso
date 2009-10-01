package model;

import java.awt.Color;

public class RGBColor
{
    public static final double COLOR_MIN = -1;
    public static final double COLOR_MAX = 1;
    public static final int JAVA_COLOR_MAX = 255; // should be defined in Color

    private double myRed;
    private double myGreen;
    private double myBlue;

    public RGBColor(double red, double green, double blue)
    {
        myRed = red;
        myGreen = green;
        myBlue = blue;
    }

    public RGBColor(Color javaColor)
    {
        myRed = toDouble(javaColor.getRed());
        myGreen = toDouble(javaColor.getGreen());
        myBlue = toDouble(javaColor.getBlue());
    }

    public double getRed()
    {
        return myRed;
    }

    public double getGreen()
    {
        return myGreen;
    }

    public double getBlue()
    {
        return myBlue;
    }

    public void clamp()
    {
        myRed = clamp(myRed);
        myGreen = clamp(myGreen);
        myBlue = clamp(myBlue);
    }

    public Color toJavaColor()
    {
        clamp();
        return new Color(toInt(myRed), toInt(myGreen), toInt(myBlue));
    }

    public boolean equals(Object o)
    {
        if (o instanceof RGBColor)
        {
            RGBColor other = (RGBColor) o;
            return myRed == other.myRed && myGreen == other.myGreen
                    && myBlue == other.myBlue;
        }
        return false;
    }

    public String toString()
    {
        return getRed() + " " + getGreen() + " " + getBlue();
    }

    protected double toDouble(int value)
    {
        double range = COLOR_MAX - COLOR_MIN;
        return (double) value / JAVA_COLOR_MAX * range + COLOR_MIN;
    }

    protected int toInt(double value)
    {
        double range = COLOR_MAX - COLOR_MIN;
        return (int) ((value - COLOR_MIN) / range * JAVA_COLOR_MAX);
    }

    protected double clamp(double value)
    {
        return Math.max(COLOR_MIN, Math.min(COLOR_MAX, value));
    }
}
