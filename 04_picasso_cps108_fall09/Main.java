import java.awt.Dimension;
import java.util.ResourceBundle;

import tokens.TokenHandler;
import util.Utils;
import view.Frame;


/**
 * @author Robert Duvall (rcd@cs.duke.edu)
 */
public class Main
{
    public static final Dimension SIZE = Utils.FRAME_LARGE.size();
    private static ResourceBundle myResources = ResourceBundle.getBundle("resources.English");

    public static void main (String[] args)
    {        
        TokenHandler.tokenMapGenerator();
        Frame frame = new Frame(myResources.getString("FrameTitle"), SIZE);
        frame.setVisible(true);
    }
}
