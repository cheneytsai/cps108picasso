package view.commands;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import util.Command;
import util.FrameDimensions;
import view.Canvas;
import model.Pixmap;


/**
 * An abstract command which can be evaluated. This command opens a new preview
 * window and uses that Pixmap to display the evaluation.
 * 
 * @author Jimmy Shedlick
 */
public class Preview extends EvaluatableCommand implements Command<Pixmap>
{
    private static ResourceBundle myResources =
        ResourceBundle.getBundle("resources.English");


    public void execute (Pixmap target)
    {
        PreviewFrame frame =
            new PreviewFrame(myResources.getString("PreviewTitle"),
                             FrameDimensions.FRAME_MEDIUM.size());
        frame.setVisible(true);
        super.execute(frame.getView().getPixmap());
        frame.getView().refresh();
    }

    @SuppressWarnings("serial")
    class PreviewFrame extends JFrame
    {
        private Canvas myCanvas;


        public PreviewFrame (String title, Dimension size)
        {
            setTitle(title);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            myCanvas = new Canvas(this);
            myCanvas.setSize(size);

            getContentPane().add(myCanvas, BorderLayout.CENTER);
            pack();
        }


        private Canvas getView ()
        {
            return myCanvas;
        }
    }

}
