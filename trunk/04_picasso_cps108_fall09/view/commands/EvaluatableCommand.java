package view.commands;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import picasso.PicassoException;
import tokens.VariableHandler;
import util.Command;
import view.InputHandler;
import model.Pixmap;
import model.RGBColor;



/**
 * An abstract command with a name (e.g., to display on a button)
 * 
 * @author Robert C Duvall
 */
public class EvaluatableCommand implements Command<Pixmap>
{
    public static final double DOMAIN_MIN = -1;
    public static final double DOMAIN_MAX = 1;
    
    public void execute (Pixmap target)
    {
        try
        {
            InputHandler.myParser.makeExpression(InputHandler.getExpression());
            Dimension size = target.getSize();
            for (int imageY = 0; imageY < size.height; imageY++)
            {
                for (int imageX = 0; imageX < size.width; imageX++)
                {
                    setCoordinates(imageX, imageY, size);
                    double[] colorArray = InputHandler.myParser.evaluate();
                    RGBColor color =
                        new RGBColor(colorArray[0],
                                     colorArray[1],
                                     colorArray[2]);
                    target.setColor(imageX, imageY, color.toJavaColor());
                }
            }
        }
        catch (PicassoException exception)
        {
            InputHandler.setError();
            JOptionPane.showMessageDialog(new JFrame(),
                                          exception.getMessage(),
                                          "Error",
                                          JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void setCoordinates(int x, int y, Dimension size)
    {
        VariableHandler.setVariable("x", imageToDomainScale(x, (int)size.getWidth()));
        VariableHandler.setVariable("y", imageToDomainScale(y, (int)size.getHeight()));
    }
    
    /**
     * Convert from image space to domain space.
     */
    protected double imageToDomainScale (int value, int bounds)
    {
        double range = DOMAIN_MAX - DOMAIN_MIN;
        return ((double)value / bounds) * range + DOMAIN_MIN;
    }

}
