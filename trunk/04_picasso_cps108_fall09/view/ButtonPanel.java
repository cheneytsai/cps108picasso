package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;
import model.Pixmap;
import commands.Command;


/**
 * The collection of commands to apply to the active image.
 * 
 * @author Robert C Duvall
 */
@SuppressWarnings("serial")
public class ButtonPanel extends JPanel
{
    private static final int DELAY = 400;

    private Canvas myView;
    private boolean isDone;
    private Thread myPainter;
    private Thread myRenderer;


    public ButtonPanel (Canvas view)
    {
        myView = view;
        isDone = true;
    }
    
    
    public void add (Command c)
    {
        add(new CommandButton(c, myView));
    }
    
    

    class CommandButton extends JButton
    {
        private Canvas myCanvas;
        private Command myCommand;
        private Pixmap myPixmap;


        public CommandButton (Command command, Canvas canvas)
        {
            super(command.getName());
            myCanvas = canvas;
            myCommand = command;

            // perform command when button is clicked
            addActionListener(new ActionListener()
                {
                    public void actionPerformed (ActionEvent e)
                    {
                        applyCommand();
                    }
                });
        }

        protected void applyCommand ()
        {
            if (isDone)
            {
                isDone = false;
                myPixmap = myCanvas.getPixmap();

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
                myCommand.execute(myPixmap);
                myView.refresh();
                isDone = true;
            }
        }
    }
}
