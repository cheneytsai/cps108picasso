package tokens;

import java.awt.Color;
import java.awt.Dimension;

import picasso.Coordinates;

import model.Pixmap;
import model.RGBColor;

public class Image extends EvaluatableToken {
    
    public static final int NUM_OF_OPERANDS = 0;
    private Pixmap myImage;
    
    public Image(String fileName) {
        super(NUM_OF_OPERANDS, null, Integer.parseInt(myOOPResources.getString("Constant")));
        myImage = new Pixmap(fileName);
    }
    
    private int[] getCoords()
    {
        Dimension size = myImage.getSize();
        int xCoord = Coordinates.domainToImageScale(VariableHandler.getValue("x")[0], size.width);
        int yCoord = Coordinates.domainToImageScale(VariableHandler.getValue("y")[0], size.height);
        int[] ret = {xCoord, yCoord};
        return ret;
    }
    @Override
    public double[] evaluate() {
        int[] coords = getCoords();
        RGBColor c = new RGBColor(myImage.getColor(coords[0], coords[1]));
        double[] ret = {c.getRed(), c.getGreen(), c.getBlue()};
        return ret;
    }

}
