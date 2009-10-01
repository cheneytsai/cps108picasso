package view.commands;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import picasso.Coordinates;
import picasso.PicassoException;
import tokens.VariableHandler;
import util.Command;
import view.InputHandler;
import model.Pixmap;
import model.RGBColor;

/**
 * EvaluatableCommand.java
 * 
 * A command which can evaluate the current expression stored in InputHandler
 * using the parser in InputHandler.
 * 
 * @author Robert C Duvall
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 */
public class EvaluatableCommand implements Command<Pixmap>
{

    /**
     * Calls the parser to make the expression out of the current string, then
     * updates the Pixmap to the new image.
     * 
     * @param Pixmap
     *            to be updated with the evaluated expression.
     */
    public void execute(Pixmap target)
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
                    RGBColor color = new RGBColor(colorArray[0], colorArray[1],
                            colorArray[2]);
                    target.setColor(imageX, imageY, color.toJavaColor());
                }
            }
        } catch (PicassoException exception)
        {
            InputHandler.setError();
            JOptionPane.showMessageDialog(new JFrame(), exception.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setCoordinates(int x, int y, Dimension size)
    {
        VariableHandler.setVariable("x", Coordinates.imageToDomainScale(x,
                (int) size.getWidth()));
        VariableHandler.setVariable("y", Coordinates.imageToDomainScale(y,
                (int) size.getHeight()));
    }

}
