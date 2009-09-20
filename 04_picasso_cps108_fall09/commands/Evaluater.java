package commands;

import java.awt.Dimension;
import javax.swing.JComboBox;
import model.Pixmap;
import model.RGBColor;
import model.Expression;


public class Evaluater extends Command
{
    public Evaluater ()
    {
        super("Evaluate");
    }


    /**
     * Evaluate an expression for eac=h point in the image.
     */
    public void execute (Pixmap target)
    {
        Dimension size = target.getSize();
        for (int imageY = 0; imageY < size.height; imageY++)
        {
            double evalY = (imageY / (double)size.height) * 2 - 1;
            RGBColor colorY = new RGBColor(evalY, evalY, evalY);
            for (int imageX = 0; imageX < size.width; imageX++)
            {
                double evalX = (imageX / (double)size.width) * 2 - 1;
                RGBColor colorX = new RGBColor(evalX, evalX, evalX);
                target.setColor(imageX, imageY,
                                createExpression().evaluate(colorX, colorY).toJavaColor());
            }
        }
    }
    
    
    private Expression createExpression ()
    {
        // BUGBUG: let the user set this, could use code like this:
        //JComboBox box = new JComboBox();
        //for (Expression expr : Expression.values())
        //{
        //    box.addItem(expr);
        //}
        return Expression.DIVIDE;
    }
}
