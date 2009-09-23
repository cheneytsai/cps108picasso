package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import picasso.PicassoParser;
import model.Pixmap;
import model.RGBColor;


/**
 * The collection of commands to apply to the active image.
 * 
 * @author Robert C Duvall
 */
@SuppressWarnings("serial")
public class TextPanel extends JPanel
{
    private static final int DELAY = 400;

    private Pixmap myPixmap;
    private Canvas myView;
    private boolean isDone;
    private Thread myPainter;
    private Thread myRenderer;
    private JTextField inputField;
    private static ResourceBundle myResources = ResourceBundle.getBundle("resources.English");
    private picasso.PicassoParser myParser;
    

    public TextPanel (Canvas view)
    {
        myView = view;
        isDone = true;
        makePanel();
        myPixmap = myView.getPixmap();
        myParser = new PicassoParser();
    }
    
    public void makePanel ()
    {
        inputField = new JTextField(30);
        
        this.setBorder(BorderFactory.createTitledBorder(myResources.getString("ExpressionTitle")));
        this.add(inputField, BorderLayout.CENTER);

        JButton evaluate = new JButton(myResources.getString("EvaluateCommand"));
        evaluate.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent e)
            {
                //String str = myParser.stringFormat(inputField.getText());
                myParser.makeExpression(inputField.getText());
                execute(myPixmap);
            }
        });
        this.add(evaluate, BorderLayout.EAST);
    }    

        protected void applyCommand ()
        {
            if (isDone)
            {
                isDone = false;
                myPixmap = myView.getPixmap();

                myRenderer = new Thread(new Renderer());
                myPainter = new Thread(new Painter());
                myRenderer.start();
                myPainter.start();
            }
            else
            {
                isDone = true;
            }
        }


        class Painter implements Runnable
        {
            public void run ()
            {
                try
                {
                    while (!isDone)
                    {
                        Thread.sleep(DELAY);
                        myView.refresh();
                    }
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }

        class Renderer implements Runnable
        {
            public void run ()
            {
                execute(myPixmap);
                myView.refresh();
                isDone = true;
            }
         }
        public void execute (Pixmap target)
        {
            Dimension size = target.getSize();
            for (int imageY = 0; imageY < size.height; imageY++)
            {
                for (int imageX = 0; imageX < size.width; imageX++)
                {
                    double[] colorArray = myParser.evaluate(imageX, imageY, size);
                    RGBColor color = new RGBColor(colorArray[0], colorArray[1], colorArray[2]);
                    target.setColor(imageX, imageY, color.toJavaColor());
                }
            }
            myView.refresh();
        }
}
