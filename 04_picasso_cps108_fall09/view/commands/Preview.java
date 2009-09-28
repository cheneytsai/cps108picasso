package view.commands;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import util.Command;
import util.Utils;
import view.Canvas;
import model.Pixmap;


/**
 * An abstract command with a name (e.g., to display on a button)
 * 
 * @author Robert C Duvall
 */
public class Preview extends ExpressionCommand implements Command<Pixmap>
{
    private static ResourceBundle myResources = ResourceBundle.getBundle("resources.English");

    public void execute (Pixmap target) {
        PreviewFrame frame = new PreviewFrame(myResources.getString("PreviewTitle"), Utils.FRAME_MEDIUM.size());
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

            // create GUI components
            myCanvas = new Canvas(this);
            myCanvas.setSize(size);

            // add our container to Frame and show it
            getContentPane().add(myCanvas, BorderLayout.CENTER);
            pack();
        }


        private Canvas getView ()
        {
            return myCanvas;
        }
    }

}
